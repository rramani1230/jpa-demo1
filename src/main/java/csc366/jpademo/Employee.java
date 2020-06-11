package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Employee")
public class Employee extends CompanyPerson {

     private String region;

     private Boolean workStatus;

     @ManyToOne 
     private Store store;

     public Employee (int id, String name, String email,
     String dateOfBirth, String phoneNo, String region, Boolean ableToWork) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.region = region;
          this.workStatus = ableToWork;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store s) {
          this.store = s;
     }

     public String getRegion() {
          return this.region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

     public Boolean getWorkStatus() {
          return this.workStatus;
     }

     public void setWorkStatus(Boolean status) {
          this.workStatus = status;
     }

}
