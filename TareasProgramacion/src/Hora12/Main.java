package Hora12;

public class Main {
	   static public void main(String args[]) {
	      Hora12 r = new Hora12 (11, 10, Hora12.Meridiano.AM);
	      System.out.println(r);
	      for (int i = 1; i <= 61; i++) {
	         r.inc();
	      }
	      System.out.println(r);
	      
	      r.setHora(20);
	      System.out.println(r);
	   }
	   
	}
