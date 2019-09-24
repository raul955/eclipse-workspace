package Cliente;

import java.util.Comparator;

public class CompararNombres implements Comparator {
   @Override
   public int compare(Object persona1, Object persona2) {
      return ((Cliente) persona1).nombre.compareTo(((Cliente) persona2).nombre);
   }
}
