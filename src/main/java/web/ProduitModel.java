package web;
import java.util.ArrayList;
import java.util.List;

import metier.entites.*;
public class ProduitModel {
	private String motCle;
	private List<Produit> pds = new ArrayList<Produit>();
	/**
	 * @return the motCle
	 */
	public String getMotCle() {
		return motCle;
	}
	/**
	 * @param motCle the motCle to set
	 */
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	/**
	 * @return the pds
	 */
	public List<Produit> getPds() {
		return pds;
	}
	/**
	 * @param pds the pds to set
	 */
	public void setPds(List<Produit> pds) {
		this.pds = pds;
	}

}
