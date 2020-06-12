package csc366.jpademo;

import java.util.*;

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

     @OneToOne
     private Inventory inventory;

     @OneToMany
     private List<Customer> favorites = new ArrayList<Customer>();

     @OneToMany
     private List<Scheduler> scheduler = new ArrayList<Scheduler>();

     @OneToMany
     private List<Shipment> shipments = new ArrayList<Shipment>();

     @ManyToMany(fetch = FetchType.LAZY)
     private List<Owner> owners = new ArrayList<>();

     @OneToOne
     private LocationManager locationManager;

     @OneToMany
     private List<Receipt> receipts = new ArrayList<>();


     public Store (int storeId, String address, String county) {
          this.storeId = storeId;
          this.address = address;
          this.county = county;
     }
}
