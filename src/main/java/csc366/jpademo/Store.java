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

     private int inventory;

     @ManyToMany(fetch = FetchType.LAZY)
     private List<Owner> owners = new ArrayList<>();

     private int locationManager;

     @ManyToMany
     private List<Receipt> receipts = new ArrayList<>();

     @NotNull
     @OneToMany
     private List<Shipment> shipments = new ArrayList<>();


     public Store (int storeId, String address, String county, int inventory,
     int locationManager) {
          this.storeId = storeId;
          this.address = address;
          this.county = county;
          this.inventory = inventory;
          this.locationManager = locationManager;
     }

     // owners to a store are like shareholders to a stock
     public void addOwner(Owner owner) {
          owners.add(owner);
     }

     public List<Owner> getOwners() {
          return this.owners;
     }

     public void setOwners (List<Owner> owners) {
          this.owners = owners;
     }

     public void setLocationManager(int lm) {
          this.locationManager = lm;
     }

     public int getLocationManager() {
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

     public List<Receipt> getReceipts () {
          return this.receipts;
     }

     public void setReceipts (List<Receipt> receipts) {
          this.receipts = receipts;
     }

     public List<Shipment> getShipments () {
          return this.shipments;
     }

     public void setShipments (List<Shipment> shipments) {
          this.shipments = shipments;
     }

     public int getInteventory () {
          return this.inventory;
     }

     public void setInventory (int inventory) {
          this.inventory = inventory;
     }
}
