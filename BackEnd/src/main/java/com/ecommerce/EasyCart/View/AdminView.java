/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;
import java.util.Date;

import com.ecommerce.EasyCart.Entity.Admin;
import com.ecommerce.EasyCart.Json.Json;
/**
 *
 * @author anjana
 */
public class AdminView {
    
      private final int adminId;
    private final String name;
    private final String email;
    private final byte[] image;
  private final String password;
  private final String filename;
    private final short status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;
     public AdminView(Admin admin) {
        this.adminId = admin.getAdminId();
        this.name = admin.getName();
        this.email = admin.getEmail();
        this.status = admin.getStatus();
        this.image=admin.getImage();
        this.filename=admin.getFilename();
        this.createDate =admin.getCreateDate();
        this.updateDate = admin.getUpdateDate();
        this.password=admin.getPassword();
    }
     public int getAdminId() {
		return adminId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

        public String getPassword() {
		return password;
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
        public byte[] getImage() {
        return image;
    }
public String getFilename() {
        return filename;
    }

}
