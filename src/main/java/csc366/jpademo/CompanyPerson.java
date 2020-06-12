package csc366.jpademo;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "CompanyPerson",
uniqueConstraints = @UniqueConstraint(columnNames={
     "id"
}))
//The companyPerson super class


public abstract class CompanyPerson {

     @Id
     @NotNull
     private int id;

     @NotNull
     private String name;

     @NotNull
     private String email;


     @NotNull
     private String dateOfBirth;

     @NotNull
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

     public void setDateOfBirth (String dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
     }

     public String getPhoneNo () {
          return this.phoneNo;
     }

     public void setPhoneNo (String phoneNo) {
          this.phoneNo = phoneNo;
     }

     public String toString () {
          return "Name: " + name;
     }
}
