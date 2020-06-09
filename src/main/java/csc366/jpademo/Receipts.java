package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Receipt",
uniqueConstraints = @UniqueConstraint(columnNames={
     "receiptId"
}))
public class Receipts {


     @Id
     @NotNull
     private int receiptId;

     @NotNull
     private String date;

     @NotNull
     private int custId;

     @NotNull
     private int itemNum;

     @NotNull
     @OneToOne
     private Customer customer;

     @NotNull
     @OneToOne
     private Item item;

     private int storeNum;

     @NotNull
     @OneToOne
     private Store store;

     public Receipts (int receiptId, String date, Customer customer,
      Item item, Store store) {
          this.receiptId = receiptId;
          this.date = date;
          this.customer = customer;
          this.item = item;
          this.custId = this.customer.getId();
          this.itemNum = item.getId();
          this.store = store;
          this.storeNum = store.getStoreId();
     }

     public int getReceiptId () {
          return this.receiptId;
     }

     public void setReceiptId (int receiptId) {
          this.receiptId = receiptId;
     }

     public String getDate () {
          return this.date;
     }

     public void setDate (String date) {
          this.date = date;
     }

     public int getcustId () {
          return this.custId;
     }

     public void setcustId (int custId) {
          this.custId = custId;
     }

     public int getitemNum () {
          return this.itemNum;
     }

     public void setitemNum (int itemNum) {
          this.itemNum = itemNum;
     }

     public Customer getCustomer () {
          return this.customer;
     }

     public void setCustomer (Customer customer) {
          this.customer = customer;
     }

     public Item getItem () {
          return this.item;
     }

     public void setItem (Item item) {
          this.item = item;
     }

     public Store getStore () {
          return this.store;
     }

     public void setStore (Store store) {
          this.store = store;
     }

     public int getStoreNum () {
          return this.storeNum;
     }

     public void setStoreNum (int storeNum) {
          this.storeNum = storeNum;
     }
}
