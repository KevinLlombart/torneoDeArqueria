package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Arquero {

	private String nombre;
	private Integer numero;
	private Set<Disparo> disparos;

	public Arquero(String nombre, Integer numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.disparos = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void realizarDisparo(Double coordenadaX, Double coordenadaY) {
		disparos.add(new Disparo(coordenadaX, coordenadaY));
	}

	public Set<Disparo> getDisparos() {
		return disparos;
	}

	public void setDisparos(Set<Disparo> disparos) {
		this.disparos = disparos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Arquero other = (Arquero) obj;
		return Objects.equals(numero, other.numero);
	}

}
