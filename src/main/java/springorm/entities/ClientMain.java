package springorm.entities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.example.App;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springorm.dao.ClientDao;

import java.util.List;
import java.util.Scanner;

public class ClientMain {
    private static final Logger logger = LogManager.getLogger(ClientMain.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);
//        Client client=new Client(1000,"Snehal","Pune");
//        int r=clientDao.insert(client);
//        logger.info(r);

        Scanner sc = new Scanner(System.in);
        boolean go = true;
        logger.info("Press 1 for add new Client");
        logger.info("Press 1 for display all Client");
        logger.info("Press 1 for get detail of single Client");
        logger.info("Press 1 for delete Client");
        logger.info("Press 1 for exit");
        try {
            int input = sc.nextInt();


            switch (input) {
                case 1:
                    logger.info("Enter client id:");
                    int cid=sc.nextInt();
                    logger.info("Enter client name:");
                    String cname=sc.next();
                    logger.info("Enter client address:");
                    String saddress=sc.next();
                    Client client=new Client();
                    client.setClientId(cid);
                    client.setClientName(cname);
                    client.setClientAddress(saddress);
//
                  int r= clientDao.insert(client);
                  logger.info(r+" client added!");
                    break;

                case 2:
                    List<Client> allClient=clientDao.getAllClient();
                    for(Client cl:allClient)
                    {
                        logger.info("Id:"+cl.getClientId());
                        logger.info("Name:"+cl.getClientName());
                        logger.info("Address:"+cl.getClientAddress());

                    }

                    break;
                case 3: logger.info("Enter client id:");
                int clientId=sc.nextInt();
                Client client1=clientDao.getClient(clientId);
                    logger.info("Id:"+client1.getClientId());
                    logger.info("Name:"+client1.getClientName());
                    logger.info("Address:"+client1.getClientAddress());
                    break;
                case 4:
                logger.info("Enetr client id:");
                int id= sc.nextInt();
                clientDao.deleteClient(id);
                logger.info("client deleted");
                    break;
                case 5:
                    go = false;
                    break;
            }
        } catch (Exception e)
        {
            logger.info("Invalid input try with another one!!");
        }
        logger.info("Thankyou  for using my application");
    }

}
