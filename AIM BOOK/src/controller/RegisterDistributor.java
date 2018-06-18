package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Distributor;

/**
 * Servlet implementation class RegisterDistributor
 */
@WebServlet("/RegisterDistributor")
public class RegisterDistributor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDistributor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String code = request.getParameter("code");
        String upLineCode = request.getParameter("upCode");
        String upLineSide = request.getParameter("upSide");
        String dbName = request.getParameter("db");
        String tel = request.getParameter("tel");
        Distributor distributor = new Distributor(lName, fName, code, upLineCode, upLineSide, tel, dbName);
        distributor.register(dbName);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	 
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
