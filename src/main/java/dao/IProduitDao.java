package dao;

import java.util.List;

import metier.entites.Produit;

public interface IProduitDao {
	public Produit save(Produit p) ;
	public List<Produit> produitParMC(String mc) ;
	public Produit getProduit(Long id) ;
	public Produit update(Produit p) ;
	public Produit deleteProduit(Long id) ;
}
