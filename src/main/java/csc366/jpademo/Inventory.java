package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="Inventory")

public class Inventory {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     @NotNull
     private int entryId;

     @OneToOne
     private Store store;

     @ManyToOne
     private Item item;

     @NotNull
     private int quantity;

     public Inventory (Store strore, Item item, int quantity) {
          this.item = item;
          this.store = store;
          this.quantity = quantity;
     }
}
