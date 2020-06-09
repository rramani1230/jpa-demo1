package csc366.jpademo;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="BoardMember")
public class BoardMember extends CompanyPerson {

     @NotNull
     private String boardStrategy;

     @NotNull
     private boolean hasDegree;

     // each board member will have a list of 
     // regional managers that they overlook
     @OneToMany(mappedBy = "id", // join column (id in RegionalManager)
               cascade = CascadeType.ALL,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
     private List<RegionalManager> listOfRegManagers = new ArrayList<>();

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
          return this.listOfRegManagers;
     }

     public void setRegionalManagers(List<RegionalManager> rms) {
          this.listOfRegManagers = rms;
     }
}
