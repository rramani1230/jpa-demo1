package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Inventory",
uniqueConstraints = @UniqueConstraint(columnNames={
     "inventoryId"
}))

public class Inventory {

     @NotNull
     @Id
     private int inventoryId;

     // @OneToMany
     // @MapKeyJoinColumn(name = "itemId")
     // private Map<Item, Integer> listofitems = new HashMap<Item, Integer>();

     // NOTE: no clue why this doesn't work w/ a map data structure
     // going to need to work around this somehow to keep track of item quantity
     @OneToMany
     private List<Item> listofitems = new ArrayList<>();

     public Inventory (int inventoryId) {
          this.inventoryId = inventoryId;
     }

     public int getItemId () {
          return this.inventoryId;
     }
}
