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


public class Receipts {

     private int receiptId;
     private String Date;
     private int customerId;
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
