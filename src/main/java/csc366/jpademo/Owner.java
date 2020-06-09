package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Owner")
public class Owner extends CompanyPerson {

     // Store is the "owning" class in this relationship
     // implying owners cannot exist w/o stores
     @ManyToMany(mappedBy = "owners")
     private Set<Store> stores = new HashSet<>();

     public Owner (int id, String name, String email,
                    String dateOfBirth, String phoneNo) {
          super(id, name, email, dateOfBirth, phoneNo);
     }

     public void addStore(Store newStore) {
          stores.add(newStore);
     }

     public Set<Store> getStores() {
          return this.stores;
     }
}
