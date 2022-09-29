package com.gl.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.crm.entity.Customer;
import com.gl.crm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/showCutsomers")
	public String showCustomersData(Model theModel) {
		List<Customer> theCustomersData = customerService.findAll();
		theModel.addAttribute("crmData", theCustomersData);
		return "customers-list";

	}
	
	// Show add from
		@RequestMapping("/addCustomer")
		public String showAddFormCustomer(Model theModel) {
			Customer theCustomerData = new Customer();
			theModel.addAttribute("CustomerData", theCustomerData);
			return "add-customer";
		}
	
		
		// Adding Customer
		@PostMapping("/addNew")
		public String addCustomer(@RequestParam("id") int id, @RequestParam("fname") String fname,
				@RequestParam("lname") String lname, @RequestParam("email") String email) {

			Customer theCustomer ;
			if(fname!="" && lname!="" && email!="") {
			if (id != 0) {
				theCustomer = customerService.findById(id);
				theCustomer.setFname(fname);
				theCustomer.setLname(lname);
				theCustomer.setEmail(email);

			} else
				theCustomer = new Customer( fname, lname, email);

			customerService.save(theCustomer);
			}
			
			return "redirect:/showCutsomers";

		}
	
		
		// Show add from
		@RequestMapping("/showUpdateCustomer/{id}")
		public String showUpdateFormCustomer(@PathVariable("id") int theId, Model theModel) {
			Customer theCustomer = customerService.findById(theId);
			theModel.addAttribute("CustomerData", theCustomer);
			return "add-customer";
		}
		
		// Delete Customer
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id") int theId) {
			customerService.deleteById(theId);
			return "redirect:/showCutsomers";

		}
}
