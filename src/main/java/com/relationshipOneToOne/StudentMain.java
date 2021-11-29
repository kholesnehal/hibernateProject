package com.relationshipOneToOne;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentMain {
    public static void main(String[] args) {

        Configuration cfg= new Configuration() ;

        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Student1 student=new Student1();
        student.setStudentId(11);
        student.setStudentName("Snehal");
        student.setAddress("Pune");

        College college=new College();
        college.setCollegeId(101);
        college.setCollegeName("DY Patil College Akurdi");
        college.setCollegeAddress("Akurdi");

        student.setCollege(college);
        college.setStudent1(student);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();

        session.save(student);
        session.save(college);

        transaction.commit();

        session.close();
        factory.close();

    }
}
