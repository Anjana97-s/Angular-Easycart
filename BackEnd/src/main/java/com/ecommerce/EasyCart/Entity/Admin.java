/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.EasyCart.Entity.Admin.Status;
import com.ecommerce.EasyCart.Forms.AdminForm;
import com.ecommerce.EasyCart.Entity.Admin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Admin {
    
     public static enum Status {
        INACTIVE((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String name;
    private String email;
    private String password;
   
    private byte status;
      private byte[] image;

    private String filename;

   
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
     public Admin() {
    }

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }
     public Admin(String name, String email, String password,byte[] image,String filename) 
     {
              this.name = name;
        this.email = email;
        this.password = password;
this.image=image;
this.filename=filename;
        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }
     public Admin update(AdminForm form) {
        this.name = form.getName();
        this.email = form.getEmail();

       this.image=form.getImage();
    this.filename=form.getFilename();
        Date dt = new Date();

        this.updateDate = dt;

        return this;
     }
       public Admin update(String name, String email) {
        this.name = name;
        this.email = email;

      
        Date dt = new Date();

        this.updateDate = dt;

        return this;
     }
public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId= adminId;
    }
public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
       
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
 public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
  @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Admin)) {
            return false;
        }
        return Objects.equals(adminId, ((Admin) object).adminId);
    }

    @Override
    public String toString() {
        return "com.ecommerce.EasyCart.Entity.Admin [ adminId=" + adminId + "]";
    }
}
