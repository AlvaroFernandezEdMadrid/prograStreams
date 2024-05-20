import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import daw.com.Teclado;

public class ListaAlumno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable accion;
		Consumer<Object> escribir = System.out::println;
		accion = () -> System.out.println("el alumno no existe");
		List<Alumno> alumnos = new ArrayList<>();
		Alumno al;
		
		rellenarLista (alumnos);
		
		// leer dni alumno y mostrar su nota
		/*
		buscarPorDni (alumnos,Teclado.leerString("dni")).
			map(Alumno::getNota).
			ifPresentOrElse(escribir, accion);
		*/
		
		String dni = Teclado.leerString("dni");
		alumnos.stream().
			peek(escribir).
			filter(a -> a.getDni().equals(dni)).
			findFirst().
			map(Alumno::getNota).
			ifPresentOrElse(escribir, accion);
	}

	private static void rellenarLista(List<Alumno> alumnos) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 3; i++)
		{
			alumnos.add(new Alumno ("000"+i,"a" +i ,LocalDate.now().minusYears(20 -i),5+i));
		}
		
	}
	
	static Optional<Alumno> buscarPorDni (List<Alumno> alumnos, String dni)
	{
		Optional<Alumno> a = Optional.empty();
		
		for (int i = 0; i < alumnos.size() && a.isEmpty() ; i++)
			if (alumnos.get(i).getDni().equals(dni))
				a = Optional.of(alumnos.get(i));
		
		return a;
	}
	
	

}
