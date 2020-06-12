package csc366.jpademo;

import java.util.*;
import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="BoardMember")
public class BoardMember extends CompanyPerson {

     @NotNull
     private String boardStrategy;

     @NotNull
     private boolean hasDegree;


     @OneToMany
     private List<RegionalManager> regionalManagers = new ArrayList<>();

     public BoardMember (int id, String name, String email,
     String dateOfBirth, String phoneNo, String boardStrategy,
     boolean hasDegree) {
          super(id, name, email, dateOfBirth, phoneNo);
          this.boardStrategy = boardStrategy;
          this.hasDegree = hasDegree;
     }
}
