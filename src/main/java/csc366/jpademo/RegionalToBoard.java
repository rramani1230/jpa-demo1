package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RegionalToBoard")
public class RegionalToBoard {

     @Id
     @NotNull
     private int regionalManId;

     @NotNull
     private int boardMemId;

     @OneToOne
     @NotNull
     private RegionalManager regionalManager;

     @OneToOne
     @NotNull
     private BoardMember boardMember;



     public RegionalToBoard (RegionalManager regionalManager,
     BoardMember boardMember) {
          this.regionalManager = regionalManager;
          this.boardMember = boardMember;
          this.regionalManId = this.regionalManager.getId();
          this.boardMemId = this.boardMember.getId();
     }

     public int getRegionalManId () {
          return this.regionalManId;
     }

     public void setRegionalManId (int regionalManId) {
          this.regionalManId = regionalManId;
     }

     public RegionalManager getRegionalManaager () {
          return this.regionalManager;
     }

     public void setRegionalManager (RegionalManager regionalManager) {
          this.regionalManager = regionalManager;
     }


     public int getBoardMemId () {
          return this.boardMemId;
     }

     public void setBoardMemberId (int boardMemId) {
          this.boardMemId = boardMemId;
     }

     public BoardMember getBoardMember () {
          return this.boardMember;
     }

     public void setBoardMember (BoardMember boardMember) {
          this.boardMember = boardMember;
     }

}
