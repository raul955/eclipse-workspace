package Hora12;

public class Hora12 extends Hora {
	   public enum Meridiano { AM, PM} 
	   protected Meridiano mer; 

	   public Hora12(int hora, int minutos, Meridiano mer) {
	      super(hora, minutos); 
	      setHora(hora); 
	      this.mer = mer; 
	   }

	   @Override 
	   public void setHora(int hora) { 
	      if (0 <= hora && hora < 12) {
	         this.hora = hora;
	      }
	   }

	   @Override 
	   public void inc() {
	      super.inc(); 
	      
	      if (hora > 11) {
	         hora = 0; 
	         mer = mer == Meridiano.AM ? Meridiano.PM : Meridiano.AM; 
	      }
	   }

	   public String toString() {
	      String result; 
	      result = super.toString(); 
	      result += " " + mer; 
	      return result;
	   }
	}
