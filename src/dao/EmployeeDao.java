package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
import connection.MyConnection;

public class EmployeeDao {
	private Connection con = MyConnection.getConnection();
	private PreparedStatement ps, ps2;
	private Statement s, s2;
	private ResultSet rst, rst2;
	private int basic, hra, da, it, netSalary;
	private String result;

	public String AddRecord(Employee e) {
		try {

			int id = 0;
			con.setAutoCommit(false);
			s = con.createStatement();
			rst = s.executeQuery("select EmpNo from employee");

			ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			if (rst.last() == true) {
				id = rst.getInt(1) + 1;

			} else {
				id = 1001;

			}
			ps.setInt(1, id);
			ps.setString(2, e.getFirstName());
			ps.setString(3, e.getLastName());
			ps.setDate(4, e.getJoinDate());
			ps.setString(5, e.getDesignation());
			ps.setString(6, e.getDepartment());
			ps.setInt(7, e.getBasicSalary());
			int a = ps.executeUpdate();
			if (a > 0)
				result += "Record inserted successfully in Employee_Table";
			else {
				result += "Problem inserting the record in Employee_Table";
			}

//			s = con.createStatement();
//			rst = s.executeQuery("select EmpNo from employee");
//			rst.last();
//			id = rst.getInt(1);

			ps = con.prepareStatement("insert into employee_personal_info values(?,?,?,?,?,?,?)");
			ps.setDate(1, e.getDateOfBirth());
			ps.setString(2, e.getQualification());
			ps.setString(3, e.getAddress());
			ps.setString(4, e.getCity());
			ps.setString(5, e.getPin());
			ps.setLong(6, e.getPhone());
			ps.setInt(7, id);

			int b = ps.executeUpdate();
			if (b > 0) {
				con.commit();
				return result + "\n" + "Record inserted in Employee_Personal_Info_Table successfully";

			} else {
				return result + "\n" + "Problem inserting the record in Employee_Personal_Info_Table..";
				/*
				 * System.out.
				 * println("Rolling back the record inserted in Employee_table"
				 * ); con.rollback();
				 */
			}

		} catch (SQLException sqle1) {
			sqle1.printStackTrace();
			return result + "\n" + "some error occured.";
		}
	}

	public boolean deleteRecord(int empNo) {
		boolean flag = false ;
		try {
			ps = con.prepareStatement("delete from employee where EmpNo = ?");
			ps.setInt(1, empNo);
			int status = ps.executeUpdate();
			if (status > 0)
			{
				System.out.println("record deleted!!!!");
				flag = true;
			}
			else
				System.out.println("record not deleted!!!!");
		} catch (SQLException sqle) {
			// System.out.println("record not deleted!!!!");
			sqle.printStackTrace();
		}
		return flag;

	}

	public Employee displayOneRecord(int empNo) {
		Employee e = new Employee();
		try {
			ps = con.prepareStatement("select * from employee where EmpNo = ?");

			ps.setInt(1, empNo);
			rst = ps.executeQuery();
			if (rst.next() == false) {
				System.out.println("record doesn't exist!!!");
				return e;
			} else {
				e.setId(rst.getInt(1));
				e.setFirstName(rst.getString(2));
				e.setLastName(rst.getString(3));
				e.setJoinDate(rst.getDate(4));
				e.setDesignation(rst.getString(5));
				e.setDepartment(rst.getString(6));
				e.setBasicSalary(rst.getInt(7));
			}
			ps2 = con.prepareStatement("select * from employee_personal_info where EmpNo = ?");

			ps2.setInt(1, empNo);
			rst2 = ps2.executeQuery();
			rst2.next();
			e.setDateOfBirth(rst2.getString(1));
			System.out.println("1111");
			e.setQualification(rst2.getString(2));
			e.setAddress(rst2.getString(3));
			e.setCity(rst2.getString(4));
			e.setPin(rst2.getString(5));
			e.setPhone(rst2.getLong(6));
			return e;

		} catch (SQLException sqle) {
			System.out.println("record in 2nd table doesn't exist!!!");
			sqle.printStackTrace();
			return e;
		}
	}

	public List<Employee> displayAllRecord() {
		List<Employee> li = new ArrayList<Employee>();
		try {
			s = con.createStatement();
			s2 = con.createStatement();
			rst = s.executeQuery("select * from employee");
			rst2 = s2.executeQuery("select DateOfBirth from employee_personal_info");
			// System.out.println("Emp ID Full Name Date of Birth Designation
			// Department Net Salary");

			while (rst.next() && rst2.next()) {
				Employee e = new Employee();
				basic = rst.getInt(7);
				hra = basic / 5;
				da = 2 * (basic / 5);
				it = (basic + hra + da) / 10;
				netSalary = basic + hra + da - it;
				/*
				 * System.out.println(rst.getInt(1) + "\t" + rst.getString(2) +
				 * " " + rst.getString(3) + "\t" + rst2.getDate(1) + "\t" +
				 * rst.getString(5) + "\t" + rst.getString(6) + "\t" +
				 * netSalary);
				 */
				e.setId(rst.getInt(1));
				e.setFirstName(rst.getString(2));
				e.setLastName(rst.getString(3));
				e.setDateOfBirth(rst2.getDate(1));
				e.setDesignation(rst.getString(5));
				e.setDepartment(rst.getString(6));
				e.setNetSalary(netSalary);
				li.add(e);

			}
			return li;

		} catch (SQLException e) {
			System.out.println("record doesn't exist!!!");
			e.printStackTrace();
			return li;
		}
	}

	public boolean checkAvailable(int empNo) {
		boolean flag = false;
		try {
			ps = con.prepareStatement("select * from employee where EmpNo = ?");

			ps.setInt(1, empNo);
			rst = ps.executeQuery();
			if (rst.next() == false) {
				System.out.println("record doesn't exist!!!");
				
			} 
			else flag = true;
				
		} catch (SQLException e) {
			System.out.println("sorry something went wrong!!!!");
			e.printStackTrace();
		}
		return flag;
	}
	public boolean modify(Employee e)
	{
		boolean flag=false;
		try {
			con.setAutoCommit(false);
			
			
				ps = con.prepareStatement("update employee set  firstname=?, lastname=?,  designation=?, department=?, salary=? where EmpNo = ?");
				ps.setString(1,e.getFirstName());
				ps.setString(2, e.getLastName());
				ps.setString(3, e.getDesignation());
				ps.setString(4, e.getDepartment());
				ps.setInt(5, e.getBasicSalary());
				ps.setInt(6, e.getId());
				int a = ps.executeUpdate();
				
				ps2 = con.prepareStatement("update employee_personal_info set  dateofbirth=?, education=?, address=?, city=?, pin=?, phone=?, where EmpNo = ?");
				ps2.setDate(1,e.getDateOfBirth());
				ps2.setString(2, e.getQualification());
				ps2.setString(3, e.getAddress());
				ps2.setString(4, e.getCity());
				ps2.setString(5, e.getPin());
				ps2.setLong(6, e.getPhone());
				ps2.setInt(7, e.getId());
				int b = ps.executeUpdate();
				if(a>0 && b>0)
				{
					con.commit();
					flag = true;
				}
				else flag = false;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		
	}
		return flag;
	}
}
