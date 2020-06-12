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

}
