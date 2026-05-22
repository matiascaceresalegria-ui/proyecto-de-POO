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

    private int[] contador; // Arreglo para guardar cuantas veces se repite cada letra (desde la 'a' a la 'z')
    private int cantidadTotal; // Guarda el total de todas las letras que tiene el inventario 
    private int letrasDistintas; // Guarda cuantas letras diferentes sin repetir se encontraron

    public InventarioLetras(String texto) {

        contador = new int[26];
        cantidadTotal = 0;
        letrasDistintas = 0;

        texto = texto.toLowerCase(); // Pasamos todo a minuscula para que no importen las mayusculas

        for (int i = 0; i < texto.length(); i++) {
          
            char letraActual = texto.charAt(i);

            if (Character.isLetter(letraActual) && letraActual >= 'a' && letraActual <= 'z') { // Revisamos que sea una letra valida del alfabeto

               int posicion = letraActual - 'a'; // Calculamos la posicion en el arreglo (a=0, b=1, c=2 y asi)

               if(contador[posicion] == 0) {
                  letrasDistintas++; // Si el conteo estaba 0, significa que encontramos una letra nueva
               }

               contador[posicion]++; // Sumamos 1 al casillero de esa letra 
               cantidadTotal++; // Sumamos 1 al conteo total general 
            }
        }
    }

    public int size() {
        return cantidadTotal; // Devuelve la suma de todas las letras guardadas
    }

    public boolean isEmpty() {
        return letrasDistintas == 0; // Si no hay letras distintas, el inventario esta vacio
    }

    public int get(char letra) {

        letra = Character.toLowerCase(letra);

        if (!Character.isLetter(letra) || letra < 'a' || letra > 'z') {
          throw new IllegalArgumentException(); // Si nos pasan algo que no es una letra, lanza error
        }

        return contador[letra - 'a']; // Devuelve cuantas veces esta esa letra en el arreglo
    }

    public void set(char letra, int valor) {

        letra = Character.toLowerCase(letra);

        if (!Character.isLetter(letra) || letra < 'a' || letra > 'z' || valor < 0) {
            throw new IllegalArgumentException(); // Validamos que sea una letra correcta y que el numero no sea negativo
        }

        int posicion = letra - 'a';

        cantidadTotal -= contador[posicion]; // Le restamos al total la cantidad vieja que tenia esa letra

        if (contador[posicion] > 0) {
            letrasDistintas--; // Si la letra ya existia, la restamos temporalmente de las distintas
        }

        contador[posicion] = valor; // Guardamos el nuevo valor en su casillero

        cantidadTotal += valor; // Le sumamos el nuevo valor al total general

        if (valor > 0) { 
            letrasDistintas++; // Si el valor es mayor a 0, la volvemos a contar como letra distinta 
        }
    }

    public String toString() {

        String texto = "[";

        for (int i = 0; i < contador.length; i++) {

            int repeticiones = contador[i];

            while (repeticiones > 0) {

                texto += (char) (i + 'a'); // Convertimos la posicion de vuelta a un caracter y lo agregamos al texto 
                repeticiones--;
            }
        }

        texto += "]";

        return texto; // Devuelve el texto final ordenado
    }

    public char encriptarCesar(char letra) {

        letra = Character.toLowerCase(letra); 

        if (letra < 'a' || letra > 'z') {
            return letra; // Si no es una letra del abecedario, la dejamos tal cual sin cambiarla
        }

        int posicion = letra - 'a'; 
        posicion = (posicion + 3) % 26; // Movemos la letra 3 posiciones hacia adelante en el alfabeto 

        return (char) (posicion + 'a'); 
    }

    public char desencriptarCesar(char letra) {

        letra = Character.toLowerCase(letra); 

        if (letra < 'a' || letra > 'z') {
            return letra; // Si no es una letra valida, no le hacemos nada 
        }

        int posicion = letra - 'a'); 
        posicion = (posicion - 3 + 26) % 26; // Movemos la letra 3 posiciones atras de forma segura

        return (char) (posicion + 'a');
    }

    public String encriptarPalabra(String palabra, int desplazamiento) {

        String palabraNueva = "";

        for (int i = 0; i < palabra.length(); i++) {

            palabraNueva += encriptarCesar(palabra.charAt(i)); // Va encriptando cada letra de la palabra una por una
        }

        return palabraNueva;
    }

    public String desencriptarPalabra(String palabra, int desplazamiento) {

        String palabraNueva = "";

        for (int i = 0; i < palabra.length(); i++) {

            palabraNueva += desencriptarCesar(palabra.charAt(i)); // Va desencriptando cada letra de la palabra una por una
        }

        return palabraNueva;
    }

    public InventarioLetras add(InventarioLetras otro) {

        InventarioLetras resultado = new InventarioLetras("");

        for (int i = 0; i < contador.length; i++) {

            int suma = contador[i] + otro.contador[i]; // Sumamos los conteos de este inventario con los del otro

            resultado.contador[i] = suma;
            resultado.cantidadTotal += suma;

            if (suma > 0) {
                resultado.letrasDistintas++;
            }
        }

        return resultado; // Devolvemos el nuevo inventario generado sin alterar los actuales
    }
  
    public InventarioLetras amplifies(int n) {

        InventarioLetras resultado = new InventarioLetras ("");

        for (int i = 0; i < contador.length; i++) {

            int multi = contador[i] * n; // Multiplicamos el conteo de cada letra por el numero n

            resultado.contador[i] = multi;
            resultado.cantidadTotal += multi;

            if (multi > 0) { 
                resultado.letrasDistintas++;
            }
        } 
 
        return resultado; // Devolvemos el nuevo inventario multiplicado
    }

    public InventarioLetras subtract(InventarioLetras otro) {

        InventarioLetras Resultados = new InventarioLetras("");

        for (int i = 0; i < contador.length; i++) {

            int resta = contador[i] - otro.contador[i]; // Restamos los conteos del otro inventario a este 

            if (resta < 0) {
                return null; // Si da un numero negativo, significa que no se puede restar y devuelve null
            }

            resultado.contador[i] = resta;
            resultado.cantidadTotal += resta;

            if (resta > 0) {
                resultado.letrasDistintas++;
            }
        }

        return resultado; // Devolvemos el nuevo inventario con la resta hecha
    }
}
        
    
            




  


            





      









      

        
