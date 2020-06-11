package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Employee")
public class Employee extends CompanyPerson {

     private String region;
     private boolean injured;

     public Employee (int id, String name, String email,
     String dateOfBirth, String phoneNo, String region, boolean injured) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.region = region;
          this.injured = injured;
     }

     public boolean getInjured() {
          return this.injured;
     }

     public void setInjured(boolean injured) {
          this.injured = injured;
     }

     public String getRegion() {
          return this.region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

}
