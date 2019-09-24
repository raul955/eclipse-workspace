package mensajeria;

import transporte.Unidades;

public class CajaCarton extends Caja{

	private int volumen;
	private int superficie;
	EtiquetaNumero et;
	
	
	
	public CajaCarton(int ancho, int alto, int fondo, Unidades u, EtiquetaNumero et) {
		super(ancho, alto, fondo, u);
		this.et = et;
	}

	public int trincarVolumen(int ancho,int alto,int fondo){
		
		volumen = (int)((ancho*alto*fondo)*0.8);
		
		return volumen;
		
	}

	public int trincarSuperficie(int ancho, int alto,int fondo){
		
		superficie = (ancho*alto*2)+(fondo*alto*2)+(ancho*fondo*2);
		
		return superficie;
	}
	
}
