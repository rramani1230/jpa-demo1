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
     private int customerId;

     @NotNull
     private int itemId;

     public Receipts (int receiptId, String date, int customerId, int itemId) {
          this.receiptId = receiptId;
          this.date = date;
          this.customerId = customerId;
          this.itemId = itemId;
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

     public int getCustomerId () {
          return this.customerId;
     }

     public void setCustomerId (int customerId) {
          this.customerId = customerId;
     }

     public int getItemId () {
          return this.itemId;
     }

     public void setItemId (int itemId) {
          this.itemId = itemId;
     }
}
