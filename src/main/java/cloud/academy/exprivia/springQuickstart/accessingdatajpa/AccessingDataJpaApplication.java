package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * La classe AccessingDataJpaApplication è la classe principale dell'applicazione Spring Boot.
 * Questa classe è annotata con @SpringBootApplication, che è una comoda annotazione che combina le seguenti annotazioni:
 *
 * @Configuration: Indica che questa classe è una configurazione di Spring e definisce bean per il contesto dell'applicazione.
 * @EnableAutoConfiguration: Indica a Spring Boot di iniziare ad aggiungere bean in base alle impostazioni della classpath, ad altri bean
 * e alle varie impostazioni delle proprietà. Ad esempio, se spring-webmvc è nel classpath, questa annotazione segnala l'applicazione
 * come applicazione web e attiva comportamenti chiave, come la configurazione di un DispatcherServlet.
 * @ComponentScan: Indica a Spring di cercare altri componenti, configurazioni e servizi nel package cloud.academy.exprivia.springQuickstart.accessingdatajpa,
 * consentendogli di individuare i controller.
 */
@SpringBootApplication
public class AccessingDataJpaApplication {

	/**
	 * Logger per la classe AccessingDataJpaApplication. Viene utilizzato per scrivere i log per l'applicazione.
	 */
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	/**
	 * Metodo main dell'applicazione. Viene eseguito all'avvio dell'applicazione e avvia il contesto di Spring Boot.
	 *
	 * @param args Gli argomenti passati all'applicazione all'avvio.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	/**
	 * Metodo che viene eseguito al momento dell'avvio dell'applicazione. Questo metodo viene eseguito dopo che il contesto di Spring Boot
	 * è stato completamente inizializzato. Il metodo restituisce un CommandLineRunner, che viene eseguito subito dopo l'avvio
	 * dell'applicazione. Questo metodo viene utilizzato per popolare il database con alcuni dati di esempio e per eseguire alcune
	 * query di ricerca.
	 *
	 * @param repository L'oggetto CustomerRepository utilizzato per accedere al database e interagire con i dati dei clienti.
	 * @return Un CommandLineRunner che esegue le operazioni di popolamento del database e di ricerca dei dati.
	 */
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Salva alcuni clienti nel database
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// Recupera tutti i clienti dal database e li stampa
			log.info("Clienti trovati con findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// Recupera un singolo cliente dal database utilizzando l'ID e lo stampa
			Customer customer = repository.findById(1L);
			log.info("Cliente trovato con findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// Recupera i clienti dal database utilizzando il cognome e li stampa
			log.info("Clienti trovati con findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}
}
