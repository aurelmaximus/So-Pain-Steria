package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Client;
import model.Commande;

@WebServlet("/commande")
public class CommandeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null) 
		{
			if(request.getParameter("delete")!=null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoCommande().delete(id);
				response.sendRedirect("commande");
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Commande cmd = Singleton.getInstance().getDaoCommande().findById(id);
				

				request.setAttribute("commande", cmd);
				request.setAttribute("filieres", filieres);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateCommande.jsp").forward(request, response);
			}
		}
		else 
		{
			List<Commande> commandes = Singleton.getInstance().getDaoCommande().findAll();
			request.setAttribute("commandes", commandes);
			this.getServletContext().getRequestDispatcher("/WEB-INF/commandes.jsp").forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			String email= request.getParameter("email");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));					
			Commande cmd = new Commande(nom,prenom,email,f);
			Singleton.getInstance().getDaoCommande().insert(cmd);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Integer idClient = Integer.parseInt(request.getParameter("client"));
			Client client = Singleton.getInstance().getDaoCompte().findById(idClient);
			
			String nom = request.getParameter("nom");
			String email= request.getParameter("email");
					
			Commande cmd = new Commande(id,client,heure,minute);
			Singleton.getInstance().getDaoCommande().update(cmd);
		}
		
		response.sendRedirect("commande");
	}
}
