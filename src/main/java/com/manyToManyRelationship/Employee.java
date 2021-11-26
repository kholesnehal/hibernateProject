package com.manyToManyRelationship;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Employee
{
    @Id
    private int employeeId;
    private String employeeName;
    private String employeeAddress;
    @ManyToMany
    private List<Project> projectList;
}
