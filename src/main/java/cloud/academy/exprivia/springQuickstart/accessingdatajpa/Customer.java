package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
* La classe Customer rappresenta un cliente con un identificatore univoco (id), un nome (firstName) e un cognome (lastName).
 * Questa classe è annotata con @Entity per indicare che è una classe di entità JPA e sarà mappata su una tabella del database.
 */
@Entity
public class Customer {

    /**
     * Identificatore univoco del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nome del cliente.
     */
    private String firstName;

    /**
     * Cognome del cliente.
     */
    private String lastName;

    /**
     * Costruttore protetto per JPA. Viene utilizzato solo internamente e non deve essere utilizzato direttamente.
     */
    protected Customer() {}

    /**
     * Costruttore della classe Customer.
     *
     * @param firstName Nome del cliente.
     * @param lastName  Cognome del cliente.
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Restituisce una rappresentazione testuale dell'oggetto Customer.
     *
     * @return Una stringa che contiene l'ID, il nome e il cognome del cliente.
     */
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    /**
     * Restituisce l'identificatore univoco del cliente.
     *
     * @return L'ID del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Restituisce il nome del cliente.
     *
     * @return Il nome del cliente.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Restituisce il cognome del cliente.
     *
     * @return Il cognome del cliente.
     */
    public String getLastName() {
        return lastName;
    }
}