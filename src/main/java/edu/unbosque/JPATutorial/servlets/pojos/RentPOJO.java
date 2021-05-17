package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.Date;

public class RentPOJO {

    private String rent_id;

    private String email;

    private Integer edition_id;

    private Date renting_date;

    public RentPOJO(String rent_id, String email, Integer edition_id, Date renting_date) {
        this.rent_id = rent_id;
        this.email = email;
        this.edition_id = edition_id;
        this.renting_date = renting_date;
    }

    public String getRent_id() {
        return rent_id;
    }

    public void setRent_id(String rent_id) {
        this.rent_id = rent_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(Integer edition_id) {
        this.edition_id = edition_id;
    }

    public Date getRenting_date() {
        return renting_date;
    }

    public void setRenting_date(Date renting_date) {
        this.renting_date = renting_date;
    }
}
