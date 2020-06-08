package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="Customer")
public class Customer extends CompanyPerson{

     public Customer (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }

}
