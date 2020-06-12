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
     private Date date;

     @ManyToOne
     private Customer customer;

     @ManyToMany(mappedBy = "receipts")
     private List<Item> items = new ArrayList<>();

     @ManyToOne
     private Store store;


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

     public Customer getCustomer() {
          return this.customer;
     }

     public void setCustomer(Customer customer) {
          this.customer = customer;
     }

     public List<Item> getItems() {
          return this.items;
     }

     public void setItems(List<Item> items) {
          this.items = items;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store store) {
          this.store = store;
     }

}
