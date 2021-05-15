package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rent")
public class Rent {

    @Id
    @Column(name = "rent_id")
    @GeneratedValue
    private String rent_id;

    @ManyToOne
    @JoinColumn(name = "email")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;

    @Column(nullable = false)
    private Date renting_Date;

    public Rent() {

    }

    public Rent(String rent_id, Date renting_Date) {
        this.rent_id = rent_id;
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
