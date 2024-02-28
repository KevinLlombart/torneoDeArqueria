package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import ar.edu.unlam.pb2.Arquero;
import ar.edu.unlam.pb2.ArqueroDescalificadoException;
import ar.edu.unlam.pb2.Torneo;

public class TorneoTest {

	@Test
	public void QueSePuedaAgregarParticipantes() {
		Torneo torneo = new Torneo("k");
		Arquero arquero = new Arquero("kevin", 1);
		
		torneo.agregarParticipante(arquero);
		
		assertEquals((Integer)1, torneo.getCantidadDePaticipantes());
	}
	
	@Test
	public void QueSePuedaUnParticipantePuedaDisparar() {
		Torneo torneo = new Torneo("k");
		Arquero arquero = new Arquero("kevin", 1);
		
		torneo.agregarParticipante(arquero);
		arquero.realizarDisparo(10.0, 10.0);
		arquero.realizarDisparo(10.0, 10.0);
		
		assertEquals(1000, torneo.getPuntajeTotal(1),0.01);
	}
	
	@Test(expected = ArqueroDescalificadoException.class)
	public void QueSePuedaUnParticipanteQuedeDescalificado() throws ArqueroDescalificadoException {
		Torneo torneo = new Torneo("k");
		Arquero arquero = new Arquero("kevin", 1);
		
		torneo.agregarParticipante(arquero);
		arquero.realizarDisparo(80.0, 80.0);
		arquero.realizarDisparo(80.0, 80.0);
		arquero.realizarDisparo(80.0, 80.0);
		arquero.realizarDisparo(80.0, 80.0);
		arquero.realizarDisparo(80.0, 80.0);
		torneo.estaDescalificado(1);
	}
	
	@Test
	public void QueSePuedaTenerLosPrimerosTresMejoresPartcipantes() {
		Torneo torneo = new Torneo("k");
		Arquero arquero1 = new Arquero("kevin", 1);
		Arquero arquero2 = new Arquero("kevin", 2);
		Arquero arquero3 = new Arquero("kevin", 3);
		Arquero arquero4 = new Arquero("kevin", 4);
		
		torneo.agregarParticipante(arquero1);
		torneo.agregarParticipante(arquero2);
		torneo.agregarParticipante(arquero3);
		torneo.agregarParticipante(arquero4);
		arquero1.realizarDisparo(1.0, 1.0);
		arquero2.realizarDisparo(10.0, 10.0);
		arquero3.realizarDisparo(15.0, 15.0);
		arquero4.realizarDisparo(20.0, 20.0);
		
		List<Arquero> arquerosOrdenados = torneo.ordenarArquerosEnFormaDescendente();
		
		assertEquals(arquero1, arquerosOrdenados.get(0));
		assertEquals(arquero2, arquerosOrdenados.get(1));
		assertEquals(arquero3, arquerosOrdenados.get(2));
		assertEquals(arquero4, arquerosOrdenados.get(3));
	}
	
	@Test
	public void QueSePuedaTenerPuntajesPorParticipantes() throws ArqueroDescalificadoException {
		Torneo torneo = new Torneo("k");
		Arquero arquero1 = new Arquero("kevin", 1);
		Arquero arquero2 = new Arquero("kevin", 2);
		Arquero arquero3 = new Arquero("kevin", 3);
		Arquero arquero4 = new Arquero("kevin", 4);
		
		torneo.agregarParticipante(arquero1);
		torneo.agregarParticipante(arquero2);
		torneo.agregarParticipante(arquero3);
		torneo.agregarParticipante(arquero4);
		arquero1.realizarDisparo(1.0, 1.0);
		arquero2.realizarDisparo(10.0, 10.0);
		arquero3.realizarDisparo(15.0, 15.0);
		arquero4.realizarDisparo(20.0, 20.0);
		
		Map<Arquero, Integer> puntajePorParticipante = torneo.obtenerPuntajePorParticipante();
		
		System.out.println(puntajePorParticipante);
	}

}
