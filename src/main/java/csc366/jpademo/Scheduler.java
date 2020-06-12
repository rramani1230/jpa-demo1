package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Scheduler")
public class Scheduler {

     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
     @NotNull
     private int entry;

     @ManyToOne
     private Employee employee;

     @ManyToOne
     private Store store;
     private String week;
     private double hours;

     public Scheduler (Employee employee, Store store, String week, double hours) {
          this.employee = employee;
          this.store = store;
          this.week = week;
          this.hours = hours;
     }


     public int getEntry() {
          return this.entry;
     }

     public void setEntry(int entry) {
          this.entry = entry;
     }

     public Employee getEmployee() {
          return this.employee;
     }

     public void setEmployee(Employee employee) {
          this.employee = employee;
     }

     public Store getStore() {
          return this.store;
     }

     public void setStore(Store store) {
          this.store = store;
     }

     public String getWeek() {
          return this.week;
     }

     public void setWeek(String week) {
          this.week = week;
     }

     public double getHours() {
          return this.hours;
     }

     public void setHours(double hours) {
          this.hours = hours;
     }


}
