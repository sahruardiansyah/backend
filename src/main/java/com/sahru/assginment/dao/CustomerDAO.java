package com.sahru.assginment.dao;

import com.sahru.assginment.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {

	// Dummy database. Initialize with some dummy values.
	private static List<Customer> customers;
	{
		customers = new ArrayList();
		customers.add(new Customer("sahru",12));
		customers.add(new Customer("ardiansyah",30));
		customers.add(new Customer("Ria", 50));
		customers.add(new Customer("riski",51));

	}

	/**
	 * Returns list of customers from dummy database.
	 *
	 * @return list of customers
	 */
	public List list() {
		return customers;
	}

	/**
	 * Return customer object for given age from dummy database. If customer is
	 * not found for id, returns null.
	 *
	 * @param age
	 *            customer age
	 * @return customer object for given age
	 */
	public Customer get(int age) {

		for (Customer c : customers) {
			   if (c.getAge()==age)
					return c;
			}
		return null;
	}

	/**
	 * Create new customer in dummy database. Updates the id and insert new
	 * customer in list.
	 * 
	 * @param customer
	 *            Customer object
	 * @return customer object with updated age
	 */
	public Customer create(Customer customer) {
		customers.add(customer);
		return customer;
	}


}