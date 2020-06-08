package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="RawItemsInventory")
public class RawItemsInventory extends Inventory {

     public RawItemsInventory (int itemId, int quantity) {
          super(itemId, quantity);
     }
}
