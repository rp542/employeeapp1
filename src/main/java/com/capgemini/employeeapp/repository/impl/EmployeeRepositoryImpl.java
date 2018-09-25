package com.capgemini.employeeapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.employeeapp.entities.Employee;
import com.capgemini.employeeapp.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
@Override
	public Employee addEmployee(Employee employee) {
		int count = jdbcTemplate.update("INSERT into employee VALUES(?,?,?,?)",
				new Object[] { employee.getEmployeeId(), employee.getEmployeeName(), employee.getEmployeeDepartment(),
						employee.getEmployeeSalary() });
		if (count != 0)
			return employee;
		else
			return null;

	}
@Override
	public Employee updateEmployee(Employee employee) {
		int count = jdbcTemplate.update("UPDATE employee SET employee_Name=?,employee_Department=?,employee_Salary=? WHERE employee_id=?" ,
				new Object[] { employee.getEmployeeName(), employee.getEmployeeDepartment(),
						employee.getEmployeeSalary(), employee.getEmployeeId()});
		if (count != 0)

			return employee;
		else
			return null;
	}
@Override
	public boolean deleteEmployee(int employeeId) {
		int count = jdbcTemplate.update("DELETE FROM employee WHERE employee_id=?", new Object[] { employeeId });
		
				if(count != 0)
					return true;
				else 
					return false;
	}
@Override
	public Employee findEmployeeById(int employeeId) {
		return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE employee_id=?", new Object[] { employeeId },
				new EmployeeRowMapper());

	}
@Override
	public List<Employee> findAllEmployees() {
		return jdbcTemplate.query("SELECT * FROM employee", new Object[] {}, new EmployeeRowMapper());
	}

	private class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setEmployeeDepartment(rs.getString(3));
			employee.setEmployeeSalary(rs.getDouble(4));
			return employee;
		}
	}

}