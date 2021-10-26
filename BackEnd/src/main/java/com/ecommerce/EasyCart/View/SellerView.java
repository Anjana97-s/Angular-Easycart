/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;
import java.util.Date;
import com.ecommerce.EasyCart.Entity.Seller;
import com.ecommerce.EasyCart.Json.Json;
/**
 *
 * @author anjana
 */
public class SellerView {
     private final Integer sellerId;
    private final String firstName;
    private final String address;
    private final String city;
    private final String state;
    private final Integer pin;

    private final String country;
    private final String phone;

    private final String email;
    private final short status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;
     private final byte[] image;
  private final String password;
  private final String filename;
    public SellerView(Seller seller) {
        this.sellerId = seller.getSellerId();
         this.firstName=seller.getFirstName();
         this.address=seller.getAddress();
         this.city=seller.getCity();
         this.state=seller.getState();
         this.pin=seller.getPin();
         this.country=seller.getCountry();
         this.phone=seller.getPhone();
           this.image=seller.getImage();
        this.filename=seller.getFilename();
                this.password=seller.getPassword();

         this.email=seller.getEmail();
        this.status = seller.getStatus();
        this.createDate = seller.getCreateDate();
        this.updateDate = seller.getUpdateDate();
    }
     public Integer getSellerId() {
		return sellerId;
	}
	 public String getPassword() {
		return password;
	}
          public byte[] getImage() {
        return image;
    }
public String getFilename() {
        return filename;
    }

        
	public String getFirstName() {
		return firstName;
	}
	
       
        public String getAddress() {
		return address;
	}
	
         public String getCity() {
		return city;
	}
	
         public String getState() {
		return state;
	}
	
         public String getCountry() {
		return country;
	}
	
          public Integer getPin() {
		return pin;
	}
	
         public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
    public short getStatus() {
		return status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}


}
