package streamsComienzo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Libreria.Libreria;

public class AppCollectors {

	public static void main(String[] args) {
		rellenarLista().stream().collect(Collectors.toSet());
		
		rellenarLista().stream().collect(Collectors.toMap(Alumno::getDni, a->a));
		
		

	}

	private static List<Alumno> rellenarLista() {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		
		for (int i = 0; i < 10; i++)
		{
			alumnos.add(new Alumno ("000"+i,"a" +i ,LocalDate.now().minusYears(40 -i),Libreria.generarAleatorio(1, 10)));
		}
		return alumnos;
		
	}
}
