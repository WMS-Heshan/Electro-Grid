package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements ICustomerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as atcl ORDER BY atcl.customerId";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer customer1 = getCustomerById(customer.getCustomerId());
		customer1.setName(customer.getName());
		customer1.setMobile(customer.getMobile());
		customer1.setEmail(customer.getEmail());
		customer1.setUsername(customer.getUsername());
		customer1.setPassword(customer.getPassword());
		customer1.setAddress(customer.getAddress());

		entityManager.flush();
	}

	@Override
	public void deleteCustomer(int customerId) {
		entityManager.remove(getCustomerById(customerId));
	}

	@Override
	public boolean customerExists(String email, String username) {
		String hql = "FROM Customer as atcl WHERE atcl.email = ? and atcl.username = ?";
		int count = entityManager.createQuery(hql).setParameter(1, email).setParameter(2, username).getResultList()
				.size();
		return count > 0 ? true : false;
	}
}
