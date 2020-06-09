package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "RegionalToLocation")

public class LocationToRegional {

     @Id
     @NotNull
     private int locationManagerId;

     @NotNull
     private int regionalManagerId;


     public LocationToRegional(int regionaManagerId, int locationManagerId) {
          this.regionalManagerId = regionaManagerId;
          this.locationManagerId = locationManagerId;
     }

     public int getRegionalManagerId () {
          return this.regionalManagerId;
     }

     public void setRegionalManagerId (int regionalManagerId) {
          this.regionalManagerId = regionalManagerId;
     }

     public int getLocationManagerId () {
          return this.locationManagerId;
     }

     public void setLocationManagerId (int locationManagerId) {
          this.locationManagerId = locationManagerId;
     }
}
