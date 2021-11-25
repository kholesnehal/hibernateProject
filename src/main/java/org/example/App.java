package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg= new Configuration() ;

           cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

       Student student=new Student();
       student.setId(101);
       student.setName("Snehal");
       student.setCity("Pune");
        System.out.println(student);
        Session session=factory.openSession();

        session.beginTransaction();

        session.save(student);

        session.getTransaction().commit();

        session.close();
    }
}




