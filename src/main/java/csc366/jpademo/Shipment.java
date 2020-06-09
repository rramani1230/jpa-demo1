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
     private int supplierNum;

     @NotNull
     @OneToOne
     private Supplier supplier;

     @NotNull
     private int storeNum;

     @NotNull
     @OneToOne
     private Store store;

     @NotNull
     private int itemNum;

     @NotNull
     @OneToOne
     private Item item;

     @NotNull
     private int quantity;

     @NotNull
     private String date;

     public Shipment (Supplier supplier, Store store, Item item, int quantity,
     String date) {
          this.supplier = supplier;
          this.supplierNum = this.supplier.getSupplierId();
          this.store = store;
          this.storeNum = this.store.getStoreId();
          this.item = item;
          this.itemNum = item.getId();
          this.quantity = quantity;
          this.date = date;
     }

     public int getSupplierNum () {
          return this.supplierNum;
     }

     public void setSupplierId (int supplierNum) {
          this.supplierNum = supplierNum;
     }

     public int getStoreNum () {
          return this.storeNum;
     }

     public void setStoreNum (int storeNum) {
          this.storeNum = storeNum;
     }

     public int getItemNum () {
          return this.itemNum;
     }

     public void setItemNum (int itemNum) {
          this.itemNum = itemNum;
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

     public Store getStore () {
          return this.store;
     }

     public void setStore (Store store) {
          this.store = store;
     }

     public Item getItem () {
          return this.item;
     }

     public void setItem (Item item) {
          this.item = item;
     }

     public Supplier getSupplier () {
          return this.supplier;
     }

     public void setSupplier (Supplier supplier) {
          this.supplier = supplier;
     }
}
