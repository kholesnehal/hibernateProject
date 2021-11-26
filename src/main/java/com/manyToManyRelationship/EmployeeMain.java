package com.manyToManyRelationship;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        Configuration cfg= new Configuration() ;

        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Employee employee1=new Employee();
        Employee employee2=new Employee();

        employee1.setEmployeeId(11);
        employee1.setEmployeeName("Snehal");
        employee1.setEmployeeAddress("Pune");

        employee2.setEmployeeId(22);
        employee2.setEmployeeName("Manu");
        employee2.setEmployeeAddress("Nashik");

        Project project1=new Project();
        Project project2=new Project();

        project1.setProjectId(111);
        project1.setProjectName("online book sharing app");

        project2.setProjectId(222);
        project2.setProjectName("payroll system");

        List<Employee>employeeList=new ArrayList<>();
        List<Project>projectList=new ArrayList<>();

        employeeList.add(employee1);
        employeeList.add(employee2);


        projectList.add(project1);
        projectList.add(project2);

        employee1.setProjectList(projectList);
        project2.setEmployeeList(employeeList);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();


        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);




    }
}
