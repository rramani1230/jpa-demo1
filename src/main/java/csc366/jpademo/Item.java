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
     private List<Customer> favories = new ArrayList<>();

     public Item (int itemId, String itemName, double itemCost, boolean prepackaged) {
          this.itemId = itemId;
          this.itemName = itemName;
          this.itemCost = itemCost;
          this.prepackaged = prepackaged;
     }
}
