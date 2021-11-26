package onetomanyrelationship;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.App;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CustomerMain {
    private static final Logger logger = LogManager.getLogger(CustomerMain.class);
    public static void main(String[] args) {
        Configuration cfg= new Configuration() ;

        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();

        Customer customer=new Customer();
        customer.setCustomerId(101);
        customer.setCustomerName("snehal");
        customer.setCustomerAddress("Pune");


        SalesOrder salesOrder1=new SalesOrder();
        salesOrder1.setOrderId(3234);
        salesOrder1.setItemName("TV");
        salesOrder1.setCustomer(customer);

        SalesOrder salesOrder2=new SalesOrder();
        salesOrder2.setOrderId(356546);
        salesOrder2.setItemName("Laptop");
        salesOrder2.setCustomer(customer);

        List<SalesOrder> sales=new ArrayList<>();
        sales.add(salesOrder1);
        sales.add(salesOrder2);
        customer.setSalesOrderList(sales);


        Session session=factory.openSession();

        Transaction transaction=session.beginTransaction();

        session.save(customer);
        session.save(salesOrder1);
        session.save(salesOrder2);


//        Customer cust=session.get(Customer.class,101);
//        logger.info(cust.getCustomerId()+" "+cust.getCustomerName()+" "+cust.getCustomerAddress());
//        for(SalesOrder s:cust.getSalesOrderList())
//        {
//            logger.info(s.getCustomer());
//        }
        transaction.commit();

        session.close();
        factory.close();



    }
}
