package csc366.jpademo;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity(name="RegionalManager")
public class RegionalManager extends Manager{

     // many regional managers will report to a single board member
     @ManyToOne
     private BoardMember boardMember;

     public RegionalManager (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }

     public BoardMember getBoardMember() {
          return this.boardMember;
     }

     public void setBoardMember(BoardMember bm) {
          this.boardMember = bm;
     }

}
