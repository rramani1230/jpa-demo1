package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Customer")

public class Customer extends CompanyPerson{
     @NotNull
     public boolean truck_driver;
     public int home_store;
     public int favorite_item;

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
