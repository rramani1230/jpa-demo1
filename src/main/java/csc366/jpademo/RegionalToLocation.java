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

public class RegionalToLocation {

     private int regionalManagerId;
     private int locationManagerId;

     public RegionalToLocation (int regionalManagerId, int locationManagerId) {
          this.regionalManagerId = regionalManagerId;
          this.locationManagerId = locationManagerId;
     }

     public int getRegionalManagerId() {
          return regionalManagerId;
     }

     public void setRegionalManagerId() {
          this.regionalManagerId = regionalManagerId;
     }

     public int getLocationManagerId() {
        return locationManagerId;
     }

     public void setLocationManagerId() {
        this.locationManagerId = locationManagerId;
   }0


}
