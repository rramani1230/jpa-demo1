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

public class BoardToRegional {

     private int boardMemberId;
     private int regionalManagerId;

     public BoardToRegional (int boardMemberId, int regionalManagerId) {
          this.boardMemberId = boardMemberId;
          this.regionalManagerId = regionalManagerId;
     }

     public int getBoardMemberId () {
          return this.boardMemberId;
     }

     public void setBoardMemberId (int boardMemberId) {
          this.boardMemberId = boardMemberId;
     }

     public int getRegionalManagerId () {
          return this.regionalManagerId;
     }

     public void setRegionalManagerId (int regionalManagerId) {
          this.regionalManagerId = regionalManagerId;
     }
}
