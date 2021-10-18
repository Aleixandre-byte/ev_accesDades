import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador {
	
	private Model modelo;
	private Vistas vista;
	private ActionListener actionListenerReemplazar;
	private ActionListener actionListenerBuscar;
	private String ficheroLectura,ficheroEscritura;
	
	public Controlador(Model modelo,Vistas vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
	}

	public void control() {
		
		
		ficheroLectura = modelo.ficheroLectura();
		ficheroEscritura = modelo.ficheroEscritura();
		mostrarFichero(ficheroLectura,1);
		
		//ActionListener executat al apretar el boto de reemplaçar
		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String textAnyadir = vista.getTextFieldReemplazar().getText();
				String textCanviar = vista.getTextFieldBuscar().getText();
				modelo.reemplacarParaula(textCanviar, textAnyadir);
				mostrarFichero(ficheroEscritura,2);
			}
		};
		
		
		//ActionListener executat al apretar el boto de buscar
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				int num = modelo.buscarParaula(vista.getTextFieldBuscar().getText());		//variable per a almacenar el contador de paraules del text
				JOptionPane.showMessageDialog(null,num, "Informació: "+"Contador",JOptionPane.INFORMATION_MESSAGE);
				
			}
		};
		
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	}
	
	
	private void mostrarFichero(String fichero,int numeroTextArea) {
		ArrayList<String> arrayLineas = modelo.contenidoFichero(fichero);
		for (String linea : arrayLineas) {
			if(numeroTextArea == 1) {
				vista.getTextAreaOriginal().append(linea+"\n");
			}else {
				vista.getTextAreaModificado().append(linea+"\n");
			}
		}
	}
	
	
	
	
		public static void main(String[] args) {

	}

}