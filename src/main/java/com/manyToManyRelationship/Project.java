package com.manyToManyRelationship;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Project
{
    @Id
    private int projectId;
    private String projectName;
@ManyToMany
    private List<Employee> employeeList;
}
