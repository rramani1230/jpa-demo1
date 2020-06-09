package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="LocationToStore")

public class LocationToStore {

     @Id
     @NotNull
     private int locationManagerId;

     @NotNull
     private int storeId;

     public LocationToStore (int locationManagerId, int storeId) {
          this.locationManagerId = locationManagerId;
          this.storeId = storeId;
     }

     public int getLocationManagerId () {
          return this.locationManagerId;
     }

     public void setLocationManagerId (int locationManagerId) {
          this.locationManagerId = locationManagerId;
     }

     public int getStoreId () {
          return this.storeId;
     }

     public void setStoreId (int storeId) {
          this.storeId = storeId;
     }
}
