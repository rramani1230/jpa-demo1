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

public class Store {

     private int storeId;
     private String address;
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
