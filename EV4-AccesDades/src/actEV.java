import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.csvreader.CsvReader;

public class actEV {

	public static void main(String[] args) throws IOException,SQLException, ClassNotFoundException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesdades","root","");
			Statement stmt = con.createStatement();
			
			//consulta per a fer insert
			PreparedStatement ps = con.prepareStatement("INSERT INTO biblioteca (Titol,Autor,Any_Naixement,Any_Publicacio,Editorial,Nombre_Pagines) "
					+ "VALUE (?,?,?,?,?,?)");
			String ruta = "AE04_T1_4_JDBC_Dades1.csv";
			//Objecte per a llegir el csv
			CsvReader llegir = new CsvReader(ruta);
			
			//propietat per a llegir les capçaleres del csv
			llegir.readHeaders();	
			//com el objecte te torna un string amb tots els camps junts els separe amb el punt i coma
			llegir.setDelimiter(';');
			while(llegir.readRecord()) {
				//asigne a unes variables el valors que llig
				String titol = llegir.get(0);
				String autor = llegir.get(1);
				String anyNaix = llegir.get(2);
				String anyPubli = llegir.get(3);
				String edit = llegir.get(4);
				String numPag = llegir.get(5);
				
				
				//pase el valors a l'insert
				ps.setString(1, titol);
				ps.setString(2, autor);
				//condicional per a controlar si un camp esta vuit escriga NC
				if(anyNaix == "") {
					anyNaix = "NC";
					ps.setString(3, anyNaix);
				}else {
					ps.setString(3, anyNaix);
				}
				ps.setString(4, anyPubli);
				ps.setString(5, edit);
				ps.setString(6, numPag);
				
				ps.executeUpdate();
							
			}
			//Primer consulta que torna titol,autor,any de publicació dels autors nascuts abans de 1950
			ResultSet rs = stmt.executeQuery("SELECT Titol,Autor,Any_Publicacio FROM biblioteca WHERE Any_Naixement<1950");
			
			System.out.println("=========PRIMERA CONSULTA========");
				while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			rs.close();

			//Segona consulta que mostra la editorial de aquells llibres que se han publicat durant el S XXI
			ResultSet rs2 = stmt.executeQuery("SELECT Editorial FROM biblioteca WHERE Any_Publicacio>2000");
			
			System.out.println("========SEGONA CONSULTA======");
			while(rs2.next()) {	
				System.out.println(rs2.getString(1));
				}
			
			rs2.close();
			ps.close();
			stmt.close();
			con.close();
			llegir.close();	
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
		
	}

}
