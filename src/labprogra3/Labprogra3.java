package labprogra3;

import java.util.Scanner;

/**
 *
 * @author elkin
 */
public class Labprogra3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        while (true) {
            System.out.println("----------MENU----------\n");
            System.out.println("1.Cifrado");
            System.out.println("2.Filtrar");
            System.out.println("3.Codigo enigma");
            System.out.print("Ingrese opcion:");
            int opcion = lea.nextInt();
            lea.nextLine();

            switch (opcion) {
                
                case 3 -> {
                    boolean salir = false;

                    while (!salir) {
                        System.out.println("-----OPCIONES------");
                        System.out.println("1. Encriptar texto");
                        System.out.println("2. Desencriptar texto");
                        System.out.println("3. Regresar");
                        System.out.print("Ingrese opcion: ");
                        opcion = lea.nextInt();
                        lea.nextLine();

                        switch (opcion) {
                            case 1 -> {
                                System.out.print("Ingrese texto: ");
                                String texto = lea.nextLine();
                                String parte1 = "";
                                String parte2 = "";

                                int contador = 0;
                                while (contador < texto.length()) {
                                    char letra = texto.charAt(contador);
                                    if (letra % 2 == 0) {
                                        parte1 = parte1 + letra;

                                    } else {
                                        parte2 = parte2 + letra;
                                    }
                                    contador++;
                                }

                                String resultado = parte2 + parte1;
                                System.out.println("Texto encriptado: " + resultado);
                            }
                            case 2 -> {
                                System.out.print("Ingrese texto encriptado: ");
                                String texto = lea.nextLine();
                                int mitad = texto.length() / 2;

                                String parte1 = texto.substring(0, mitad);
                                String parte2 = texto.substring(mitad);

                                String original = "";
                                int i = 0;
                                while (i < texto.length()) {
                                    if (i < parte1.length()) {
                                        original = original + parte2.charAt(i);
                                    }
                                    if (i < parte2.length()) {
                                        original = original + parte1.charAt(i);

                                    }
                                    i++;
                                }

                                System.out.println("Texto desencriptado: " + original);
                            }
                            case 3 -> {
                                salir = true;
                            }
                            default -> {
                                System.out.println("Opcion no valida.");
                            }

                        }
                    }

                }

                default -> {
                    System.out.println("Opcion no valida.");
                }
            }
        }
    }

}
