package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Store",
uniqueConstraints = @UniqueConstraint(columnNames={
     "storeId", "address"
}))

public class Store {

     @Id
     @NotNull
     private int storeId;

     @NotNull
     private String address;

     @NotNull
     private String county;

     @ManyToMany(fetch = FetchType.LAZY)
     private Set<Owner> owners = new HashSet<>();

     @ManyToMany
     private List<Supplier> suppliers = new ArrayList<>(); // the store's suppliers
 
     @OneToOne
     private LocationManager locationManager;

     @OneToMany 
     private List<Employee> employees = new ArrayList<>();


     public Store (int storeId, String address, String county) {
          this.storeId = storeId;
          this.address = address;
          this.county = county;
     }

     // owners to a store are like shareholders to a stock
     public void addOwner(Owner owner) {
          owners.add(owner);
     }

     public Set<Owner> getOwners() {
          return this.owners;
     }
   
     public void setLocationManager(LocationManager lm) {
          this.locationManager = lm;
     }
    
     public LocationManager getLocationManager() {
          return this.locationManager;
     }

     public int getStoreId () {
          return this.storeId;
     }

     public void setStoreId (int storeId) {
          this.storeId = storeId;
     }

     public String getAddress () {
          return this.address;
     }

     public void setAddress (String address) {
          this.address = address;
     }

     public String getCounty () {
          return this.county;
     }

     public void setCounty (String county) {
          this.county = county;
     }
}
