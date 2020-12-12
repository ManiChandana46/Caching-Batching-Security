package com.cg.emp.ms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Employeeee {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Long empId;

	@Size(min = 4, max = 20, message = "Name length should be min 4 and max 20.")
	private String firstName;

	@Size(min = 4, max = 20, message = "Name length should be min 4 and max 20.")
	private String lastName;

	@Email(message = "Email is not valid.")
	private String email;

	@Min(value = 5000, message = "Salary should be min 5000")
	@Max(value = 1000000, message = "Salary should be max 100000")
	private Integer salary;

	public Employeeee() {
		super();
	}

	public Employeeee(Long empId,
			@Size(min = 4, max = 20, message = "Name length should be min 4 and max 20.") String firstName,
			@Size(min = 4, max = 20, message = "Name length should be min 4 and max 20.") String lastName,
			@Email(message = "Email is not valid.") String email,
			@Min(value = 5000, message = "Salary should be min 5000") @Max(value = 1000000, message = "Salary should be max 100000") Integer salary) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + "]";
	}

}
