package csc366.jpademo;

import java.util.*;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Employee")
public class Employee extends CompanyPerson {

     @NotNull
     private String region;
     @NotNull
     private boolean injured;

     @OneToMany
     private List<Scheduler> scheduler = new ArrayList<Scheduler>();


     public Employee (int id, String name, String email,
     String dateOfBirth, String phoneNo, String region, boolean injured) {
          super(id,name,email,dateOfBirth,phoneNo);
          this.region = region;
          this.injured = injured;
     }


     public String getRegion() {
          return this.region;
     }

     public void setRegion(String region) {
          this.region = region;
     }

     public boolean isInjured() {
          return this.injured;
     }

     public boolean getInjured() {
          return this.injured;
     }

     public void setInjured(boolean injured) {
          this.injured = injured;
     }

     public List<Scheduler> getScheduler() {
          return this.scheduler;
     }

     public void setScheduler(List<Scheduler> scheduler) {
          this.scheduler = scheduler;
     }

}
