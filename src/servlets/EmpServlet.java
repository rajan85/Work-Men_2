package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String owner = getServletConfig().getInitParameter("owner");
		String fname = request.getParameter("T1");
		String lname = request.getParameter("T2");
		String dob = request.getParameter("T3");
		String dpt = request.getParameter("T4");
		String desg = request.getParameter("T5");
		int bSal = Integer.parseInt(request.getParameter("T6"));
		String qual = request.getParameter("T7");
		String addr = request.getParameter("T8");
		String city = request.getParameter("T9");
		String pin = request.getParameter("T10");
		long phone = Long.parseLong(request.getParameter("T11"));
		Employee e = new Employee(fname, lname, dob, dpt, desg, bSal, qual, addr, city, pin, phone);
		EmployeeDao edao = new EmployeeDao();
		String result = edao.AddRecord(e);

		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<header>");
		pw.print("<h1>CONGRATULATIONS!!!!</H1>");
		pw.print("<h2> YOUR DATA IS </h2>");
		pw.print("<table>");
		pw.print("<br><tr><td>Name:</td>");
		pw.print("<td>" + fname + lname + "</td></tr");
		pw.print("<br><tr><td>Date Of Birth:</td>" + dob + "</tr");
		pw.print("<br><tr><td>Department:</td>" + dpt + "</tr");
		pw.print("<br><tr><td>Designation:</td>" + desg + "</tr");
		pw.print("<br><tr><td>Basic Salary:</td>" + bSal + "</tr");
		pw.print("<br><tr><td>Educational Qualification:</td>" + qual + "</tr");
		pw.print("<br><tr><td>Full Address:</td>" + addr + city + pin + "</tr");
		pw.print("<br><tr><td>Phone:</td>" + phone + "</tr");
		pw.print("<br><h2>" + result + "</h2>");
		pw.println("</table></body></html>");

	}

}
