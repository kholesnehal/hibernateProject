package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    private static final Logger logger = LogManager.getLogger(FetchDemo.class);
    public static void main(String[] args) {
        Configuration cfg= new Configuration() ;

        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();

//        Student student=(Student) session.get(Student.class,102);
        Student student= session.load(Student.class,102);
        logger.info(student);

        Address address=session.get(Address.class,1);
        logger.info(address.getStreet()+" "+address.getAddressId()+" "+address.getCity()+" "+address.getAddedDate());
        session.close();
        factory.close();

    }
}
