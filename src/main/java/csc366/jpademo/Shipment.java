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

public class Shipment {

     private int supplierId;
     private int storeId;
     private int itemId;
     private int quantity;
     private String date;

     public Shipment (int supplierId, int storeId, int itemId, int quantity,
     String date) {
          this.supplierId = supplierId;
          this.storeId = storeId;
          this.itemId = itemId;
          this.quantity = quantity;
          this.date = date;
     }

     public int getSupplierId () {
          return this.supplierId;
     }

     public void setSupplierId (int supplierId) {
          this.supplierId = supplierId;
     }

     public int getStoreId () {
          return this.storeId;
     }

     public void setStoreId (int storeId) {
          this.storeId = storeId;
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

     public int setQuantity (int quantity) {
          this.quantity = quantity;
     }

     public String getDate () {
          return this.date;
     }

     public setDate (String date) {
          this.date = date;
     }
}
