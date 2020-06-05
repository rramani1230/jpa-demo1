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

public class LocationToStore {

     private int locationManagerId;
     private int storeId;

     public LocationToStore (int locationManagerId, int store_id) {
          this.locationManagerId = locationManagerId;
          this.storeId = storeId;
     }

     public int getLocationManagerId() {
        return locationManagerId;
     }

     public void setLocationManagerId() {
             this.locationManagerId = locationManagerId;
     }

     public int getStoreId() {
        return storeId;
     }

     public void setStoreId() {
        this.storeId = storeId;
     }
}
