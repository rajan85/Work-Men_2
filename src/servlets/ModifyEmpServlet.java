package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;

/**
 * Servlet implementation class ModifyEmpServlet
 */
public class ModifyEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empNo = Integer.parseInt(request.getParameter("Eid"));
		Employee e = new Employee();
		EmployeeDao edao = new EmployeeDao();
		e= edao.displayOneRecord(empNo);
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("<title>modification form</title>");
		pw.println("</head><body>");
		pw.println("<h2 align='center'>enter details of new employee</h2>");
		pw.println("<form action='ModifyDone' method='post' style='color: blue;'>");
		pw.println("<table align='center' cellspacing='7'>");
		pw.print("<tr> FIRST NAME:<input TYPE='text' NAME='T1' id='i1' required autofocus='autofocus' value="+e.getFirstName()+"></tr><br>");
		
		pw.print("<tr>LAST NAME: <input TYPE='text' NAME='T2' id='i2' required value="+e.getLastName()+"></tr><br>");
		
		pw.print("<tr>DATE OF BIRTH(dd-mm-yyyy): <input TYPE='date'  NAME='T3' id='i3' max='2000-01-01' required value="+e.getDateOfBirth()+"></tr><br>");
		
		pw.print("<tr>DEPARTMENT:<input TYPE='text' NAME='T4' id='i4' required value="+e.getDepartment()+"></tr><br>");
		
		pw.print("<tr>DESIGNATION :<input TYPE='text' NAME='T5' id='i5' required value="+e.getDesignation()+"></tr><br>");
		
		pw.print("<tr>BASIC SALARY :<input TYPE='number' NAME='T6' id='i6' required value="+e.getBasicSalary()+"></tr><br>");
		
		pw.print("<tr>QUALIFICATION: <input list='degrees' NAME='T7' id='i7' required value="+e.getQualification()+"></tr><br>");
//		pw.println("<datalist id=degrees>");
//		pw.println("<option value='B.tech'>B.tech(CSE)</option>");
//		pw.println("<option value='B.tech'>B.tech(ME)</option>");
//		pw.println("<option value='B.tech'>B.tech(ECE)</option>");
//		pw.println("<option value='B.tech'>B.tech(EE)</option>");
//		pw.println("</datalist></td></tr>");
		
		pw.println("<TR>ADDRESS:<textarea  name ='T8' id='i8'>"+e.getAddress()+"</textarea> </TR><br>");
		
		pw.print("<tr>CITY:<input TYPE='text' NAME='T9' id='i9' required value="+e.getCity()+"><br></td></tr>");
		
		pw.print("<tr>PIN: <input TYPE='text' NAME='T10' id='j1' required value="+e.getPin()+"></tr><br>");
		
		pw.print("<tr>PHONE :<input TYPE='number' NAME='T11' id='j2' required value="+e.getPhone()+"></tr><br>");
		
		pw.println("<tr><td><input type='submit' value='ready to submit!!'></input></td>");
		pw.println("<td><input type='reset' value='reset fields'></input></td></tr>");
		
		pw.println("</table></form>");
		
		
	} 

}
