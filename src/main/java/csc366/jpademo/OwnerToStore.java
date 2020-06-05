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

public class OwnerToStore {

     private int ownerId;
     private int storeId;

     public OwnerToStore (int ownerId, int storeId) {
          this.ownerId = ownerId;
          this.storeId = storeId;
     }

     public int getOwnerId() {
        return ownerId;
     }

     public void setOwnerId() {
             this.ownerId = ownerId;
     }

     public int getStoreId() {
        return storeId;
     }

     public void setStoreId() {
        this.storeId = storeId;
     }


}
