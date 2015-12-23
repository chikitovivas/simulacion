/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class Clase_retorno {
            public static List<double[]> lista_clientes;
            public static int q;

            public Clase_retorno(List<double[]> lista_clientes, int q) {
                this.lista_clientes = lista_clientes;
                this.q = q;
            }

            public static List<double[]> getList() {
                return lista_clientes;
            }

            public static int getQ() {
                return q;
            }
}
