package csc366.jpademo;

import java.util.*;
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
     @ManyToOne
     private Supplier supplier;

     @NotNull
     @ManyToOne
     private Store store;

     @NotNull
     @ManyToMany
     private List<Item> items = new ArrayList<Item>();

     @NotNull
     private int quantity;

     @NotNull
     private String date;


     public Shipment(int shipmentId, int quantity, String date) {
          this.shipmentId = shipmentId;
          this.quantity = quantity;
          this.date = date;
     }


     public int getShipmentId() {
          return this.shipmentId;
     }

     public void setShipmentId(int shipmentId) {
          this.shipmentId = shipmentId;
     }

     public Supplier getSupplier() {
          return this.supplier;
     }

     public void setSupplier(Supplier supplier) {
          this.supplier = supplier;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store store) {
          this.store = store;
     }

     public List<Item> getItem() {
          return this.items;
     }

     public void setItem(List<Item> items) {
          this.items = items;
     }

     public int getQuantity() {
          return this.quantity;
     }

     public void setQuantity(int quantity) {
          this.quantity = quantity;
     }

     public String getDate() {
          return this.date;
     }

     public void setDate(String date) {
          this.date = date;
     }
     
   
}
