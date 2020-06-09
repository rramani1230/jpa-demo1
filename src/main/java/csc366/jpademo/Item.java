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
     "id", "itemName"
}))
public abstract class Item {

     @Id
     @NotNull
     private int id;

     @NotNull
     private String itemName;

     @NotNull
     private double itemCost;

     public Item (int id, String itemName, double itemCost) {
          this.id = id;
          this.itemName = itemName;
          this.itemCost = itemCost;
     }

     public int getId () {
          return this.id;
     }

     public void setId (int id) {
          this.id = id;
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
