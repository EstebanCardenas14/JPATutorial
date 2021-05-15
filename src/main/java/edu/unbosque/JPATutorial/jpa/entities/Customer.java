package edu.unbosque.JPATutorial.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer") // Optional
public class Customer {
    @Id
    @Column(name = "email")
    private Integer email;

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

    public Customer(Integer email, String first_name, String last_name, String gender, Integer age) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
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
