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
     private List<Customer> favoriteByCustomer = new ArrayList<Customer>();

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


     public int getStoreId() {
          return this.storeId;
     }

     public void setStoreId(int storeId) {
          this.storeId = storeId;
     }

     public String getAddress() {
          return this.address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public String getCounty() {
          return this.county;
     }

     public void setCounty(String county) {
          this.county = county;
     }

     public Inventory getInventory() {
          return this.inventory;
     }

     public void setInventory(Inventory inventory) {
          this.inventory = inventory;
     }

     public List<Customer> getFavoriteByCustomer() {
          return this.favoriteByCustomer;
     }

     public void setFavoriteByCustomer(List<Customer> favoriteByCustomer) {
          this.favoriteByCustomer = favoriteByCustomer;
     }

     public List<Scheduler> getScheduler() {
          return this.scheduler;
     }

     public void setScheduler(List<Scheduler> scheduler) {
          this.scheduler = scheduler;
     }

     public List<Shipment> getShipments() {
          return this.shipments;
     }

     public void setShipments(List<Shipment> shipments) {
          this.shipments = shipments;
     }

     public List<Owner> getOwners() {
          return this.owners;
     }

     public void setOwners(List<Owner> owners) {
          this.owners = owners;
     }

     public LocationManager getLocationManager() {
          return this.locationManager;
     }

     public void setLocationManager(LocationManager locationManager) {
          this.locationManager = locationManager;
     }

     public List<Receipt> getReceipts() {
          return this.receipts;
     }

     public void setReceipts(List<Receipt> receipts) {
          this.receipts = receipts;
     }

}
