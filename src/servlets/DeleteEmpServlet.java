package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

/**
 * Servlet implementation class DeleteEmpServlet
 */
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("Eid"));
		EmployeeDao edao =new EmployeeDao();
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<head><title>status</title></head>");
		if(edao.deleteRecord(id))
		{
			pw.println("<body><h1>DONE SUCESSFULLY</h1></body></html>");
		}
		else {
			pw.println("<body><h1>SOMETHING WENT WRONG!!!</h1></body></html>");
		}
		
		
	}

}
