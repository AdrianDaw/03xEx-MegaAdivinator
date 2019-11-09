/* 
 * Copyright 2019 Adrián Pérez Rodríguez - adrianp899@gmail.com .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrián Pérez Rodríguez - adrianp899@gmail.com
 */
public class Main {

    public static final Random RND = new Random();
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        // REFERENCIAS
        int intentos = 3;
        final int CUENTA_INI = 1;
        final int CUENTA_FIN = 3;
        int i;
        final int minimoNumero = 1;
        final int maximoNumero = 10;
        int aleatorio;
        int numero = 0;

        //INICIALIZACION
        i = CUENTA_INI;

        // CABECERA
        System.out.println("MEGA ADIVINATOR (c) 2019 - JAPO Labs");
        System.out.println("------------------------------------");
        System.out.printf("Se ha generado un número entre %d y %d%n", minimoNumero, maximoNumero);
        System.out.println("---");

        //GENERAR VALOR ALEATORIO
        aleatorio = RND.nextInt(maximoNumero - minimoNumero + 1) + minimoNumero; // [MIN .. MAX]

        //COMPROBACION
        System.out.println("----");
        System.out.printf("Numero generado para la comprobacion: %d%n", aleatorio);
        System.out.println("----");

        //BUCLE
        do {

            try {
                // PETICION DE NUMERO
                System.out.printf("Quedan %d intentos - Número: ", intentos);
                numero = SCN.nextInt();

                if (numero == aleatorio) {
                    intentos = 0;
                    i = 4;

                } else if (intentos == 1) {
                    System.out.println("Número de intentos AGOTADO.");
                    System.out.println("---");
                    intentos = intentos - 1;
                    i++;

                } else if (aleatorio < numero) {
                    System.out.println("Prueba un numero MENOR.");
                    System.out.println("---");
                    intentos = intentos - 1;
                    i++;

                } else if (aleatorio > numero) {
                    System.out.println("Prueba un numero MAYOR.");
                    System.out.println("---");
                    intentos = intentos - 1;
                    i++;
                }

            } catch (Exception e) {
                // MENSAJE ENTRADA INCORRECTA
                System.out.println("ERROR: entrada incorrecta");

            } finally {
                SCN.nextLine();
            }

        } while (i < CUENTA_FIN + 1);

        if (aleatorio != numero) {
            System.out.printf("Era el %d - ¡Otra vez será!\n", aleatorio);
        }
        if (numero == aleatorio) {
            System.out.println("---");
            System.out.printf("Era el %d - ¡Enhorabuena!\n", aleatorio);
        }
    }
}
