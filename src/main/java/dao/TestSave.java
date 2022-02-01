package dao;

import java.util.List;

import metier.entites.Produit;

public class TestSave {

	public static void main(String[] args) {
		ProduitDaoImpl dao = new ProduitDaoImpl() ;
		
		List<Produit> produit = dao.produitParMC("S") ;
		
		for(Produit p : produit) {
			System.out.println(p.toString());
		}
		


	}
	
	

}
