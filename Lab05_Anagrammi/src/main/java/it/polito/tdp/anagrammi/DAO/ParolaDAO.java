package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;

//SELECT * from parola AS p WHERE  p.nome="abace"

public class ParolaDAO {
	
	public List<Parola> getTutteLeParole() {

		final String sql = "SELECT * from parola";

		List<Parola> parole = new LinkedList<Parola>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Parola p = new Parola(rs.getInt("id"), rs.getString("nome"));
				parole.add(p);
			}

			conn.close();
			
			return parole;
			

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public boolean getCorretto (String parolaAnagrammata) {

		final String sql = "SELECT id from parola where nome=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, parolaAnagrammata);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				return true;
			}

			conn.close();
			

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		return false;
	}
	
}
	