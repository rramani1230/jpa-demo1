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
     private int ownId;

     @NotNull
     @OneToOne
     private Owner owner;

     public StoreToOwner (Store store, Owner owner) {
          this.store = store;
          this.storeId = this.store.getStoreId();
          this.owner = owner;
          this.ownId = owner.getId();
     }

     public Owner getOwner () {
          return this.owner;
     }

     public void setOwner (Owner owner) {
          this.owner = owner;
     }

     public int getOwnId () {
          return this.ownId;
     }

     public void setOwnId (int ownId) {
          this.ownId = ownId;
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
