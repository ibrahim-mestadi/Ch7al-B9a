package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entites.Produit;

import java.io.IOException;
import java.util.List;

import dao.IProduitDao;
import dao.ProduitDaoImpl;


public class ControleurServlet extends HttpServlet {
	private IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl() ;
	}
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		else if(path.equals("/chercher.do")) {
			String motClet = request.getParameter("motCle") ;
			ProduitModel model = new ProduitModel() ;
			model.setMotCle(motClet) ;
			List<Produit> produits = metier.produitParMC(motClet);
			model.setPds(produits) ;
			
			request.setAttribute("model", model) ;
			request.getRequestDispatcher("Produit.jsp").forward(request, response);

			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
