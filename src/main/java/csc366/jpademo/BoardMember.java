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


public class BoardMember extends CompanyPerson {

     public String boardStrategy;
     public boolean hasDegree;

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
}
