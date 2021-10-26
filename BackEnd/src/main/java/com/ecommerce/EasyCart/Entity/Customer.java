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

import com.ecommerce.EasyCart.Entity.Customer.Status;
import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Entity.Admin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Customer {

    
	
	

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
    private Integer customerId;
    private String name;
    private String email;
    private String password;
   
    private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
    }
    
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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
	
	public Customer update(CustomerForm form) {
        this.name = form.getName();
        this.email = form.getEmail();
        //this.password = passwordEncoder.encode(form.getPassword());
        this.password=form.getPassword();
        return this;
    }

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return Objects.equals(this.customerId, other.customerId);
    }

    @Override
    public String toString() {
        return "com.ecommerce.EasyCart.Entity.User[ userId=" + customerId + " ]";
    }
    
}
