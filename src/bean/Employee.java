package bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employee {
	private int id, basicSalary, netSalary;
	private String firstName, lastName, department, designation, city, address, qualification, pin;
	private Date dateOfBirth, joinDate;
	private long phone;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String dateOfBirth, String department, String designation,
			int basicSalary, String qualification, String address, String city, String pin, long phone) {
		super();
		// this.id = id;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try {
			d = sd.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.basicSalary = basicSalary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.designation = designation;
		this.city = city;
		this.address = address;
		this.qualification = qualification;
		this.pin = pin;
		this.dateOfBirth = new Date(d.getTime());
		this.phone = phone;
		this.joinDate = new java.sql.Date(new java.util.Date().getTime());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date d = null;
		try {
			d = sd.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dateOfBirth = new Date(d.getTime());

	}

	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = new java.sql.Date(new java.util.Date().getTime());
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
