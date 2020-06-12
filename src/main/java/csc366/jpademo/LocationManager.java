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


     public RegionalManager getRegionalManager() {
          return this.regionalManager;
     }

     public void setRegionalManager(RegionalManager regionalManager) {
          this.regionalManager = regionalManager;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store store) {
          this.store = store;
     }

}
