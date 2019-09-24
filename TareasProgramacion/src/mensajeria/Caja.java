package mensajeria;

import transporte.Unidades;

public class Caja {

	private int ancho;
	private int alto;
	private int fondo;
	private Unidades u;
	private double volume;
	
	public Caja(int ancho, int alto, int fondo, Unidades u) {
		this.ancho = ancho;
		this.alto = alto;
		this.fondo = fondo;
		this.u = u;
	}
	
	public double getVolume(int ancho,int alto,int fondo){
		
		volume= (ancho*alto*fondo);
		
		return volume;
		
	}

	@Override
	public String toString() {
		return "Caja [ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo + ", u=" + u + "]";
	}

	
	
	
}
