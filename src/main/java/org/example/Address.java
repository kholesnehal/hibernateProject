package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //for auto increment
    @Column(name="addressId")
    private int addressId;

    @Column(length =40,name = "STREET")
    private String street;

    @Column(length = 60,name = "CITY")
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient
    private double x;

    @Column(name="add_date")
    @Temporal(TemporalType.DATE)//format date

    private Date addedDate;

    @Lob
    private byte[] image;

}
