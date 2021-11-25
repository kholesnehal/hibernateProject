package org.example;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        Configuration cfg= new Configuration() ;

           cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

       Student student=new Student();
       student.setId(102);
       student.setName("Manu");
       student.setCity("Nagar");
       logger.info(student);



        Address address=new Address();
        address.setAddressId(207);
        address.setStreet("street1");
        address.setCity("Pune");
        address.setAddedDate(new Date());
        address.setOpen(true);
        address.setX(113.435);


        Session session=factory.openSession();

        session.beginTransaction();

        session.save(student);
        session.save(address);

        session.getTransaction().commit();

        session.close();
    }
}




