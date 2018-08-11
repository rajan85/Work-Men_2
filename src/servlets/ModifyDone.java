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
 * Servlet implementation class ModifyDone
 */
public class ModifyDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		
		if(edao.modify(e)){
			pw.print("<h1>CONGRATULATIONS!!!!</H1>");
			pw.print("<h2> YOUR DATA IS UPDATED SUCESSFULLY</h2>");
		}
		else{
			pw.print("<h1SORRY !!!!</H1>");
			pw.print("<h2> YOUR DATA IS NOT UPDATED</h2>");
		}
	}

}
