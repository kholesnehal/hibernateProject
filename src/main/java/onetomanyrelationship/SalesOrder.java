package onetomanyrelationship;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class SalesOrder {
    @Id
private int orderId;
private String itemName;

@ManyToOne
private Customer customer;

}
