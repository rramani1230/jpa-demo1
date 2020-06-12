package csc366.jpademo;

import java.util.*;
import javax.persistence.*;

@Entity(name="Owner")
public class Owner extends CompanyPerson {

     @ManyToMany
     private List<Store> stores = new ArrayList<>();

     public Owner (int id, String name, String email,
                    String dateOfBirth, String phoneNo) {
          super(id, name, email, dateOfBirth, phoneNo);
     }

     public List<Store> getStores() {
          return this.stores;
     }

     public void setStores(List<Store> stores) {
          this.stores = stores;
     }

     
}
