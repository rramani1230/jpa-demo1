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


public class Item {

     private int itemId;
     private String itemName;
     private double itemCost;

     public Item (int itemId, String itemName, double itemCost) {
          this.itemId = itemId;
          this.itemName = itemName;
          this.itemCost = itemCost;
     }

     public int getItemId () {
          return this.itemId;
     }

     public void setItemId (int itemId) {
          this.itemId = itemId;
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
