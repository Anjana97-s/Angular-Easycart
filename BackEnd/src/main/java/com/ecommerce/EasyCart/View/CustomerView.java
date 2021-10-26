/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.View;
import java.util.Date;

import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Json.Json;

public class CustomerView {
    
    private final int customerId;
    private final String name;
    private final String email;
    private final short status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public CustomerView(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.status = customer.getStatus();
        this.createDate = customer.getCreateDate();
        this.updateDate = customer.getUpdateDate();
    }

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
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
