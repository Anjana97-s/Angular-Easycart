/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Forms;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.ecommerce.EasyCart.Form.Validation.Password;

/**
 *
 * @author anjana
 */
public class SellerForm {
    
    @Size(max = 50)
    private String firstName;
    
    @Size(max = 100)
    private String address;
    @Size(max = 50)
    private String city;
    @Size(max = 50)
    private String state;
        private Integer pin;
    @Size(max = 50)
    private String country;
@Size(max = 10) 
    private String phone;
   @Password
    private String password;
    @Size(max = 255)
    @Email
    private String email;

  private byte[] image;
  
  private String filename;
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
       public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

}
