package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "LocationToRegional")

public class LocationToRegional {

     @Id
     @NotNull
     private int locationManId;

     @NotNull
     private int regionalManId;

     @NotNull
     @OneToOne
     private LocationManager locationManager;

     @OneToOne
     @NotNull
     private RegionalManager regionalManager;

     public LocationToRegional(LocationManager locationManager,
     RegionalManager regionalManager) {
          this.locationManager = locationManager;
          this.locationManId = this.locationManager.getId();
          this.regionalManager = regionalManager;
          this.regionalManId = regionalManager.getId();
     }

     public RegionalManager getRegionalManaager () {
          return this.regionalManager;
     }

     public void setRegionalManager (RegionalManager regionalManager) {
          this.regionalManager = regionalManager;
     }

     public LocationManager getLocationManager () {
          return this.locationManager;
     }

     public void setLocationManager (LocationManager locationManager) {
          this.locationManager = locationManager;
     }

     public int getRegionalManId () {
          return this.regionalManId;
     }

     public void setRegionalManId (int regionalManId) {
          this.regionalManId = regionalManId;
     }

     public int getLocationManId () {
          return this.locationManId;
     }

     public void setLocationManagerId (int locationManId) {
          this.locationManId = locationManId;
     }
}
