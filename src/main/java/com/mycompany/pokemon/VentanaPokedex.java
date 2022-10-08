/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pokemon;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;

/**
 *
 * @author dell
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1=null;
    int contador=0;
    
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    @Override
    public void paint(Graphics g){
       super.paintComponents(g);
       Graphics2D g2 =(Graphics2D) imagenPokemon.getGraphics();
       
       g2.drawImage(buffer1,0,0,imagenPokemon.getWidth(),imagenPokemon.getHeight(),null);
       
       
    }
    
    
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        
        this.getContentPane().setBackground(Color.pink);
        try {
               imagen1= ImageIO.read(new File("C:\\Users\\dell\\OneDrive\\Documentos\\CUARTO SEMESTRE\\black-white.png.png"));
       
        } catch (IOException e) {
             System.out.println("Error al cargar imagen");
        }
         
        buffer1 = (BufferedImage) imagenPokemon.createImage(imagenPokemon.getWidth(),imagenPokemon.getHeight());

    Graphics2D g2 = buffer1.createGraphics();
    
    dibujaElPokemonQueEstaEnLaPosicion(30);
  
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
        String JDBC_URL="jdbc:mysql://localhost:3306/pokedex?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        conexion = DriverManager.getConnection(JDBC_URL,"root","");
         estado=conexion.createStatement();
        } catch (Exception e){
            System.out.println("Hay error"+e.getMessage());
        }
    

    
    
    }
          private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
 int fila = posicion / 31;
int columna = posicion % 31;
Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
 g2.setColor(Color.green);      
 g2.fillRect(0,0,//pinta el fondo del jpanel negro
 imagenPokemon.getWidth(), imagenPokemon.getHeight()); 

     g2.drawImage(imagen1,0,//posicion x inicial
         0,// posicion inicial del jpanel
         imagenPokemon.getWidth(), //ancho del jpanel
         imagenPokemon.getHeight(),// alto de jpanel
         columna*96,// posicion inial y dentro de la imagen de todos los pokemones
        fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
         columna*96 + 96,// posicion final de x
         fila*96+96,// posicion final  y 
         
         null
     
         );
     
 repaint();


 

        } 
    
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        nombrepokemon = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        izq.setBackground(new java.awt.Color(255, 96, 64));
        izq.setForeground(new java.awt.Color(255, 255, 255));
        izq.setText("izquierda");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        der.setBackground(new java.awt.Color(60, 202, 125));
        der.setForeground(new java.awt.Color(187, 87, 67));
        der.setText("Derecha");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        nombrepokemon.setText("                  Aqui va el nombre");

        txtid.setText("jTextField1");

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(BtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nombrepokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nombrepokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(imagenPokemon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(der, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izq, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        // TODO add your handling code here:
//  
          String cueri ="select * from pokemon where id="+(contador-1);
       dibujaElPokemonQueEstaEnLaPosicion(contador);  
        try {
            resultadoConsulta= estado.executeQuery(cueri);
             if (resultadoConsulta.next()){
                 nombrepokemon.setText(resultadoConsulta.getString(2));
 }else {
 nombrepokemon.setText("Ese chucho no figura en la pokedex");
}                   contador --;
 if (contador <= 0){
contador = 1;
        }

            
      } catch (Exception e) {
System.out.println("Hubo un erro en derecha"+e.getMessage());
        }
 
   
dibujaElPokemonQueEstaEnLaPosicion(contador);      
        
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        // TODO add your handling code here:
         String cuerito ="select * from pokemon where id="+(contador+1);
       dibujaElPokemonQueEstaEnLaPosicion(contador);  
        try {
            resultadoConsulta= estado.executeQuery(cuerito);
             if (resultadoConsulta.next()){
                 nombrepokemon.setText(resultadoConsulta.getString(2));
 }else {
 nombrepokemon.setText("Ese chucho no figura en la pokedex");
}
            
        } catch (Exception e) {
System.out.println("Hubo un erro en derecha"+e.getMessage());
        }
        contador ++;
 if(contador >649){
 contador=649;
    }//GEN-LAST:event_derActionPerformed
    }
    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
      
       int codigo = Integer.parseInt(txtid.getText());
          String cuerito ="select * from pokemon where id="+txtid.getText();
          
      dibujaElPokemonQueEstaEnLaPosicion(codigo);
        try {
            resultadoConsulta= estado.executeQuery(cuerito);
             if (resultadoConsulta.next()){
                 nombrepokemon.setText(resultadoConsulta.getString(2)+"\n Especie="+resultadoConsulta.getString("species"));
 }else {
 nombrepokemon.setText("Ese chucho no figura en la pokedex");
}
            
        } catch (Exception e) {
System.out.println("Hubo un erro en derecha"+e.getMessage());
        }
                   
    

        
        
        
    }//GEN-LAST:event_BtnBuscarActionPerformed
    


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
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton der;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel nombrepokemon;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
