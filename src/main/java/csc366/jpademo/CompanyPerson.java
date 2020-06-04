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

public class CompanyPerson {

     private int id;
     private String name;
     private String email;
     private String dateOfBirth;
     private String phoneNo;

     public CompanyPerson (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
               this.id = id;
               this.name = name;
               this.email = email;
               this.dateOfBirth = dateOfBirth;
               this.phoneNo = phoneNo;
     }

     public int getId () {
          return this.id;
     }

     public void setId (int id) {
          this.id = id;
     }

     public String getName () {
          return this.name;
     }

     public void setName (String name) {
          this.name = name;
     }

     public String getEmail () {
          return this.email;
     }

     public void setEmail (String email) {
          this.email = email;
     }

     public String getDateOfBirth () {
          return this.dateOfBirth;
     }

     public void setDateOfBirth (String DateOfBirth) {
          this.dateOfBirth = dateOfBirth;
     }

     public String getPhoneNo () {
          return this.phoneNo;
     }

     public void setPhoneNo (String phoneNo) {
          this.phoneNo = phoneNo;
     }
}
