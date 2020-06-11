package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity  // indicates that this class maps to a database table
@Table(name = "customer",     // may be omitted for default naming
       uniqueConstraints = @UniqueConstraint(columnNames={"id"})
)
public class Customer extends CompanyPerson{
     
     @NotNull
     public boolean truck_driver;
     @NotNull
     public int home_store;
     @NotNull
     public int favorite_item;

     /* Insert foreign key for home store and favorite items */

     public Customer (int id, String name, String email,
     String dateOfBirth, String phoneNo, boolean truck_driver, 
     int home_store, int favorite_item) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.truck_driver = truck_driver;
          this.home_store = home_store;
          this.favorite_item = favorite_item;
     }

     public boolean getTruckDriver() {
          return this.truck_driver;
     }

     public void setTruckDriver(boolean truck_driver) {
          this.truck_driver = truck_driver;
     }

     public int getHomeStore() {
          return this.home_store;
     }

     public void setHomeStore(int home_store) {
          this.home_store = home_store;
     }

     public int getFavoriteItem() {
          return this.favorite_item;
     }

     public void setFavoriteItem(int favorite_item) {
          this.favorite_item = favorite_item;
     }

}
