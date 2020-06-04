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


public class Inventory {

     private int itemId;
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
