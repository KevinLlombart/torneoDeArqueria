package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenadorDeDisparosPorPuntajeDesc implements Comparator<Disparo>{

	@Override
	public int compare(Disparo o1, Disparo o2) {
		// TODO Auto-generated method stub
		return o2.getPuntaje().compareTo(o1.getPuntaje());
	}

}
