import java.io.File;

import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;

public class EV1 {
	
	//el ejericio funciona pero me da un error relacionado con Scanner que no se resolver
	
	static void getInformacion() {
		String dir = "C:\\Users\\dam1\\eclipse-workspace";
		File fichero = new File(dir);
		System.out.println(fichero.getName());//1
		if(fichero.isFile()) {
			System.out.println("Es un arxiu.");//2
			System.out.println(fichero.length());
		}
		else {
			System.out.println("Es un directori");//2
			System.out.println("Número d'arxius en carpeta: "+fichero.list().length);
			System.out.println("Espai lliure: "+fichero.getUsableSpace());
			System.out.println("Espai disponible: "+fichero.getFreeSpace());
			System.out.println("Espai total: "+fichero.getTotalSpace());
		}
		System.out.println(fichero.getPath());//3
		Date d = new Date(fichero.lastModified());
		System.out.println(d);//4
		System.out.println(fichero.isHidden());//5
		
	}
	static void creaCarpeta() {
		String ruta = "C:\\Users\\dam1\\eclipse-workspace";
		try {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Nom de la carpeta: ");
			String nombre = teclado.next();
			teclado.close();
			ruta += "/" + nombre;
			new File(ruta).mkdirs();
			
		} catch (Exception error) {
			System.out.println("S'ha donat un error.");
		    error.printStackTrace();
		}
		
	}
	
	static void creaFitxer() {
		String ruta = "C:\\Users\\dam1\\eclipse-workspace";
		 try {
			 Scanner teclado = new Scanner(System.in);
			 System.out.println("Nom del fitxer: ");
			 String nom = teclado.next();
			 ruta += "/"+nom;
		      File arx = new File(ruta);
		      teclado.close();
		      if (arx.createNewFile()) {
		        System.out.println("Arxiu creat: " + arx.getName());
		      } else {
		        System.out.println("Arxiu ja existent.");
		      }
		    } catch (IOException error) {
		      System.out.println("S'ha donat un error.");
		      error.printStackTrace();
	}
		 
	}
	static void elimina() {
		String ruta = "C:\\Users\\dam1\\eclipse-workspace";
		 Scanner teclado = new Scanner(System.in);
		 System.out.println("Nom del arxiu o carpeta.");
		 String nom = teclado.next();
		 String rutaComp = ruta+"/"+nom;
			 File arx = new File(rutaComp);
			 if (arx.delete()) {
				 System.out.println("El fitxer/carpeta " + rutaComp + " S'HA borrat sense cap problema");
			 }else {
				 System.out.println("El fitxer/carpeta " + rutaComp + " NO s'ha pogut borrar");
				}
			 teclado.close();
				
		 }
		 
	public static void renomena() {
		String ruta = "C:\\Users\\dam1\\eclipse-workspace";
		 Scanner teclado = new Scanner(System.in);
		 System.out.println("Nom del arxiu/carpeta:");
		 String nom = teclado.next();
		 System.out.println("Nou nom del arxiu/carpeta:");
		 String newNom = teclado.next();
		 String rutaComp = ruta+"/"+nom;
			 File arx = new File(rutaComp);
			 File newArx = new File(ruta+"/"+newNom);
			 if (arx.renameTo(newArx)) {
				 System.out.println("El fitxer/carpeta " + rutaComp + " S'HA canviat el nom sense cap problema");
			 }else {
				 System.out.println("El fitxer/carpeta " + rutaComp + " NO s'ha pogut canviar el nom");
				}
			 teclado.close();
				
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorio = args[0];
		Scanner teclado = new Scanner(System.in);
		System.out.println("1.Informació d'un fitxer: ");
		System.out.println("2.Crear carpeta: ");
		System.out.println("3.Crear fitxer: ");
		System.out.println("4.Eliminar un fitxer: ");
		System.out.println("5.Renomenar un fitxer: ");
		System.out.println("6.Eixida ");
		int opcio = 0;
	
		while(opcio != 6) {
		System.out.println("Tria una opció: ");
		opcio = teclado.nextInt();				
		switch (opcio) {
		case 1:
			getInformacion();
			break;
		case 2:
			creaCarpeta();
			break;
		case 3:
			creaFitxer();
			break;
		case 4:
			elimina();
			break;
		case 5:
			renomena();
			break;
		case 6:
			System.out.print("Eixint del programa");
			break;
		default:
			System.out.println("Ninguna opció seleccionada: ");
			break;
		}
		
		}
		
		//getInformacion(directorio);
		//creaCarpeta(directorio);
		//creaFitxer(directorio);
		//elimina(directorio);
		//renomena(directorio);
		teclado.close();
		
	}

}
