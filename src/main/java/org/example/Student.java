package org.example;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Student {
    @Id
    private int id;
    private String name;
    private String city;


}
