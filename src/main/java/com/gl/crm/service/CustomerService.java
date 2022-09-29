package com.gl.crm.service;

import java.util.List;

import com.gl.crm.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCutsomerData);

	public void deleteById(int theId);
}
