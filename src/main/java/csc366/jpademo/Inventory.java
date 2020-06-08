package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Inventory",
uniqueConstraints = @UniqueConstraint(columnNames={
     "itemId"
}))

public abstract class Inventory {

     @NotNull
     @Id
     private int itemId;

     @NotNull
     private int quantity;

     public Inventory (int itemId, int quantity) {
          this.itemId = itemId;
          this.quantity = quantity;
     }

     public int getItemId () {
          return this.itemId;
     }

     public void setItemId (int itemId) {
          this.itemId = itemId;
     }

     public int getQuantity () {
          return this.quantity;
     }

     public void setQuantity () {
          this.quantity = quantity;
     }
}
