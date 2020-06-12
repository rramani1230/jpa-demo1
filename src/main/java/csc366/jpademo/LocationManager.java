package csc366.jpademo;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="LocationManager")
public class LocationManager extends Manager{

     @ManyToOne
     private RegionalManager regionalManager;
     // @OneToOne(mappedBy = "storeId")

     private int store;

     public LocationManager (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }

    public int getStore() {
         return this.store;
    }

    public void setStore(int s) {
         this.store = s;
    }

}
