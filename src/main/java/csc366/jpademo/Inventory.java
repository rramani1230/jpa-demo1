package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="Inventory")

public class Inventory {
     
     @Id
     private int inventoryId;

     @OneToOne
     private Store store;

     @ManyToMany
     private List<Item> items = new ArrayList<>();

     public Inventory (int inventoryId, Store store) {
          this.inventoryId = inventoryId;
          this.store = store;
     }

}
