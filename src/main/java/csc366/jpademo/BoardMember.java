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

     public String getBoardStrategy () {
          return this.boardStrategy;
     }

     public void setBoardStrategy (String boardStrategy) {
          this.boardStrategy = boardStrategy;
     }

     public boolean getHasDegree () {
          return this.hasDegree;
     }

     public void setHasDegree (boolean hasDegree) {
          this.hasDegree = hasDegree;
     }

     public List<RegionalManager> getRegionalManagers() {
          return this.regionalManagers;
     }

     public void setRegionalManagers(List<RegionalManager> rms) {
          this.regionalManagers = rms;
     }
}
