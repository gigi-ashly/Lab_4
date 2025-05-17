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
                case 1 -> {

                    System.out.print("Ingrese una frase: ");
                    String frase = lea.nextLine();

                    System.out.print("Ingrese el numero de desplazamiento: ");
                    int desplazamiento = lea.nextInt();

                    String resultado = "";

                    for (int i = 0; i < frase.length(); i++) {
                        char c = frase.charAt(i);

                        if (c >= 'A' && c <= 'Z') {
                            char nueva = (char) ((c - 'A' + desplazamiento) % 26 + 'A');
                            resultado += nueva;
                        } else if (c >= 'a' && c <= 'z') {
                            char nueva = (char) ((c - 'a' + desplazamiento) % 26 + 'a');
                            resultado += nueva;
                        } else {
                            resultado += c;
                        }

                    }
                    System.out.println("Frase cifrada: " + resultado);
                    break;
                }

                case 2 -> {
                    System.out.print("Ingrese una frase: ");
                    String frase2 = lea.nextLine();
                    frase2 = frase2.toLowerCase();

                    System.out.print("Ingresar numero entero de longitud minima posible: ");
                    int longitudmin = lea.nextInt();
                    lea.nextLine();
                    frase2 += " ";

                    String cadapalabra = "";
                    System.out.println("Palabras con mas de " + longitudmin + " caracteres:");
                    int i = 0;
                    int longitudFrase = frase2.length();
                    while (i < longitudFrase) {
                        char c = frase2.charAt(i);

                        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == 'ñ' || c == 'Ñ') {
                            cadapalabra += c;
                        } else if (c == ' ' && cadapalabra.length() > 0) {
                            if (cadapalabra.length() > longitudmin) {
                                System.out.println(cadapalabra);
                            }
                            cadapalabra = "";
                        }
                        i++;
                    }
                    break;
                }
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
                                String par = "";
                                String impar = "";

                                int i = 0;
                                while (i < texto.length()) {
                                    char letra = texto.charAt(i);
                                    if (i % 2 == 0) {
                                        impar += letra;

                                    } else {
                                        par += letra;
                                    }
                                    i++;
                                }

                                String resultado = par + impar;
                                System.out.println("Letras par: "+par);  
                                System.out.println("Letras impar: "+impar);
                                System.out.println("Texto encriptado: " + resultado);
                                
                            }
                            case 2 -> {
                                System.out.print("Ingrese texto encriptado: ");
                                String texto = lea.nextLine();

                                int separacion= texto.length()/2;
                                String par= texto.substring(0,separacion);
                                String impar= texto.substring(separacion);

                                String resultado= " ";
                                int pares=0;
                                int impares=0;
                                for(int k=0; k<texto.length();k++){
                                    if(k%2==0){

                                        resultado += impar.charAt(impares++);
                                    }else{

                                    resultado += par.charAt(pares++);    
                                    } 
                                    }
                                System.out.println("Resultado: "+resultado);
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
