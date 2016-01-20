/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.swing.JCheckBox;

/**
 *
 * @author Nico
 */
public class Pan_registro extends javax.swing.JPanel {

    Cod_registro reg;
    JCheckBox[] horario;
    String cedula,nom,ape,tlf,tlf2,email,email2,dir;
    String[] horas;
    
    public Pan_registro() {
        initComponents();
        this.set_horario();
        this.set_globales();
    }

    public Pan_registro(Object ventana) {
        initComponents();
        this.set_horario();
        this.set_globales();
    }

    private void set_horario(){
        JCheckBox[] aux={
            this.am6,this.am7,this.am8,this.am9,
            this.am10,this.am11,this.pm12,this.pm1,
            this.pm2,this.pm3,this.pm4,this.pm5,
            this.pm6,this.pm7,this.pm8,this.pm9
        };
        
        horario=aux;      
   }
    
    private void get_variables(){
        this.cedula=this.ci.getText();
        this.nom=this.nombre.getText();
        this.ape=this.apellido.getText();
        this.dir=this.direccion.getText();
        this.tlf=this.telf.getText();
        this.tlf2=this.telf2.getText();
        this.email=this.mail.getText()+"@"+this.cmail.getSelectedItem().toString();
        this.email2=this.mail2.getText()+"@"+this.cmail2.getSelectedItem().toString();            
        this.tomar_horas();
    }
    
    private void set_globales(){
        this.cedula="";
        this.nom="";
        this.ape="";
        this.dir="";
        this.tlf="";
        this.tlf2="";
        this.email="";
        this.email2="";
        this.horas=null;
    }
    private void set_variables(){
        this.ci.setText("");
        this.nombre.setText("");
        this.apellido.setText("");
        this.direccion.setText("");
        this.telf.setText("");
        this.telf2.setText("");
        this.mail.setText("");
        this.mail2.setText("");
        this.cmail.setSelectedIndex(0);
        this.cmail2.setSelectedIndex(0);
        
        set_globales();
    }
    
    private void tomar_horas(){
        String[] aux=new String[this.horario.length];
        for(int i=0;i<aux.length;i++){
            if(this.horario[i].isSelected()==true)
                aux[i]=(this.horario[i]).getText();
        }
       
        this.horas=aux;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        mail = new javax.swing.JTextField();
        pm4 = new javax.swing.JCheckBox();
        telf = new javax.swing.JTextField();
        pm5 = new javax.swing.JCheckBox();
        telf2 = new javax.swing.JTextField();
        pm2 = new javax.swing.JCheckBox();
        apellido = new javax.swing.JTextField();
        pm3 = new javax.swing.JCheckBox();
        direccion = new javax.swing.JTextField();
        pm8 = new javax.swing.JCheckBox();
        nombre = new javax.swing.JTextField();
        pm6 = new javax.swing.JCheckBox();
        pm7 = new javax.swing.JCheckBox();
        mail2 = new javax.swing.JTextField();
        pm9 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        am6 = new javax.swing.JCheckBox();
        am7 = new javax.swing.JCheckBox();
        am8 = new javax.swing.JCheckBox();
        am9 = new javax.swing.JCheckBox();
        am10 = new javax.swing.JCheckBox();
        ci = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        am11 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pm1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        pm12 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmail = new javax.swing.JComboBox();
        cmail2 = new javax.swing.JComboBox();
        Guardar = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        mail.setText("Tehagocaballito");

        pm4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm4.setText("04:00 PM");

        telf.setText("04121234567");

        pm5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm5.setText("05:00 PM");

        telf2.setText("04147654321");

        pm2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm2.setText("02:00 PM");

        apellido.setText("Jackson");

        pm3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm3.setText("03:00 PM");

        direccion.setText("Petare");

        pm8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm8.setText("08:00 PM");

        nombre.setText("Jaimito");

        pm6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm6.setText("06:00 PM");

        pm7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm7.setText("07:00 PM");

        mail2.setText("nosemeocurrenada");

        pm9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm9.setText("09:00 PM");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Registro de usuarios");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Horas de trabajo");

        am6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am6.setText("06:00 AM");

        am7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am7.setText("07:00 AM");

        am8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am8.setText("08:00 AM");

        am9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am9.setText("09:00 AM");

        am10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am10.setText("10:00 AM");

        ci.setText("123456789");

        jLabel1.setText("CI");

        jLabel8.setText("Email 2");

        am11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        am11.setText("11:00 AM");

        jLabel5.setText("Telefono");

        jLabel4.setText("Direccion");

        pm1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm1.setText("01:00 PM");

        jLabel3.setText("Apellido");

        pm12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pm12.setText("12:00 PM");

        jLabel2.setText("Nombre");

        jLabel7.setText("Email");

        jLabel6.setText("Telefono 2");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Medico");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Asistente");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Datos personales");

        jLabel9.setText("@");

        jLabel13.setText("@");

        cmail.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gmail.com", "yahoo.com", "hotmail.com" }));

        cmail2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gmail.com", "yahoo.com", "hotmail.com" }));

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Borrar.setText("Borrar campos");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Guardar)
                        .addGap(18, 18, 18)
                        .addComponent(Borrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(mail2)
                                    .addComponent(mail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telf2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ci))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(am6)
                                                    .addComponent(am7)
                                                    .addComponent(pm12)
                                                    .addComponent(am11)
                                                    .addComponent(am10)
                                                    .addComponent(am9)
                                                    .addComponent(am8)
                                                    .addComponent(pm1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(pm3)
                                                    .addComponent(pm2)
                                                    .addComponent(pm9)
                                                    .addComponent(pm8)
                                                    .addComponent(pm7)
                                                    .addComponent(pm6)
                                                    .addComponent(pm4)
                                                    .addComponent(pm5)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardar)
                            .addComponent(Borrar))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm2)
                            .addComponent(am6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm3)
                            .addComponent(am7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm4)
                            .addComponent(am8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm5)
                            .addComponent(am9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm6)
                            .addComponent(am10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm7)
                            .addComponent(am11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm8)
                            .addComponent(pm12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pm9)
                            .addComponent(pm1)))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(mail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        this.set_variables();
    }//GEN-LAST:event_BorrarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        this.get_variables();  
        reg=new Cod_registro(this.cedula,this.nom,this.ape,this.dir,
                                this.tlf,this.tlf2,
                                this.email,this.email2,
                                this.horas);
        
        reg.enviar_registro();
        
    }//GEN-LAST:event_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Guardar;
    private javax.swing.JCheckBox am10;
    private javax.swing.JCheckBox am11;
    private javax.swing.JCheckBox am6;
    private javax.swing.JCheckBox am7;
    private javax.swing.JCheckBox am8;
    private javax.swing.JCheckBox am9;
    private javax.swing.JTextField apellido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField ci;
    private javax.swing.JComboBox cmail;
    private javax.swing.JComboBox cmail2;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField mail2;
    private javax.swing.JTextField nombre;
    private javax.swing.JCheckBox pm1;
    private javax.swing.JCheckBox pm12;
    private javax.swing.JCheckBox pm2;
    private javax.swing.JCheckBox pm3;
    private javax.swing.JCheckBox pm4;
    private javax.swing.JCheckBox pm5;
    private javax.swing.JCheckBox pm6;
    private javax.swing.JCheckBox pm7;
    private javax.swing.JCheckBox pm8;
    private javax.swing.JCheckBox pm9;
    private javax.swing.JTextField telf;
    private javax.swing.JTextField telf2;
    // End of variables declaration//GEN-END:variables
}
