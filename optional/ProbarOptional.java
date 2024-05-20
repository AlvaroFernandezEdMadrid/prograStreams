import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;

public class ProbarOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<Alumno> alumno1,alumno2;
		Runnable accion;
		Consumer<Object> escribir = System.out::println;
		accion = () -> System.out.println("sin datos");
		
		Alumno a;
		Optional<String> nombre;
		
		
		alumno1 = Optional.empty(); // sin datos
		alumno2 = Optional.of(new Alumno ("002", "a2", LocalDate.now().minusYears(20),6));
		
		
	
		
		/*
		// Pensar más todavía
		
		alumno2.ifPresentOrElse(System.out::println, accion);
		
		a = alumno2.orElse(new Alumno());
		
		
		nombre = alumno1.map(Alumno::getNombre);
		
		nombre.ifPresentOrElse(System.out::println, accion);
		
		
		alumno1.map(Alumno::getNombre).
				ifPresentOrElse(escribir, accion);
		*/
		alumno2.
			filter( al -> al.getNota() >= 9).
			map(Alumno::getNombre).
			ifPresentOrElse(escribir, accion);
		
		
	}
	
	

}
