package onetomanyrelationship;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
public class Customer {
    @Id
    private int customerId;
    private String customerName;
    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private List<SalesOrder> salesOrderList;


}
