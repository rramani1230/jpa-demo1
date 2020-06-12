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
     @GeneratedValue(strategy=GenerationType.AUTO)
     private int receiptId;

     @NotNull
     private String date;

     @ManyToOne
     private Customer customer;

     @ManyToMany(mappedBy = "receipts")
     private List<Item> item = new ArrayList<>();

     @ManyToOne
     private Store store;

     public Receipt (String date, Customer customer, Item item, Store store) {
          this.date = date;
          this.customer = customer;
          this.item.add(item);
          this.store = store;
     }


     public int getReceiptId() {
          return this.receiptId;
     }

     public void setReceiptId(int receiptId) {
          this.receiptId = receiptId;
     }

     public String getDate() {
          return this.date;
     }

     public void setDate(String date) {
          this.date = date;
     }

     public Customer getCustomer() {
          return this.customer;
     }

     public void setCustomer(Customer customer) {
          this.customer = customer;
     }

     public List<Item> getItems() {
          return this.item;
     }

     public void setItems(List<Item> item) {
          this.item = item;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store store) {
          this.store = store;
     }

}
