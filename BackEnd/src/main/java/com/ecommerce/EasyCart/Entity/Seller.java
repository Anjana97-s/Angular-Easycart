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

import com.ecommerce.EasyCart.Entity.Seller.Status;
import com.ecommerce.EasyCart.Forms.SellerForm;
import com.ecommerce.EasyCart.Entity.Seller;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seller {
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
    private Integer sellerId;
    private String firstName;
    private String address;
    private String city;
    private String state;
        private Integer pin;

    private String country;
    private String phone;

    private String email;
    private byte[] image;
    private String filename;

   private String password;
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
     public Seller() {
    }

    public Seller(Integer sellerId) {
        this.sellerId = sellerId;
    }
     public Seller(String firstName,String address,String city,String state,Integer pin,String country,String phone,String email, String password,byte[] image,String filename)
     {
         this.firstName=firstName;
         this.address=address;
         this.city=city;
         this.state=state;
         this.pin=pin;
         this.country=country;
         this.phone=phone;
         this.email=email;
         this.password = password;
this.image=image;
this.filename=filename;
        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
     }
          public Seller update(SellerForm form) {
         this.firstName=form.getFirstName();
         this.address=form.getAddress();
         this.city=form.getCity();
         this.state=form.getState();
         this.pin=form.getPin();
         this.country=form.getCountry();
          this.image=form.getImage();
    this.filename=form.getFilename();
         return this;
          }
        public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
        
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
       
        public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
         public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
         public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
         public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
          public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
         public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
    public String getPassword() {
		return password;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sellerId != null ? sellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Seller)) {
            return false;
        }
        return Objects.equals(sellerId, ((Seller) object).sellerId);
    }

    @Override
    public String toString() {
        return "com.ecommerce.EasyCart.Entity.Admin [ sellerId=" + sellerId + "]";
    }
     }

