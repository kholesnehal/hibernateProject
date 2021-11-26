package com.relationshipOneToOne;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student1
{
    @Id
    @Column(name="student_id")
    private int studentId;
    private String studentName;
    private String address;
    @OneToOne
    private College college;

}
