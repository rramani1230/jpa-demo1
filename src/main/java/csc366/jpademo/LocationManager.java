package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="LocationManager")
public class LocationManager extends Manager{

     @NotNull
     private int id;

     // @OneToOne(mappedBy = "storeId")
     @OneToOne
     private Store store;
    
     public LocationManager (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }
   
    public Store getStore() {
         return this.store;
    }
   
    public void setStore(Store s) {
         this.store = s;
    }

}
