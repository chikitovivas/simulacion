/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class Home extends javax.swing.JFrame {
    static Menu menu = new Menu();
    private int Q;
    private int R;
    /*
    Variables de la simulacion
    */
    private int demanda_diaria;
    private int inventario_ini;
    private int inventario_fin;
    private int faltante;
    private int inventario_promedio;
    private int tiempo_entrega;
    private int tiempo_espera;
    private int numero_orden=0;
    private double aleatorio_demanda;
    private double[][] matriz_demanda;
    private double[][] matriz_entrega ;
    private double[][] matriz_espera;

    /**
     * Creates new form Home
     */
    
    public Home(){
        initComponents();
    }
    
    public Home(double[][] matriz_demanda, double[][] matriz_entrega, 
            double[][] matriz_acum_demanda,double[][] matriz_acum_entrega,double[][] matriz_acum_espera,
            double costo_inventario, double costo_orden, int inventario_ini, double costo_nespera, double costo_espera) {
        
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel();
        DefaultTableModel model1 = new DefaultTableModel();
        DefaultTableModel model2 = new DefaultTableModel();
       
        /*
        matriz_acumulada_demanda
        matriz_acum_espera
        matriz_acum_entrega
        matriz_demanda
        matriz_entrega
        costo_inventario
        costo_orden
        inventario_ini
        costo_nespera
        costo_espera
        */
        
        /*
        Ejemplo
        */
        matriz_demanda = new double[][]{
            new double[] { 25, .02},
            new double[] { 26, .04},
            new double[] { 27, .06},
            new double[] { 28, .12},
            new double[] { 29, .2},
            new double[] { 30, .24},
            new double[] { 31, .15},
            new double[] { 35, .10},
            new double[] { 33, .05},
            new double[] { 34, .02},    
        };     
        matriz_entrega = new double[][]{
            new double[] { 1, .2},
            new double[] { 2, .3},
            new double[] { 3, .25},
            new double[] { 4, .25},            
        }; 
        matriz_espera = new double[][]{
            new double[] { 0, .4},
            new double[] { 1, .2},
            new double[] { 2, .15},
            new double[] { 3, .15},
            new double[] { 4, .1},          
        };    
        
        List data = new ArrayList();
        for(int i=0;i<matriz_demanda.length;i++){
            data.add(matriz_demanda[i][1]);
            model.addColumn((int)matriz_demanda[i][0], data.toArray());
            data.clear();
        }
        for(int i=0;i<matriz_entrega.length;i++){
            data.add(matriz_entrega[i][1]);
            model1.addColumn((int)matriz_entrega[i][0], data.toArray());
            data.clear();
        }
        for(int i=0;i<matriz_espera.length;i++){
            data.add(matriz_espera[i][1]);
            model2.addColumn((int)matriz_espera[i][0], data.toArray());
            data.clear();
        }                
        demanda_table.setModel(model);
        entrega_table.setModel(model1);
        espera_table.setModel(model2); 
        Q = 100;
        R = 75;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        demanda_table = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        espera_table = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        entrega_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        costo_inventario = new javax.swing.JTextField();
        costo_orden = new javax.swing.JTextField();
        costo_espera = new javax.swing.JTextField();
        costo_nespera = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        inventario_inicial = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargar Datos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Probabilidades"));

        jLabel1.setText("Demanda diaria:");

        jLabel2.setText("Tiempo de Entrega:");

        jLabel3.setText("Tiempo de Espera Clientes :");

        demanda_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(demanda_table);

        jScrollPane4.setViewportView(espera_table);

        jScrollPane5.setViewportView(entrega_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Costos"));

        jLabel4.setText("Costo de inventario: ");

        jLabel5.setText("Costo de ordenar:");

        jLabel6.setText("Costo de faltante con espera de cliente:");

        jLabel7.setText("Costo de faltante sin espera del cliente: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(costo_inventario)
                    .addComponent(costo_orden, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(costo_nespera, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(costo_espera)))
                .addGap(35, 35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(costo_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costo_espera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(costo_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costo_nespera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Otros"));

        jLabel8.setText("Inventario inicial:");

        jLabel9.setText("Presentacion o no de tabla de eventos?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(inventario_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inventario_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(18, 18, 18)
                .addComponent(start)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(start))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
       
       /* if(costo_sf_cliente != 0 && costo_pedido != 0 && costo_f_cliente != 0 && costo_unidad != 0 && inven_inicial != 0 && costo_f_cliente != 0){
            
               /* Random rnd = new Random(0);
                for(int i = 0; i < 15; i++){
                    System.out.println((int)(rnd.nextDouble() * 100));
                }*/

       /* }else{
            JOptionPane.showMessageDialog(null, "Llenar los campos requeridos /n");
        }*/

        double[][] matriz_acum_demanda = Funciones.fnumacumulado(matriz_demanda);
        double[][] matriz_acum_entrega = Funciones.fnumacumulado(matriz_entrega);
        double[][] matriz_acum_espera = Funciones.fnumacumulado(matriz_espera);
        
        /* Random*/
        Random rnd = new Random(0);
        /* Titulos */
        System.out.printf("Dia\t|Inv.ini|No.Al D|Demanda|Inv.Fin|Inv.prm|Faltant|No.Ordn|No.AleE|T.ntrga|No.Ales|T.espera %n");
         
        /* Inicializacion de variables para simulacion*/
        inventario_ini = Integer.parseInt(inventario_inicial.getText());
        double[] array = Funciones.fread_aleatorios();
        int dia_orden=0;
        double costo_faltante = 0;
        int costoOrden = Integer.parseInt(costo_orden.getText());
        double costoInventario = 0;
        double costo_total = 0;
        int dia=0;
        Clase_retorno clase;
      /*  int[] minima = Funciones.fcalculo_q_r(Integer.parseInt(costo_orden.getText()), (int)matriz_demanda[0][0], Integer.parseInt(costo_inventario.getText()), Double.parseDouble(costo_nespera.getText()), (int)matriz_espera[0][0]);
        int[] maxima = Funciones.fcalculo_q_r(Integer.parseInt(costo_orden.getText()), (int)matriz_demanda[matriz_demanda.length-1][0], Integer.parseInt(costo_inventario.getText()), Double.parseDouble(costo_nespera.getText()), (int)matriz_espera[matriz_espera.length-1][0]);
        int Qminima = minima[0];
        int Qmaxima = maxima[0];
        int Rminima = minima[1];
        int Rmaxima = maxima[1];
        System.out.println(" Qminima: "+Qminima+" Qmaxima: "+Qmaxima+" Rminima: "+Rminima+" Rmaxima: "+Rmaxima);*/
        /**/double[] array_entrega = new double[5];
        double[] array_espera = new double[2];
        array_entrega[0] = 0.22;
        array_entrega[1] = 0.43;
        array_entrega[2] = 0.19;
        array_entrega[3] = 0.29;
        array_entrega[4] = 0.76;
        
        array_espera[0] = 0.64;
        array_espera[1] = 0.06;
        int acum_entrega = 0;
        int acum_espera = 0;
        List<double[]> lista_clientes = new ArrayList<double[]>();
        /* dias de simulacion*/
        for(int i = 1 ; i <= 15; i++){  
            /* if para ver si ya la orden llego*/
            if(tiempo_espera + dia_orden < i && dia_orden != 0){
                inventario_ini = inventario_ini + Q;
                clase = Funciones.fllegada_pedidos(lista_clientes,inventario_ini);
                inventario_ini = clase.getQ();
                lista_clientes = clase.getList();
                dia_orden = 0;
            }
            /* aleatorio demanda*/
            aleatorio_demanda = (double)(rnd.nextDouble() * 100)/100;
            //demanda_diaria = Funciones.fcompare(aleatorio_demanda,matriz_acum_demanda);
            /* demanda_diaria */
            demanda_diaria = Funciones.fcompare(array[i-1],matriz_acum_demanda);
            /* inventario final */
            inventario_fin = (int)inventario_ini - demanda_diaria;
            /* si inventario es negativo, es decir, hay faltante */
            if(inventario_fin < 0){
                faltante = Math.abs(inventario_fin);
                /**/lista_clientes.add(new double[] {Funciones.fcompare(array_espera[acum_espera],matriz_acum_espera) , faltante});
                /**/acum_espera++;
                inventario_fin = 0;
                /* inventario_promedio */
                inventario_promedio = (inventario_ini + inventario_fin) / 2;
                costoInventario = costoInventario + inventario_promedio;
                /* si el inventario final es menor al punto de Reorden y no hay una orden puesta, pide una orden y muestra */
                if(inventario_fin <= R && dia_orden == 0){
                    /* pide el tiempo de espera de la proxima orden */
                    /**/tiempo_espera = Funciones.fcompare(array_entrega[acum_entrega], matriz_acum_entrega);
                    /**/acum_entrega++;
                    /* la cantidad de ordenes*/
                    numero_orden++;
                    /* dia en el que se pidio la orden */
                    dia_orden = i;
                    
                    lista_clientes = Funciones.fespera_clientes(lista_clientes);
                    
                    System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|%d\t|%.2f\t|%d\t|%.2f\t|%d\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,numero_orden,aleatorio_demanda,tiempo_espera,aleatorio_demanda,Funciones.fcompare(aleatorio_demanda,matriz_acum_espera));

                }else{
                    System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|\t|\t|\t| %.2f\t| %d\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,aleatorio_demanda,Funciones.fcompare(aleatorio_demanda,matriz_acum_espera));
                }
            }else{
                /* inventario_promedio */
                inventario_promedio = (inventario_ini + inventario_fin) / 2;
                costoInventario = costoInventario + inventario_promedio;
                /* si el inventario final es menor al punto de Reorden y no hay una orden puesta, pide una orden y muestra */
                if(inventario_fin <= R && dia_orden == 0){
                    /* pide el tiempo de espera de la proxima orden */
                    /**/tiempo_espera = Funciones.fcompare(array_entrega[acum_entrega], matriz_acum_entrega);
                    /**/acum_entrega++;
                    /* la cantidad de ordenes*/
                    numero_orden++;
                    /* dia en el que se pidio la orden */
                    dia_orden = i;
                    
                    lista_clientes = Funciones.fespera_clientes(lista_clientes);
                    
                    System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|%d\t|%.2f\t|%d\t|\t|\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante,numero_orden,aleatorio_demanda,tiempo_espera);

                }else{
                    System.out.printf("%d\t|%d\t|%.2f\t|%d\t|%d\t|%d\t|%d\t|\t|\t|\t|\t|\t| %n", i,inventario_ini,array[i-1],demanda_diaria,inventario_fin,inventario_promedio,faltante);
                }
            }

            /* inventario inicial del proximo dia */
            inventario_ini = inventario_fin;
            dia = i;
        }
        /* Costos */
        System.out.println("Costos Inventario = " + costoInventario);
        costoInventario = costoInventario * (Double.parseDouble(costo_inventario.getText()) / 365 );
        costoOrden = numero_orden * costoOrden;
        costo_faltante = Funciones.fcosto_faltante(Double.parseDouble(costo_nespera.getText()),Double.parseDouble(costo_espera.getText()) );
        costo_total = costoInventario + costoOrden + costo_faltante;
                
        System.out.println("Costos Inventario = " + costoInventario);
        System.out.println("Costos Orden = " + costoOrden);
        System.out.println("Costos Faltante = " + costo_faltante);
        
        System.out.println("Costo total = " + costo_total);
    }//GEN-LAST:event_startActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        menu.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     /*   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField costo_espera;
    private javax.swing.JTextField costo_inventario;
    private javax.swing.JTextField costo_nespera;
    private javax.swing.JTextField costo_orden;
    private javax.swing.JTable demanda_table;
    private javax.swing.JTable entrega_table;
    private javax.swing.JTable espera_table;
    private javax.swing.JTextField inventario_inicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
