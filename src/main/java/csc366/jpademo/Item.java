package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Item",
uniqueConstraints = @UniqueConstraint(columnNames={
     "itemId", "itemName"
}))
public class Item {

     @Id
     @NotNull
     private int itemId;

     @NotNull
     private String itemName;

     @NotNull
     private double itemCost;

     @NotNull
     private boolean prepackaged;

     @OneToMany
     private List<Shipment> shipments = new ArrayList<Shipment>();

     @NotNull
     @ManyToMany
     private List<Receipt> receipts = new ArrayList<>();

     @OneToMany
     private List<Inventory> inventory = new ArrayList<>();

     @OneToMany
     private List<Customer> favoriteByCustomer = new ArrayList<>();

     public Item (int itemId, String itemName, double itemCost, boolean prepackaged) {
          this.itemId = itemId;
          this.itemName = itemName;
          this.itemCost = itemCost;
          this.prepackaged = prepackaged;
     }


     public int getItemId() {
          return this.itemId;
     }

     public void setItemId(int itemId) {
          this.itemId = itemId;
     }

     public String getItemName() {
          return this.itemName;
     }

     public void setItemName(String itemName) {
          this.itemName = itemName;
     }

     public double getItemCost() {
          return this.itemCost;
     }

     public void setItemCost(double itemCost) {
          this.itemCost = itemCost;
     }

     public boolean isPrepackaged() {
          return this.prepackaged;
     }

     public boolean getPrepackaged() {
          return this.prepackaged;
     }

     public void setPrepackaged(boolean prepackaged) {
          this.prepackaged = prepackaged;
     }

     public List<Shipment> getShipments() {
          return this.shipments;
     }

     public void setShipments(List<Shipment> shipments) {
          this.shipments = shipments;
     }

     public List<Receipt> getReceipts() {
          return this.receipts;
     }

     public void setReceipts(List<Receipt> receipts) {
          this.receipts = receipts;
     }

     public List<Inventory> getInventory() {
          return this.inventory;
     }

     public void setInventory(List<Inventory> inventory) {
          this.inventory = inventory;
     }

     public List<Customer> getFavoriteByCustomer() {
          return this.favoriteByCustomer;
     }

     public void setFavoriteByCustomer(List<Customer> favoriteByCustomer) {
          this.favoriteByCustomer = favoriteByCustomer;
     }

}
