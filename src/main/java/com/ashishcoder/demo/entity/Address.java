package com.ashishcoder.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_no")
    private int houseNo;

    @Column(name = "location")
    private String location;

    @Column(name = "zipcode")
    private int zipcode;

    @OneToOne(mappedBy = "address" , cascade = CascadeType.ALL)
    private Person person ;

    public Address() {
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (houseNo != address.houseNo) return false;
        if (zipcode != address.zipcode) return false;
        return Objects.equals(location, address.location);
    }

    @Override
    public int hashCode() {
        int result = houseNo;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + zipcode;
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNo=" + houseNo +
                ", location='" + location + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
