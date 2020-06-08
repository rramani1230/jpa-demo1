package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity(name="PrepackagedItem")
public class PrepackagedItem extends Item {

     private String receipeDescription;

     public PrepackagedItem (int itemId, String itemName, double itemCost,
     String recipeDescription) {
          super(itemId, itemName, itemCost);
          this.receipeDescription = receipeDescription;
     }

     public String getReceipeDescription () {
          return this.receipeDescription;
     }

     public void setReceipeDescription (String receipeDescription) {
          this.receipeDescription = receipeDescription;
     }
}
