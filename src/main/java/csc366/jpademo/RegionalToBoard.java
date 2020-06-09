package csc366.jpademo;

import java.util.Set;
import java.util.HashSet;
import java.util.StringJoiner;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BoardToRegional")
public class RegionalToBoard {

     @Id
     @NotNull
     private int regionalManagerId;

     @NotNull
     private int boardMemberId;


     public RegionalToBoard (int regionalManagerId, int boardMemberId) {
          this.regionalManagerId = regionalManagerId;
          this.boardMemberId = boardMemberId;
     }

     public int getRegionalManagerId () {
          return this.regionalManagerId;
     }

     public void setRegionalManagerId (int regionalManagerId) {
          this.regionalManagerId = regionalManagerId;
     }

     public int getBoardMemberId () {
          return this.boardMemberId;
     }

     public void setBoardMemberId (int boardMemberId) {
          this.boardMemberId = boardMemberId;
     }

}
