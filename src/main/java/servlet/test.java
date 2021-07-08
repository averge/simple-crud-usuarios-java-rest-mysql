package servlet;

import java.io.IOException;
import java.util.List;

import daos.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario user = new Usuario();
		user.setEmail("aa@aa.com");
		user.setNombre("juan");
		user.setPassword("asd");
		
		List<Usuario> fields = null;
		try {
			fields = uDAO.getAllFields();
			System.out.print(fields);
		} catch(Exception e) {
			e.printStackTrace();}
		try {
			uDAO.agregar(user); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	Usuario usuario = new Usuario();
		UsuarioDAO uDAO = new UsuarioDAO();
		
		List<Usuario> fields = null;
		
		try {
			fields = uDAO.getAllFields();
		} catch(Exception e) {
			e.printStackTrace();*/
		doGet(request, response);
	}

}
