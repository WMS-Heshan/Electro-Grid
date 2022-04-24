package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Employee;
@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		String hql = "FROM Employee as atcl ORDER BY atcl.employeeId";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		Employee employe1 = getEmployeeById(employee.getEmployeeId());
		employe1.setName(employee.getName());
		employe1.setPhonenumber(employee.getPhonenumber());
		employe1.setEmailaddress(employee.getEmailaddress());
		employe1.setEmployeetype(employee.getEmployeetype());
		employe1.setDescription(employee.getDescription());

		entityManager.flush();
	}
	@Override
	public void deleteEmployee(int employeeId) {
		entityManager.remove(getEmployeeById(employeeId));
	}
	@Override
	public boolean employeeExists(String name, String phonenumber ) {
		String hql = "FROM Employee atcl WHERE atcl.name = ?  and atcl.phonenumber = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, phonenumber).getResultList().size();
		return count > 0 ? true : false;
	}
}
