import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class UF2ACT3 {

	public static void Statement(String usuari, String contrasenya) {

		Connection connection = null;
		Statement stmt = null;

		try
		{
			// Conectem amb la base de dades
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/alumnes", "usuari", "usuari");

			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT nom,contrasenya from usuaris WHERE nom='" + usuari + "' and contrasenya='" + contrasenya + "'");

			int count = 0;
			while(rs.next()){
				count = count+1;
			}
			if (count==1){
				JOptionPane.showMessageDialog(null,"Sessio iniciada correctament");
			}else if (count>1){
				JOptionPane.showMessageDialog(null,"Usuari duplicat, no s'ha pogut iniciar sessio");
			} else {
				JOptionPane.showMessageDialog(null, "El Usuari no existeix");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
