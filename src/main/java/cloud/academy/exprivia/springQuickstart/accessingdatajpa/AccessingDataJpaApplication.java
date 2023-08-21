package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

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
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
			repository.save(new Customer("Jack", "Bauer",25,"01/01/2001"));
			repository.save(new Customer("Chloe", "O'Brian",31,"02/02/2002"));
			repository.save(new Customer("Kim", "Bauer",21,"03/03/2003"));
			repository.save(new Customer("David", "Palmer",45,"04/04/2004"));
			repository.save(new Customer("Michelle", "Dessler",18,"05/05/2005"));

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

			// Recupera i clienti dal database in base al nome e al cognome e li stampa
			log.info("Clienti trovati con findByFirstNameAndLastName('Jack', 'Bauer'):");
			log.info("--------------------------------------------");
			repository.findByFirstNameAndLastName("Jack", "Bauer").forEach(person -> {
				log.info(person.toString());
			});
			log.info("");

			// Recupera i clienti dal database in base al cognome contenente un valore specifico e li stampa
			log.info("Clienti trovati con findByLastNameContaining('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastNameContaining("Bauer").forEach(person -> {
				log.info(person.toString());
			});
			log.info("");

			// Recupera i clienti dal database con un'età maggiore di un valore specifico e li stampa
			log.info("Clienti trovati con findByAgeGreaterThan(30):");
			log.info("--------------------------------------------");
			repository.findByAgeGreaterThan(30).forEach(person -> {
				log.info(person.toString());
			});
			log.info("");

			// Recupera i clienti dal database con l'età inferirore al valore specificato e li stampa
			log.info("Clienti trovati con findByAgeLessThan(30):");
			log.info("--------------------------------------------");
			repository.findByAgeLessThan(30).forEach(person -> {
				log.info(person.toString());
			});
			log.info("");

			// Recupera i clienti dal database con una data specifica e li stampa
			log.info("Clienti trovati con findByInsertedDate(01/01/2001):");
			log.info("--------------------------------------------");
			repository.findByInsertedDate(DateUtility.getDateFormString("01/01/2001")).forEach(person -> {
				log.info(person.toString());
			});
			log.info("");

			// Recupera i clienti dal database con una data maggiore di un valore specifico e li stampa
			log.info("Clienti trovati con findByInsertedDateGreaterThan(01/01/2001):");
			log.info("--------------------------------------------");
			repository.findByInsertedDateGreaterThan(DateUtility.getDateFormString("01/01/2001")).forEach(person -> {
				log.info(person.toString());
			});
			log.info("");
		};
	}
}
