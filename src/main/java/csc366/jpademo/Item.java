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

     @NotNull
     @ManyToMany
     private List<Receipt> receipts = new ArrayList<>();

     @NotNull
     @ManyToMany(mappedBy = "items")
     private List<Shipment> shipments = new ArrayList<>();

     @NotNull
     @ManyToMany(mappedBy = "items")
     private List<Inventory> inventories = new ArrayList<>();


     public Item (int itemId, String itemName, double itemCost, boolean prepackaged) {
          this.itemId = itemId;
          this.itemName = itemName;
          this.itemCost = itemCost;
          this.prepackaged = prepackaged;
     }

     public int getItemId () {
          return this.itemId;
     }

     public void setItemId (int itemId) {
          this.itemId = itemId;
     }

     public String getItemName () {
          return this.itemName;
     }

     public void setItemName (String itemName) {
          this.itemName = itemName;
     }

     public double getItemCost () {
          return this.itemCost;
     }

     public void setItemCost (double itemCost) {
          this.itemCost = itemCost;
     }

     public boolean getPrepackaged () {
          return this.prepackaged;
     }

     public void setPrepackaged (boolean prepackaged) {
          this.prepackaged = prepackaged;
     }

     public List<Receipt> getReceipts () {
          return this.receipts;
     }

     public void setReceipts (List<Receipt> receipts) {
          this.receipts = receipts;
     }
}
