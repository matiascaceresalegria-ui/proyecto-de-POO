public class InventarioLetras {

    public static void main(String[] args) {
      
        InventarioLetras inventario = new InventarioLetras("Hola Mundo");

        System.out.println(inventario);

        System.out.println(inventario.size());

        System.out.println(inventario.get('o'));

        System.out.println(inventario.encriptarCesar('a'));

        System.out.println(inventario.encriptarPalabra("play", 3));

        InventarioLetras otro = new InventarioLetras("abc");

        System.out.println(inventario.add(otro));

        System.out.println(inventario.amplifies(2));

        System.out.println(inventario.subtract(otro));
    }

    private int[] contador;
    private int cantidadTotal;
    private int letrasDistintas;

    public InventarioLetras(String texto) {

        contador = new int[26];
        cantidadTotal = 0;
        letrasDistintas = 0;

        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
          
            char letraActual = texto.charAt(i);

            if (Character.isLetter(letraActual) && letraActual >= 'a' && letraActual <= 'z') {

               int posicion = letraActual - 'a';

               if(contador[posicion] == 0) {
                  letrasDistintas++;
               }

               contador[posicion]++;
               cantidadTotal++;
            }
        }
  }

  public int size() {
      return cantidadTotal;
  }

  public boolean isEmpty() {
      return letrasDistintas == 0;
  }

  public int get(char letra) {

      letra = Character.toLowerCase(letra);

      if (!Character.isLetter(letra) || letra < 'a' || letra > 'z') {
          throw new IllegalArgumentException();
      }

      return contador[letra - 'a'];
  }

  public void set(char letra, int valor) {

      letra = Character.toLowerCase(letra);

      if (!Character.isLetter(letra) || letra < 'a' || letra 'z' || valor < 0) {
          throw new IllegalArgumentException();
      }

      int posicion = letra - 'a';

      cantidadTotal -= contador[posicion];

      if (contador[posicion] > 0) {
          letrasDistintas--;
      }

      contador[posicion] = valor;

      cantidadTotal += valor;

      if (valor > 0) {
          letrasDistintas++;
      }
  }

  public String toString() {

      String texto = "[";

      for (int i = 0; i < contador.length; i++)

          int repeticiones = contador[i];

          while (repeticiones > 0) {

              texto += (char) (i + 'a');
              repeticiones--;
          }
      }

      texto += "]";

      return texto;
}

            





      









      

        
