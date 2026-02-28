import java.util.Scanner;
import java.util.Random;

public class Laboratorio {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: calculadora(); break;
                case 2: validarContrasena(); break;
                case 3: numerosPrimos(); break;
                case 4: sumaNumerosPares(); break;
                case 5: conversionTemperatura(); break;
                case 6: contadorVocales(); break;
                case 7: calculoFactorial(); break;
                case 8: juegoAdivinanza(); break;
                case 9: pasoPorReferencia(); break;
                case 10: tablaMultiplicar(); break;
                case 0: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("Menu principal");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Número primo");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Paso por referencia");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("0. Salir");
    }

   

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingrese un número válido.");
            }
        }
    }

    

    public static void calculadora() {
        double numero1 = leerDouble("Ingrese primer digito: ");
        double numero2 = leerDouble("Ingrese segundo digito: ");

        System.out.println("1. Sumar2. Restar3. Multiplicar4. Dividir");
        int opcion = leerEntero("Elija operación: ");

        switch (opcion) {
            case 1: System.out.println("Resultado: " + sumar(numero1, numero2)); break;
            case 2: System.out.println("Resultado: " + restar(numero1, numero2)); break;
            case 3: System.out.println("Resultado: " + multiplicar(numero1, numero2)); break;
            case 4:
                if (numero2 != 0)
                    System.out.println("Resultado: " + dividir(numero1, numero2));
                else
                    System.out.println("No se puede dividir entre cero.");
                break;
            default: System.out.println("Operación inválida.");
        }
    }

    public static double sumar(double PrimerNumero, double SegundoNumero) { return PrimerNumero + SegundoNumero; }
    public static double restar(double PrimerNumero, double SegundoNumero) { return PrimerNumero - SegundoNumero; }
    public static double multiplicar(double PrimerNumero, double SegundoNumero) { return PrimerNumero * SegundoNumero; }
    public static double dividir(double PrimerNumero, double SegundoNumero) { return PrimerNumero / SegundoNumero; }

  
    public static void validarContrasena() {
        String contraseña;
        do {
            System.out.print("Ingrese contraseña: ");
            contraseña = scanner.nextLine();
        } while (!contraseña.equals("1234"));

        System.out.println("Acceso concedido.");
    }

    

    public static void numerosPrimos() {
        int numeroIngresado = leerEntero("Ingrese un número: ");
        if (esPrimo(numeroIngresado))
            System.out.println("Es primo.");
        else
            System.out.println("No es primo.");
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }

    

    public static void sumaNumerosPares() {
        int suma = 0;
        int numeroIngresado = leerEntero("Ingrese número (0 para salir): ");

        while (numeroIngresado != 0) {
            if (numeroIngresado % 2 == 0)
                suma += numero;
            numeroIngresado = leerEntero("Ingrese número (0 para salir): ");
        }

        System.out.println("Suma de pares: " + suma);
    }

    

    public static void conversionTemperatura() {
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        int opcion = leerEntero("Seleccione opción: ");

        double temp = leerDouble("Ingrese temperatura: ");

        if (opcion == 1)
            System.out.println("Resultado: " + celsiusAFahrenheit(temp));
        else if (opcion == 2)
            System.out.println("Resultado: " + fahrenheitACelsius(temp));
        else
            System.out.println("Opción inválida.");
    }

    public static double celsiusAFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitACelsius(double f) {
        return (f - 32) * 5 / 9;
    }



    public static void contadorVocales() {
        System.out.print("Ingrese texto: ");
        String texto = scanner.nextLine();
        System.out.println("Cantidad de vocales: " + contarVocales(texto));
    }

    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ("aeiou".indexOf(c) != -1)
                contador++;
        }
        return contador;
    }



    public static void calculoFactorial() {
        int factorial = leerEntero("Ingrese número: ");

        if (factorial < 0) {
            System.out.println("No se permite negativo.");
            return;
        }

        System.out.println("Factorial: " + factorial(factorial));
    }

    public static long factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++)
            resultado *= i;
        return resultado;
    }

   

    public static void juegoAdivinanza() {
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int intento;

        do {
            intento = leerEntero("Adivine el número (1-100): ");

            if (intento < numeroSecreto)
                System.out.println("Mayor...");
            else if (intento > numeroSecreto)
                System.out.println("Menor...");

        } while (intento != numeroSecreto);

        System.out.println("¡Correcto!");
    }

  
    static class Numero {
        int VALOR;
        Numero(int VALOR) { this.VALOR = VALOR; }
    }

    public static void pasoPorReferencia() {
        Numero NumeroReferencia1 = new Numero(5);
        Numero NumeroReferencia2 = new Numero(10);

        System.out.println("Antes: num1 = " + NumeroReferencia1.VALOR + ", num2 = " + NumeroReferencia2.VALOR);
        intercambiar(NumeroReferencia1, NumeroReferencia2);
        System.out.println("Después: num1 = " + NumeroReferencia1.VALOR + ", num2 = " + NumeroReferencia2.VALOR);
    }

    public static void intercambiar(Numero a, Numero b) {
        int temp = a.valor;
        a.valor = b.valor;
        b.valor = temp;
    }

  

    public static void tablaMultiplicar() {
        int tabla = leerEntero("Ingrese número: ");
        generarTabla(tabla);
    }

    public static void generarTabla(int tabla) {
        for (int i = 1; i <= 10; i++)
            System.out.println(tabla + " x " + i + " = " + (tabla * i));
    }
}