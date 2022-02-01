package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entites.Produit;

public class ProduitDaoImpl implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		try {
		Connection con = SingletonConnection.getConnection() ;
		PreparedStatement ps = con.prepareStatement
				("INSERT INTO PRODUIT (DESIGNATION,PRIX,QUANTITE) "
						+ "VALUES (?,?,?)") ;
		ps.setString(1, p.getDesignation());
		ps.setDouble(2, p.getPrix());
		ps.setInt(3, p.getQuantite()) ;
		ps.executeUpdate() ; 
		
		PreparedStatement ps2 = con.prepareStatement
				("SELECT MAX(ID) as MAX FROM PRODUIT") ;

		ResultSet rs = ps2.executeQuery() ;
		
		if(rs.next()) {
			p.setId(rs.getLong("MAX"));
		}
		
		ps2.close();
		ps.close();
		
		 }
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return p ;
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		Connection con = SingletonConnection.getConnection() ;
		List<Produit> pds = new ArrayList<Produit>() ;
		try {
			PreparedStatement ps = con.prepareStatement
					("SELECT *FROM PRODUIT WHERE DESIGNATION LIKE ?");
			ps.setString(1, "%"+mc+"%");
		
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				Produit p = new Produit() ;
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE")) ;
				pds.add(p) ;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pds;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit deleteProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
