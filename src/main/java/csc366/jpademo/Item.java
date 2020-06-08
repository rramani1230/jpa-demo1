package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Item",
uniqueConstraints = @UniqueConstraint(columnNames={
     "itemId", "itemName"
}))
public abstract class Item {

     @Id
     @NotNull
     private int itemId;

     @NotNull
     private String itemName;

     @NotNull
     private double itemCost;

     public Item (int itemId, String itemName, double itemCost) {
          this.itemId = itemId;
          this.itemName = itemName;
          this.itemCost = itemCost;
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
}
