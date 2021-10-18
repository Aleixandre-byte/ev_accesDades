public class Principal {

	public static void main(String[] args) {
		
		Vistas vista = new Vistas();
		Model modelo = new Model();
		Controlador controlador = new Controlador(modelo,vista);

		
	}

}
