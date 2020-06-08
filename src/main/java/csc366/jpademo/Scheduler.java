package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Scheduler",
uniqueConstraints = @UniqueConstraint(columnNames={
     "employeeId"
}))

public class Scheduler {

     @Id
     @NotNull
     private int employeeId;

     @NotNull
     private String week;

     @NotNull
     private int hours;

     public int getEmployeeId () {
          return this.employeeId;
     }

     public void setEmployeeId (int employeeId) {
          this.employeeId = employeeId;
     }

     public String getWeek () {
          return this.week;
     }

     public void setWeek (String week) {
          this.week = week;
     }

     public int getHours () {
          return this.hours;
     }

     public void setHours (int hours) {
          this.hours = hours;
     }
}
