package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Customer")
public class Customer extends CompanyPerson{
     
     @NotNull
     private boolean truck_driver;
     @NotNull
     private int home_store;
     @NotNull
     private int favorite_item;

     @ManyToMany
     // private List<Receipt> receipts = new ArrayList<>();
     private List<Receipt> receipts = new ArrayList<>();

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

     public List<Receipt> getReceipts () {
          return this.receipts;
     }

     public void setReceipts (List<Receipt> receipts) {
          this.receipts = receipts;
     }
}
