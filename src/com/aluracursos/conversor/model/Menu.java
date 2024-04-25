package com.aluracursos.conversor.model;

public class Menu {

    public void muestrMenu() {
        System.out.println("\n*************************** Conversor de moneda **************************");
        System.out.println("\n************************ Escoja uma opción válida ************************\n");
        System.out.println("""
                                                1) De Dólar a Peso Argentino
                                                2) De Peso Argentino a Dólar
                                                3) De Dólar a Real Brasilero
                                                4) De Real Brasilero a Dólar
                                                5) De Dólar a Peso Colombiano
                                                6) De Peso colombiano a Dólar
                                                7) Sair
                        """
        );
        System.out.println("****************************************************************************");
    }
}
