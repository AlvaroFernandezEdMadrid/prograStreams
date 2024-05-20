package streamsComienzo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import Libreria.Libreria;

public class MiPrimerStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = rellenarLista();
		Function<Alumno,String> obtenerNombre;
		obtenerNombre = new Function<Alumno,String> ()
				{

					@Override
					public String apply(Alumno t) {
						// TODO Auto-generated method stub
						return t.getNombre();
					}
			
				};
		
		
		// Creación
		Stream<Alumno> alumnosStream = alumnos.stream();
		
		
		// Transformación y consumir
		/*
		rellenarLista().stream().// creación
				filter(a -> a.getNota()>=5).
				filter (a -> a.getFechaNacimiento().isBefore(LocalDate.now().minusYears(18))).
				sorted (Comparator.comparing(Alumno::getFechaNacimiento)).
				map(Alumno::getNombre).
				forEach(System.out::println); // consumiendo
		*/
	
		List<String> nombres = rellenarLista().stream().// creación
				filter(a -> a.getNota()>=5).
				filter (a -> a.getFechaNacimiento().isBefore(LocalDate.now().minusYears(18))).
				sorted (Comparator.comparing(Alumno::getFechaNacimiento)).
				map(Alumno::getNombre).
				toList(); // consumiendo
		/*
		boolean haySuspensos = rellenarLista().stream().
					peek(System.out::println).
					map(Alumno::getNota).
					peek(System.out::println).
					anyMatch(n -> n < 5);
		System.out.println(haySuspensos);
		*/
		boolean todosAprobados = rellenarLista().stream().
					map(Alumno::getNota).
					noneMatch(n -> n >= 5);
/*		
		System.out.println(
		rellenarLista().stream().
			map(Alumno::getNota).
			filter(n -> n>= 5).
			count()
				);
*/
/*
		System.out.println(
		rellenarLista().stream().
			map(Alumno::getNota).
			reduce(0, (n1,n2)-> n1+ n2)
		);
*/
		/*
		rellenarLista().stream().
			map(Alumno::getNota).
			max(Integer::compareTo).
			//findFirst().
			ifPresentOrElse(System.out::println, ()->System.out.println("no hay datos"));
		
		*/
		
		List<Alumno> alumnos1 = rellenarLista(); 
		
		Stream.generate(() -> Libreria.generarAleatorio(1, 100)).
				filter(n -> n % 2 == 0).
				distinct().
				limit(10).
				forEach(System.out::println);
		
		Stream.iterate(0, i -> i + 1).
			map (i -> alumnos1.get(i)).
			limit(10).
			forEach(System.out::println);
			
		
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
