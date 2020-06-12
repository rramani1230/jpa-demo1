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


     public boolean isTruck_driver() {
          return this.truck_driver;
     }

     public boolean getTruck_driver() {
          return this.truck_driver;
     }

     public void setTruck_driver(boolean truck_driver) {
          this.truck_driver = truck_driver;
     }

     public Store getHome_store() {
          return this.home_store;
     }

     public void setHome_store(Store home_store) {
          this.home_store = home_store;
     }

     public Item getFavorite_item() {
          return this.favorite_item;
     }

     public void setFavorite_item(Item favorite_item) {
          this.favorite_item = favorite_item;
     }

     public List<Receipt> getReceipts() {
          return this.receipts;
     }

     public void setReceipts(List<Receipt> receipts) {
          this.receipts = receipts;
     }

}
