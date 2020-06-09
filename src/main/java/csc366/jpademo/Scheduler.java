package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Scheduler",
uniqueConstraints = @UniqueConstraint(columnNames={
     "employeeNum"
}))

public class Scheduler {

     @Id
     @NotNull
     private int employeeNum;

     @NotNull
     @OneToOne
     private Employee employee;

     @NotNull
     private String week;

     @NotNull
     private int hours;

     public Scheduler (Employee employee, String week, int hours) {
          this.employee = employee;
          this.employeeNum = employee.getId();
          this.week = week;
          this.hours = hours;
     }

     public int getEmployeeNum () {
          return this.employeeNum;
     }

     public void setEmployeeNum (int employeeNum) {
          this.employeeNum = employeeNum;
     }

     public Employee getEmployee () {
          return this.employee;
     }

     public void setEmployee (Employee employee) {
          this.employee = employee;
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
