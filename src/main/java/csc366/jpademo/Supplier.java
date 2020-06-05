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


public class Supplier {

     private int supplierId;
     private String supplierName;
     private String supplierAddress;
     private String supplierCounty;
     private String licenseNo;
     private double qualityRating;

     public int getSupplierId () {
          return this.supplierId;
     }

     public void setSupplierId (int supplierId) {
          this.supplierId = supplierId;
     }

     public String getSupplierAddress () {
          return this.supplierAddress;
     }

     public void setSupplierAddress (String supplierAddress) {
          this.supplierAddress = supplierAddress;
     }

     public String getSupplierCounty () {
          return this.supplierCounty;
     }

     public void setSupplierCounty (String supplierCounty) {
          this.supplierCounty = supplierCounty;
     }

     public String getLicenseNo () {
          return this.licenseNo;
     }

     public void setLicenseNo (String licenseNo) {
          this.licenseNo = licenseNo;
     }

     public double getQualityRating () {
          return this.qualityRating;
     }

     public void setQualityRating (double qualityRating) {
          this.qualityRating = qualityRating;
     }
}
