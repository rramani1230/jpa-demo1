package csc366.jpademo;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="LocationManager")
public class LocationManager extends Manager{

     @ManyToOne
     private RegionalManager regionalManager;
     // @OneToOne(mappedBy = "storeId")

     @OneToOne
     private Store store;

     public LocationManager (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }
}
