package springorm.dao;

import lombok.Data;
import org.springframework.orm.hibernate5.HibernateTemplate;
import springorm.entities.Client;

import javax.transaction.Transactional;
import java.util.List;

@Data
public class ClientDao {

    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int insert(Client client)
    {
     Integer i= (Integer) this.hibernateTemplate.save(client);
        return i;
    }

    public Client getClient(int clientId)
    {
        Client client=this.hibernateTemplate.get(Client.class,clientId);
        return client;
    }
    public List<Client> getAllClient()
    {
       List<Client>clients=this.hibernateTemplate.loadAll(Client.class);
       return clients;
    }

    public void deleteClient(int clientId)
    {
        hibernateTemplate.delete(hibernateTemplate.get(Client.class,clientId));

    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }
}
