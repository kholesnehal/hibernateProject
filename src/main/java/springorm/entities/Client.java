package springorm.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name="client")
public class Client {
    @Id
    private int clientId;
    private String clientName;
    private String clientAddress;

    public Client(int clientId, String clientName, String clientAddress) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
    }

    public Client() {

    }


}
