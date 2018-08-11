package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;

/**
 * Servlet implementation class ShowOne
 */
public class ShowOne extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		String c = ctx.getInitParameter("color");
		/*
		 * context is written in web-app for strings which are used in every
		 * Servlet. Scontext is one per application. config param is one per
		 * servlet and is used to get the strings used frequently in servlet.
		 * config is private for each servlet
		 */
		EmployeeDao edao = new EmployeeDao();
		Employee e = edao.displayOneRecord(Integer.parseInt(request.getParameter("Eid")));
		PrintWriter pw = response.getWriter();
		pw.println("<html><head>");
		pw.println("</head><body bgcolor=" + c + ">");
		pw.println("<table>");
		pw.println("<tr><td>Employee No :	</td><td>" + e.getId() + "</td></tr>");
		pw.println("<tr><td>Employee Name :	</td><td>" + e.getFirstName() + e.getLastName() + "</td></tr>");
		pw.println("<tr><td>Designation :	</td><td>" + e.getDesignation() + "</td></tr>");
		pw.println("<tr><td>Department :	</td><td>" + e.getDepartment() + "</td></tr>");
		pw.println("<tr><td>Basic Salary :	</td><td>" + e.getBasicSalary() + "</td></tr>");
		pw.println("<tr><td>Date Of Birth :	</td><td>" + e.getDateOfBirth() + "</td></tr>");
		pw.println("<tr><td>Educational Qualification :	</td><td>" + e.getQualification() + "</td></tr>");
		pw.println("<tr><td>Address :	</td><td>" + e.getAddress() + "</td></tr>");
		pw.println("<tr><td>City :	</td><td>" + e.getCity() + "</td></tr>");
		pw.println("<tr><td>Pin :	</td><td>" + e.getPin() + "</td></tr>");
		pw.println("<tr><td>Phone :	</td><td>" + e.getPhone() + "</td></tr>");
		pw.println("</table></body></html>");

	}

}
