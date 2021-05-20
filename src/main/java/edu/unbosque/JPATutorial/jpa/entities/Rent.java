package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rent")
@NamedQueries({
        @NamedQuery(name = "Rent.findByDate",
                query = "SELECT b FROM Rent b WHERE b.renting_Date = :renting_Date"),
        @NamedQuery(name = "Rent.findAll",
                query = "SELECT b FROM Rent b"),
        @NamedQuery(name = "Rent.findByEmail",
                query = "SELECT b FROM Rent b WHERE  b.customer.email = :email")
})
public class Rent {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private String rent_id;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    @Column(name = "renting_Date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date renting_Date;

    public Rent() {

    }

    public Rent(Date renting_Date) {
        this.renting_Date = renting_Date;
    }



    public String getRent_id() {
        return rent_id;
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Date getRenting_Date() {
        return renting_Date;
    }

    public void setRenting_Date(Date renting_Date) {
        this.renting_Date = renting_Date;
    }




}
