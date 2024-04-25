package com.aluracursos.conversor.principal;

import com.aluracursos.conversor.conection.ConnecttoApi;
import com.aluracursos.conversor.model.Menu;
import com.aluracursos.conversor.model.Moneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Menu menu = new Menu();
        int opcionElegida = 0;
        double importeElegido = 0.0;
        boolean esNumeroInt = false;
        boolean esNumeroDouble = false;
        Scanner teclado = new Scanner(System.in);
        ConnecttoApi request = new ConnecttoApi();

        while (true){

            menu.muestrMenu();
            while (!esNumeroInt){
                try {
                    System.out.println("a continuación elija la opción deseada: ");
                    opcionElegida = teclado.nextInt();
                    esNumeroInt = true;
                } catch (InputMismatchException e){
                    System.out.println("¡Opción erronea! Intente nuevamente");
                    teclado.nextLine();
                }

            }

            if (opcionElegida == 7){
                System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios.");
                break;
            }

            if (opcionElegida > 0 && opcionElegida < 8){

                while (!esNumeroDouble){
                    try {
                        System.out.println("a continuación ingrese el importe a convertir:");
                        importeElegido = teclado.nextDouble();
                        esNumeroDouble = true;
                    } catch (InputMismatchException e){
                        System.out.println("¡Importe erroneo! Intente nuevamente");
                        teclado.nextLine();
                    }
                }
            }

            switch (opcionElegida){
                case 1:
                    Moneda usdToArg = request.consultaConvercion("USD","ARS",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Dólares [USD] a Pesos [ARS] corresponde a: $ "+usdToArg.conversion_result()+" Ars.");
                    break;
                case 2:
                    Moneda argToUsd = request.consultaConvercion("ARS","USD",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Pesos [ARS] a Dólares [USD] corresponde a: $ "+argToUsd.conversion_result()+" Usd.");
                    break;
                case 3:
                    Moneda usdToBrl = request.consultaConvercion("USD","BRL",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Dólares [USD] a Reales [BRL] corresponde a: $ "+usdToBrl.conversion_result()+" Brl.");
                    break;
                case 4:
                    Moneda brlToUsd = request.consultaConvercion("BRL","USD",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Reales [BRL] a Dólares [USD] corresponde a: $ "+brlToUsd.conversion_result()+" Usd.");
                    break;
                case 5:
                    Moneda usdToCol = request.consultaConvercion("USD","COP",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Dólares [USD] a Pesos [COL] corresponde a: $ "+usdToCol.conversion_result()+" Col.");
                    break;
                case 6:
                    Moneda colToUsd = request.consultaConvercion("COP","USD",importeElegido);
                    System.out.println("La converción de "+importeElegido+" Pesos [COL] a Dólares [USD] corresponde a: $ "+colToUsd.conversion_result()+" Usd.");
                    break;
                default:
                    System.out.println("La opción elegida no es válida");
            }
            esNumeroInt = false;
            esNumeroDouble = false;
        }

    }

}
