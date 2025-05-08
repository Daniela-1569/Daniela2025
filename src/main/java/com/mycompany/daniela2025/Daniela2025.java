/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.daniela2025;

import java.util.Scanner;

/**
 *
 * @author PC01
 */
public class Daniela2025 {

    Scanner scanner = new Scanner(System.in);
    double[] litros = new double[7];
    boolean salir = false;


         for (int i = 0; i < 7; i++) {
            double monto;
            do {
                System.out.print("Ingrese los litros consumidos " + (i + 1) + ": ");
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println("El monto debe ser numeros positivos. Intente de nuevo.");
                }
            } while (monto < 0);
            litros[i] = monto;
        

        while (salir) {

            System.out.println("Menu de Opciones:");
            System.out.println("1. Calcular el total de litros consumidos en la semana");
            System.out.println("2. Calcular el dia con consumos mas cercanas al promedio");
            System.out.println("3. Mostrar el dia de consumo mas alta y el dia con consumo mas bajo");
            System.out.println("4. Calcular el monto acumulado de consumo durante los primeros tres dias y los ultimos tres dias");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    double total = 0;
                    for (double litros : litros) {
                        total += litros;
                    }
                    System.out.println("Total de consumo en la semana: " + total);
                    break;

                case 2:
                    double promedio = 0;
                    for (double litros : litros) {
                        promedio += litros;
                    }
                    promedio /= 7;

                    double diferenciaMinima = Math.abs(litros[0] - promedio);
                    int diaCercano = 0;
                    for (int i = 1; i < 7; i++) {
                        double diferencia = Math.abs(litros[i] - promedio);
                        if (diferencia < diferenciaMinima) {
                            diferenciaMinima = diferencia;
                            diaCercano = i;
                        }
                    }
                    System.out.println("Dia con consumo mas cercanas al promedio: Dia " + (diaCercano + 1));
                    break;
                    
                case 3:
                    double litroMax = litros[0];
                    double litroMin = litros[0];
                    int diaMax = 0;
                    int diaMin = 0;
                    for (int i = 1; i < 7; i++) {
                        if (litros[i] > litroMax) {
                            litroMax = litros[i];
                            diaMax = i;
                        }
                        if (litros[i] < litroMin) {
                            litroMin = litros[i];
                            diaMin = i;
                        }
                    }
                    System.out.println("Dia con consumo mas alta: Dia " + (diaMax + 1));
                    System.out.println("Dia con consumo mas baja: Dia " + (diaMin + 1));
                    break;

                case 4:
                    double totalPrimerosTres = litros[0] + litros[1] + litros[2];
                    double totalUltimosTres = litros[4] + litros[5] + litros[6];
                    System.out.println("el total de consumo de  los tres primeros dias : " + totalPrimerosTres);
                    System.out.println("el total de consumo de  los tres ultimos dias : " + totalUltimosTres);
                    break;
    
                case 5:
                    salir = true;
                    System.out.println("Programa Finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
    }
}
