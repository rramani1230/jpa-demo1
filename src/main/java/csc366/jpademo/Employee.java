package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Employee")
public class Employee extends CompanyPerson {

     private String region;
     private boolean injured;

     @OneToMany
     private List<Scheduler> scheduler = new ArrayList<Scheduler>();


     public Employee (int id, String name, String email,
     String dateOfBirth, String phoneNo, String region, boolean injured) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.region = region;
          this.injured = injured;
     }
}
