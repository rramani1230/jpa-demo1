package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotNull;


public class Scheduler {

     private int employeeId;
     private String week;
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
          return this.hours
     }

     public void setHours (int hours) {
          this.hours = hours;
     }
}
