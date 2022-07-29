package fr.eni.projet.encheres.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Cette servlet redirige vers la page d'accueil
 * @author Groupe Benjamin-Sylvie-Goulven
 *
 */
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ACCUEIL = "/WEB-INF/jsp/accueil.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher( ACCUEIL ).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}