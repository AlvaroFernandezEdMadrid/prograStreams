package streamsComienzo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Libreria.Libreria;

public class PrimerStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos=rellenarLista();
		
		//Creacion
		Stream<Alumno> alumnoStream =alumnos.stream();
		
		//Transformacion
		
		alumnoStream.
					filter(a->a.getNota()>=5).
					map(Alumno::getNombre).
					sorted((n1,n2)->n1.compareTo(n2)).
					forEach(System.out::println); 		//Consumir
					
	}

	public static List<Alumno> rellenarLista() {
		List<Alumno> alumnos=new ArrayList<Alumno>();
		
		for (int i = 0; i < 10; i++) {
			alumnos.add(new Alumno(("001"+i),("A"+i),LocalDate.now().minusYears(30),Libreria.generarAleatorio(1, 10)));
		}
		
		return alumnos;
	}
}
