package cloud.academy.exprivia.springQuickstart.accessingdatajpa;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    private Integer age;

    private LocalDate insertedDate;

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
    public Customer(String firstName, String lastName, Integer age, String stringDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.insertedDate = DateUtility.getLocalDateFormString(stringDate);
    }

    /**
     * Restituisce una rappresentazione testuale dell'oggetto Customer.
     *
     * @return Una stringa che contiene l'ID, il nome e il cognome del cliente.
     */
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', age='%d', insertedDate='%s']",
                id, firstName, lastName, age,DateUtility.getStringFromLocalDate(insertedDate));
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

    private Integer getAge() {return age; }

    public LocalDate getInsertedDate() {
        return insertedDate;
    }
}