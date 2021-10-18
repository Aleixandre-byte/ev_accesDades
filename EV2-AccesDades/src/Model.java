import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Model {

	private String fichero_lectura;
	private String fichero_escritura;
	
	public Model() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "AE02_T1_2_Streams_Groucho2.txt";
	}
	public ArrayList<String> contenidoFichero(String fichero){
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fichero);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return contenidoFichero;
	}
	public String ficheroEscritura() {
		return fichero_escritura;
	}
	public String ficheroLectura() {
		return fichero_lectura;
	}
	
	public void anyadirTexto(String textoAnyadir) {
		File f1 = new File(ficheroLectura());
		File f2 = new File(ficheroEscritura());
		
		 try {
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine();
			while(linea != null){
				bw.write(linea);
				bw.newLine();
				linea = br.readLine();
			}
			bw.write(textoAnyadir);
			/*fr.close();
			br.close();
			fw.close();*/
			bw.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//métode que busca en el fitxer paraula per paraula, l'element pasat per paràmetre y conta quantes vegades apareix al text
	
	public int buscarParaula(String paraula) {
		File f1 = new File(ficheroLectura());
		int cont=0;
		String p="";
		
		try {
			Scanner lector = new Scanner(f1);	//Scanner per a llegir el text paraula a paraula
			lector.useDelimiter(" +");
			while(lector.hasNext()==true) {
				p = lector.next();				//variable per a almacenar la ultima paraula llegida
				if(paraula.equals(p)) {
					cont++;
				}
			}
			lector.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		return cont;
	}
	
	
	public void reemplacarParaula(String paraulaOriginal,String paraulaNova) {
		File f1 = new File(ficheroLectura());
		File f2 = new File(ficheroEscritura());
		
		try {
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(f2);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linea = br.readLine();
			String lineaSustituta;
			
			while(linea!=null) {
				lineaSustituta = linea.replace(paraulaOriginal, paraulaNova);
				bw.write(lineaSustituta);
				bw.newLine();
				linea = br.readLine();	
			}
			//fr.close();
			//br.close();
			//fw.close();
			bw.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	
	
	
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
*/
}



