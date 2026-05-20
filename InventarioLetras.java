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

    
            




  


            





      









      

        
