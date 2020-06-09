package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "StoreToOwner")

public class StoreToOwner {

     @NotNull
     @OneToOne
     private Store store;

     @Id
     private int storeId;


     @NotNull
     private int ownerId;

     public StoreToOwner (Store store, int ownerId) {
          this.store = store;
          this.storeId = this.store.getStoreId();
          this.ownerId = ownerId;
     }


     public int getOwnerId () {
          return this.ownerId;
     }

     public void setOwnerId (int ownerId) {
          this.ownerId = ownerId;
     }

     public Store getStore () {
          return this.store;
     }

     public void setStore (Store store) {
          this.store = store;
     }

     public int getStoreId () {
          return this.storeId;
     }

     public void setStoreId (int storeId) {
          this.storeId = storeId;
     }


}
