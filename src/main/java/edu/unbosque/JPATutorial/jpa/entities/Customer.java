package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer") // Optional
@NamedQueries({
        @NamedQuery(name = "Customer.findByEmail",
                query = "SELECT a FROM Customer a WHERE a.email = :email")
})
public class Customer {
    @Id
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    //configure one to many whit rent
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();


    public Customer() {

    }

    public Customer(String email, String first_name, String last_name, String gender, Integer age) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void addRents(Rent rent) {
        rents.add(rent);
        rent.setCustomer(this);
    }

}
