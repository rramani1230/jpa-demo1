package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="StoreToLocation")

public class StoreToLocation {

     @Id
     @NotNull
     private int storeNum;

     @NotNull
     private int locationManId;

     @NotNull
     @OneToOne
     private Store store;

     @NotNull
     @OneToOne
     private LocationManager locationManager;

     public StoreToLocation (Store store, LocationManager locationManager) {
          this.store = store;
          this.locationManager = locationManager;
          this.storeNum = this.store.getStoreId();
          this.locationManId = this.locationManager.getId();
     }

     public int getLocationManId () {
          return this.locationManId;
     }

     public void setLocationManagerId (int locationManId) {
          this.locationManId = locationManId;
     }

     public LocationManager getLocationManager () {
          return this.locationManager;
     }

     public void setLocationManager (LocationManager locationManager) {
          this.locationManager = locationManager;
     }

     public int getStoreNum () {
          return this.storeNum;
     }

     public void setStoreNum (int storeNum) {
          this.storeNum = storeNum;
     }

     public Store getStore () {
          return this.store;
     }

     public void setStore (Store store) {
          this.store = store;
     }
}
