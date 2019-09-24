package Cliente;

import java.util.Arrays;

public class Main {

   public static void main(String[] args) {
      Cliente[] clientes = new Cliente[5];
      clientes[0] = new Cliente("12345678a", "raul", 23, 9999999);
      clientes[1] = new Cliente("21345678b", "pedro", 18, 1);
      clientes[2] = new Cliente("37895346c", "fernando", 21, 1);
      clientes[3] = new Cliente("48416285d", "canina", 25, -10000);
      clientes[4] = new Cliente("57845123e", "abraham", 25, 1);

      
      Arrays.sort(clientes);
      System.out.println("Por dni: " + Arrays.toString(clientes));

      
      Arrays.sort(clientes, new CompararNombres());
      System.out.println("Por nombres: " + Arrays.toString(clientes));

      
      Arrays.sort(clientes, new CompararEdades());
      System.out.println("Por edades: " + Arrays.toString(clientes));
   }
}

