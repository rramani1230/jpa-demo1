package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Store",
uniqueConstraints = @UniqueConstraint(columnNames={
     "storeId", "address"
}))

public class Store {

     @Id
     @NotNull
     private int storeId;

     @NotNull
     private String address;

     @NotNull
     private String county;

     public Store (int storeId, String address, String county) {
          this.storeId = storeId;
          this.address = address;
          this.county = county;
     }

     public int getStoreId () {
          return this.storeId;
     }

     public void setStoreId (int storeId) {
          this.storeId = storeId;
     }

     public String getAddress () {
          return this.address;
     }

     public void setAddress (String address) {
          this.address = address;
     }

     public String getCounty () {
          return this.county;
     }

     public void setCounty (String county) {
          this.county = county;
     }
}
