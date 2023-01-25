package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import model.Produit;

@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null) 
		{
			if(request.getParameter("delete")!=null) 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Singleton.getInstance().getDaoProduit().delete(id);
				response.sendRedirect("produit");
			}
			else 
			{
				Integer id = Integer.parseInt(request.getParameter("id"));
				Produit p = Singleton.getInstance().getDaoProduit().findById(id);
			
				request.setAttribute("produit", p);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateProduit.jsp").forward(request, response);
			}
		}
		else 
		{
			List<Produit> produits = Singleton.getInstance().getDaoProduit().findAll();
			request.setAttribute("produits", produits);
			this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp").forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			Double prix = Double.parseDouble(request.getParameter("prix"));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			String libelle= request.getParameter("libelle");
					
			Produit s = new Produit(prix, stock, libelle);
			Singleton.getInstance().getDaoProduit().insert(s);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			Double prix = Double.parseDouble(request.getParameter("prix"));
			Integer stock = Integer.parseInt(request.getParameter("stock"));
			String libelle= request.getParameter("libelle");
					

			Produit s = new Produit(id, prix, stock, libelle);
			Singleton.getInstance().getDaoProduit().update(s);
		}
		
		response.sendRedirect("produit");
	}
}
