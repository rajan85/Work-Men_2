package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;

/**
 * Servlet implementation class ShowEmpInfoAll
 */
public class ShowEmpInfoAll extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> li;
		EmployeeDao edao = new EmployeeDao();
		li = edao.displayAllRecord();
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		// pw.print("<link rel=\"stylesheet\" type=\"text/css\"
		// href=\"SS.css\">");
		// pw.println("<style>table{ border-collapse: collapse;}table, th, td {
		// border: 1px solid black;}");
		pw.println("</head><body>");
		pw.println("<table  align=\"center\" border=\"1px\" >");
		pw.println("<tr><td> EMPLOYEE ID </td><td> FULL NAME </td><td> DATE OF BIRTH </td>"
				+ "<td> DESIGNATION </td><td> DEPARTMENT </td><td> NET SALARY </td></tr>");
		for (Employee e : li) {
			pw.println("<tr><td>" + e.getId() + " </td><td>" + e.getFirstName() + " " + e.getLastName() + " </td><td>"
					+ e.getDateOfBirth() + " </td><td>" + e.getDesignation() + " </td><td>" + e.getDepartment()
					+ " </td><td> " + e.getNetSalary() + "</td></tr>");

		}
		pw.println("</table></body></html>");

	}
}
