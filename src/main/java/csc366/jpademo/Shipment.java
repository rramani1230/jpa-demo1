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
     @GeneratedValue(strategy=GenerationType.AUTO)
     @NotNull
     private int shipmentId;

     @ManyToOne
     private Supplier supplier;

     @ManyToOne
     private Store store;

     @ManyToOne
     private Item item;

     private int quantity;

     private String date;

	public Shipment(Supplier supplier, Store store, Item item, int quantity, String date) {
		this.supplier = supplier;
		this.store = store;
		this.item = item;
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

     public Item getItem() {
          return this.item;
     }

     public void setItem(Item item) {
          this.item = item;
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
