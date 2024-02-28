package ar.edu.unlam.pb2;

import java.util.Objects;

public class Disparo {

	private Double coodernadaX;
	private Double coordenadaY;
	private Double distancia = 0.0;
	private Integer numero = 0;
	private Integer puntaje = 0;

	public Disparo(Double coodernadaX, Double coordenadaY) {
		super();
		this.coodernadaX = coodernadaX;
		this.coordenadaY = coordenadaY;
		this.distancia = getDistancia();
		this.puntaje = getPuntaje();
		this.numero++;
	}

	public Double getCoodernadaX() {
		return coodernadaX;
	}

	public void setCoodernadaX(Double coodernadaX) {
		this.coodernadaX = coodernadaX;
	}

	public Double getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public Double getDistancia() {
		Double distancia = 0.0;
		Double distanciaX = coodernadaX * coodernadaX;
		Double distanciaY = coordenadaY * coordenadaY;
		distancia = Math.sqrt(distanciaX + distanciaY);

		return distancia;
	}

	public Integer getPuntaje() {
		if (distancia <= 10) {
			puntaje += 1000;
		}
		if (distancia > 10 && distancia <= 20) {
			puntaje += 500;
		}
		if (distancia > 20 && distancia <= 30) {
			puntaje += 200;
		}
		if (distancia > 30 && distancia <= 40) {
			puntaje += 100;
		}
		if (distancia > 40 && distancia <= 50) {
			puntaje += 50;
		}
		if (distancia > 50) {
			puntaje += 0;
		}
		return puntaje;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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
		Disparo other = (Disparo) obj;
		return Objects.equals(numero, other.numero);
	}

}
