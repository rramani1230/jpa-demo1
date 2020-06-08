package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="PrepackagedInventory")
public class PrepackagedInventory extends Inventory {

     public PrepackagedInventory (int itemId, int quantity) {
          super(itemId, quantity);
     }

}
