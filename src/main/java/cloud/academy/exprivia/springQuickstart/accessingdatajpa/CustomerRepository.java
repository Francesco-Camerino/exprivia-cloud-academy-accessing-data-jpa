package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 *Utilizzando questa interfaccia CustomerRepository,
 * possiamo utilizzare tutti i metodi predefiniti forniti da CrudRepository (come save, delete, ecc.)
 * per gestire i dati dell'entità Customer nel database. Inoltre, possiamo utilizzare i metodi personalizzati
 * come findByLastName e findById per eseguire query specifiche per recuperare dati in base ai criteri
 * specificati. Tutto questo è reso possibile grazie a Spring Data JPA, che offre un'implementazione dietro
 * le quinte per fornire l'accesso ai dati in modo semplice e conveniente.
  */
/**
 * L'interfaccia CustomerRepository fornisce una repository per accedere e gestire i dati relativi ai clienti nel database.
 * Estende l'interfaccia Spring Data JPA CrudRepository, che fornisce metodi predefiniti per le operazioni CRUD (Create, Read, Update, Delete).
 * La repository è associata all'entità "Customer" (Cliente) e utilizza il tipo di dato Long come chiave primaria.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    /**
     * Recupera una lista di clienti dal database in base al cognome fornito.
     *
     * @param lastName Il cognome dei clienti da cercare.
     * @return Una lista di oggetti Customer che corrispondono al cognome fornito.
     */
    List<Customer> findByLastName(String lastName);

    /**
     * Recupera un cliente dal database in base all'ID fornito (chiave primaria).
     *
     * @param id L'ID (chiave primaria) del cliente da recuperare.
     * @return L'oggetto Customer con l'ID corrispondente, o null se non trovato.
     */
    Customer findById(long id);
}
