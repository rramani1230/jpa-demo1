package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Receipt",
uniqueConstraints = @UniqueConstraint(columnNames={
     "receiptId"
}))
public class Receipt {

     @Id
     @NotNull
     private int receiptId;

     @NotNull
     private Date date;

     @NotNull
     @ManyToMany(mappedBy = "receipts")
     private List<Customer> customers = new ArrayList<>();

     @NotNull
     @ManyToMany(mappedBy = "receipts")
     private List<Item> items = new ArrayList<>();

     @NotNull
     @ManyToMany(mappedBy = "receipts")
     private List<Store> store = new ArrayList<>();


     public int getReceiptId() {
          return this.receiptId;
     }

     public void setReceiptId(int receiptId) {
          this.receiptId = receiptId;
     }

     public Date getDate() {
          return this.date;
     }

     public void setDate(Date date) {
          this.date = date;
     }

     public List<Customer> getCustomers() {
          return this.customers;
     }

     public void setCustomers(List<Customer> customers) {
          this.customers = customers;
     }

     public List<Item> getItems() {
          return this.items;
     }

     public void setItems(List<Item> items) {
          this.items = items;
     }

     public List<Store> getStore() {
          return this.store;
     }

     public void setStore(List<Store> store) {
          this.store = store;
     }
}
