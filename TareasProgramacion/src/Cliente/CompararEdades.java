package Cliente;

import java.util.Comparator;



public class CompararEdades implements Comparator {

   @Override
   public int compare(Object persona1, Object persona2) {
      return ((Cliente) persona1).edad - ((Cliente) persona2).edad;
   }
}
