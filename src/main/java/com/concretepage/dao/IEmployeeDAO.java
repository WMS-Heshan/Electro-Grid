package com.concretepage.dao;
import java.util.List;
import com.concretepage.entity.Employee;
public interface IEmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int employeeId);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employee);
    boolean employeeExists(String name, String phonenumber );
}
 