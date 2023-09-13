package com.dnb.jdbcdemo2.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//implicitly it creates args constructor
@NoArgsConstructor  //implicitly it creates default constructor
@Entity
public class Customer {
	@Id
	private int CustomerId;
	private String CustomerName;
	private String CustomercontactNumber;
	private String Customeraddress;
	private String CustomerUUID;
	private String CustomerPAN;
	
}
