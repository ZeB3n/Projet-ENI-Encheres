package fr.eni.projet.encheres.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/ServletProfil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String PROFIL = "/WEB-INF/jsp/profil.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( PROFIL ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
