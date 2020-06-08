package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="RawItem")
public class RawItem extends Item{

     public RawItem (int itemId, String itemName, double itemCost) {
          super(itemId, itemName, itemCost);
     }

}
