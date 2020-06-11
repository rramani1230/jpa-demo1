package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Shipment",
uniqueConstraints = @UniqueConstraint(columnNames={
     "shipmentId"
}))

public class Shipment {

     @Id
     @NotNull
     private int shipmentId;

     @NotNull
     private int supplierId; // where it's coming from

     @NotNull
     private int storeId; // where it's going

     @NotNull
     private int itemId;

     @NotNull
     private int quantity;

     @NotNull
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

     public void setQuantity (int quantity) {
          this.quantity = quantity;
     }

     public String getDate () {
          return this.date;
     }

     public void setDate (String date) {
          this.date = date;
     }
}
