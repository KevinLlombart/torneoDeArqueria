package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Torneo {

	private String nombre;
	private Set<Arquero> participantes;

	public Torneo(String nombre) {
		super();
		this.nombre = nombre;
		this.participantes = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarParticipante(Arquero arquero) {
		participantes.add(arquero);
	}

	public Arquero getArquero(Integer numero) {
		for (Arquero arquero : participantes) {
			if (arquero.getNumero().equals(numero)) {
				return arquero;
			}
		}
		return null;
	}

	public Integer getPuntajeTotal(Integer numero) {
		Integer puntajeTotal = 0;
		for (Arquero arquero : participantes) {
			for (Disparo disparo : arquero.getDisparos()) {
				if (arquero.getNumero().equals(numero)) {
					puntajeTotal += disparo.getPuntaje();
				}
			}
		}
		return puntajeTotal;
	}

	public Boolean estaDescalificado(Integer numero) throws ArqueroDescalificadoException {
		Arquero arqueroEncontrado = getArquero(numero);
		if (getPuntajeTotal(arqueroEncontrado.getNumero()) != 0) {
			return false;
		} else {
			throw new ArqueroDescalificadoException();
		}
	}

	public Map<Arquero, Integer> obtenerPuntajePorParticipante() throws ArqueroDescalificadoException {
		Map<Arquero, Integer> puntajePorParticipante = new HashMap<>();

		for (Arquero arquero : participantes) {
			if (!estaDescalificado(arquero.getNumero())) {
				puntajePorParticipante.put(arquero, getPuntajeTotal(arquero.getNumero()));
			}
		}
		return puntajePorParticipante;
	}

	public TreeSet<Disparo> ordenarDisparosEnFormaDescendente() {

		TreeSet<Disparo> disparosOrdenados = new TreeSet<>(new ordenadorDeDisparosPorPuntajeDesc());

		for (Arquero arquero : participantes) {
			for (Disparo disparo : arquero.getDisparos()) {
				if (disparosOrdenados.size() <= 5) {
					disparosOrdenados.add(disparo);
				}
			}
		}
		return disparosOrdenados;
	}
	
	public Boolean ExisteArquero(Integer numero) {
		
		if (getArquero(numero) != null) {
			return true;
		}
		return null;
	}

	public List<Arquero> ordenarArquerosEnFormaDescendente() {

		List<Arquero> arquerosOrdenados = new ArrayList<>(participantes);
		
		if (arquerosOrdenados.size() <= 3) {
			arquerosOrdenados.sort((Arquero1, Arquero2) -> getPuntajeTotal(Arquero2.getNumero()).compareTo(getPuntajeTotal(Arquero1.getNumero())));
		}
		return arquerosOrdenados;
	}
	
	public Integer getCantidadDePaticipantes() {
		return participantes.size();
	}

}
