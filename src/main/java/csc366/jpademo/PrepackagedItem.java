package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;

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
