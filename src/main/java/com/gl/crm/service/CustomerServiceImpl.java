package com.gl.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.crm.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> CustomerData = session.createQuery("from Customer").list();
		return CustomerData;
	}

	@Override
	public Customer findById(int theId) {
		Customer CustomerData = new Customer();

		// find record with Id from the database table
		CustomerData = session.get(Customer.class, theId);

		return CustomerData;
	}

	@Transactional
	public void save(Customer theCutsomerData) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCutsomerData);

		tx.commit();

	}

	@Transactional
	public void deleteById(int theId) {
		Transaction tx = session.beginTransaction();

		// get transaction
		Customer theCustomer = session.get(Customer.class, theId);

		// delete record
		session.delete(theCustomer);

		tx.commit();

	}
	
	// print the loop
			@Transactional
			public void print(List<Customer> CustomerData) {

				for (Customer CD : CustomerData) {
					System.out.println(CD);
				}
			}


}
