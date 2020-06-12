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

     private int employee;
     private int store;
     private String week;
     private double hours;

     public Scheduler (int employee, int store, String week, double hours) {
          this.employee = employee;
          this.store = store;
          this.week = week;
          this.hours = hours;
     }

	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

     public int getStore () {
          return store;
     }

     public void setStore () {
          this.store = store;
     }
}
