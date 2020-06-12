package csc366.jpademo;

import java.util.*;
import javax.persistence.*;

@Entity(name="RegionalManager")
public class RegionalManager extends Manager{

     // many regional managers will report to a single board member
     @ManyToOne
     private BoardMember boardMember;

     @OneToMany // One regional managers map to multiple location managers
     private List<LocationManager> locationManagers = new ArrayList<>();

     public RegionalManager (int id, String name, String email,
     String dateOfBirth, String phoneNo) {
          super(id,name,email,dateOfBirth,phoneNo);
     }


     public BoardMember getBoardMember() {
          return this.boardMember;
     }

     public void setBoardMember(BoardMember boardMember) {
          this.boardMember = boardMember;
     }

     public List<LocationManager> getLocationManagers() {
          return this.locationManagers;
     }

     public void setLocationManagers(List<LocationManager> locationManagers) {
          this.locationManagers = locationManagers;
     }

     

     
}
