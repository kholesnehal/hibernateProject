package com.relationshipOneToOne;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class College
{
    @Id
    @Column(name = "college_id")
    private int collegeId;
    private String collegeName;
    private String collegeAddress;
    @OneToOne
    private Student1 student1;
}
