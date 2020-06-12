package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity  // indicates that this class maps to a database table
@Table(name = "customer",     // may be omitted for default naming
       uniqueConstraints = @UniqueConstraint(columnNames={"id"})
)
public class Customer extends CompanyPerson{

     @NotNull
     private boolean truck_driver;

     @ManyToOne
     private Store home_store;

     @NotNull
     @ManyToOne
     private Item favorite_item;

     @OneToMany
     private List<Receipt> receipts = new ArrayList<>();


     public Customer (int id, String name, String email,
     String dateOfBirth, String phoneNo, boolean truck_driver,
     Store home_store, Item favorite_item) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.truck_driver = truck_driver;
          this.home_store = home_store;
          this.favorite_item = favorite_item;
     }
}
