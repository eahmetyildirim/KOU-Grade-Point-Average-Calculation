package kou_ortalama_hesaplama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Main extends javax.swing.JFrame {

    float FF,FD,DD,DC,CC,CB,BB,BA,AA;
    DefaultTableModel Model=new DefaultTableModel();
    float Ortalama=0;
    ArrayList<Dersler> dersler=new ArrayList<>();
      File file;
    public Main() {
        initComponents();
        Ortalama_jLabel.setText("");
        Model=(DefaultTableModel) jTable.getModel();
        Model.setRowCount(0);
        file=new File("ders_ortalama_hesaplama.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Oku();
      
    }
    public void HarfNotuTablosu(float SinifOrt){
    
      if(SinifOrt<42.5){
          FF=(float) 35.99;       
      }else if(SinifOrt<47.5){
          FF=(float) 33.99;
      }else if(SinifOrt<52.5){
          FF=(float) 31.99;
      }else if(SinifOrt<57.5){
          FF=(float) 29.99;
      }else if(SinifOrt<62.5){
          FF=(float) 27.99;
      }else if(SinifOrt<70){
          FF=(float) 25.99;
      }else if(SinifOrt<79.99){
          FF=(float) 23.99;
      }else if(SinifOrt<100){
          FF=(float) 29.0;
          FD=(float) 39.0;
          DD=(float) 49.0;
          DC=(float) 59.0;
          CC=(float) 69.0;
          CB=(float) 74.0;
          BB=(float) 79.0;
          BA=(float) 89.0;
          AA=(float) 100.0;
          return;
      }
      FD=FF+5;
      DD=FD+5;
      DC=DD+5;
      CC=DC+5;
      CB=CC+5;
      BB=CC+5;
      BA=BB+5;
      AA=100;

    }
    public float OrtalamaHesapla(){
    
    float NotTop=0,KrediTop=0;
    for(int i=0;i<Model.getRowCount();i++){
       KrediTop+= Float.valueOf(Model.getValueAt(i,4).toString());
        NotTop+= Float.valueOf(Model.getValueAt(i,3).toString())*Float.valueOf(Model.getValueAt(i,4).toString());
       
      
    }   
        return NotTop/KrediTop;
    }
    public float T_notu_Hesapla(float Sinif_Ort,float Not,float StandartSapma){
        return (((Not-Sinif_Ort)*10)/StandartSapma)+50;
    }
    public void Oku(){
         try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 float Ort_Top=0,Kredi_Top=0;
            while ((line = bufferedReader.readLine()) != null) {
                String rows[] =line.split(",");
                Dersler ders=new Dersler(rows[0],rows[1],rows[2],Float.valueOf(rows[3]),rows[4]);
                Ort_Top+=Float.valueOf(rows[3])*Float.valueOf(rows[4]);
                Kredi_Top+=Float.valueOf(rows[4]);
                Model.addRow(rows);
                System.out.println(line);
            }
            Ortalama_jLabel.setText(String.valueOf(Ort_Top/Kredi_Top));
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Yaz(){
    try {
            FileWriter writer = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(Dersler i:dersler){
                String yaz=i.getDers_adi()+","+i.getT_notu()+","+i.getHarf_notu()+","+i.getDortlukPuan()+","+i.getKredi();
            bufferedWriter.write(yaz);
            bufferedWriter.newLine();
            }
            
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        dersAdi = new javax.swing.JTextField();
        dersOrtalamasi = new javax.swing.JTextField();
        sinifOrtalamasi = new javax.swing.JTextField();
        standartSapma = new javax.swing.JTextField();
        kredi = new javax.swing.JTextField();
        Ortalama_jLabel = new javax.swing.JLabel();
        Sil_jButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton_Kaydet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("KOÜ ORTALAMA HESAPLAMA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Standart Sapma:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Ders Adı:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Ders Ortalaması:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Sınıf Ortalaması:");

        jButton1.setText("Hesapla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Kredi:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ders", "T Notu", "Harf Notu", "Dörtlük Puan", "Kredi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
        }

        Ortalama_jLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Ortalama_jLabel.setText("ORTALAMANIZ :");

        Sil_jButton.setText("Sil");
        Sil_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sil_jButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("E. Ahmet Yıldırım");

        jButton_Kaydet.setText("Kaydet");
        jButton_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_KaydetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ortalama_jLabel)
                        .addGap(127, 127, 127)
                        .addComponent(jButton_Kaydet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sil_jButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(dersAdi)
                            .addComponent(dersOrtalamasi)
                            .addComponent(sinifOrtalamasi)
                            .addComponent(standartSapma)
                            .addComponent(kredi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dersAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dersOrtalamasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(sinifOrtalamasi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(standartSapma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(kredi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sil_jButton)
                                .addComponent(jButton_Kaydet))
                            .addGap(50, 50, 50))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Ortalama_jLabel)
                            .addGap(25, 25, 25)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ders_adi=dersAdi.getText();
        float ders_ort=Float.valueOf(dersOrtalamasi.getText());
        float sinif_ort=Float.valueOf(sinifOrtalamasi.getText());
        float standart_sapma=Float.valueOf(standartSapma.getText());
        float kredi=Float.valueOf(this.kredi.getText());
        HarfNotuTablosu(sinif_ort);
        float T_notu=0;
        if(sinif_ort<80){
        T_notu=T_notu_Hesapla(sinif_ort, ders_ort, standart_sapma);
        }else if(sinif_ort>=80){
        T_notu=ders_ort;
        }
        
        String harf_notu="";
        float DortlukNot=0;
        if(T_notu<=FF){
        harf_notu="FF";
        DortlukNot=0; 
        }else if(T_notu<=FD){
        harf_notu="FD";
        DortlukNot=(float) 0.5;
        
        }else if(T_notu<=DD){
        harf_notu="DD";
        DortlukNot=(float) 1.0;
        
        }else if(T_notu<=DC){
        harf_notu="DC";
        DortlukNot=(float) 1.5;
        
        }else if(T_notu<=CC){
        harf_notu="CC";
        DortlukNot=(float) 2.0;
        
        }else if(T_notu<=CB){
        harf_notu="CB";
        DortlukNot=(float) 2.5;
        
        }else if(T_notu<=BB){
        harf_notu="BB";
        DortlukNot=(float) 3.0;
        }else if(T_notu<=BA){
        harf_notu="BA";
        DortlukNot=(float) 3.5;
        }else if(T_notu<=AA){
        harf_notu="AA";
        DortlukNot=4;
        } 
        
        
        
         Dersler ders=new Dersler(ders_adi,String.valueOf(T_notu), harf_notu, DortlukNot, String.valueOf(kredi));
       dersler.add(ders);
        Object[] row={ders_adi,T_notu,harf_notu,DortlukNot,kredi};
        Model.addRow(row);
        if(Model.getRowCount()>0){
        Ortalama_jLabel.setText("ORTALAMANIZ:"+OrtalamaHesapla());
        }else{
        Ortalama_jLabel.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Sil_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sil_jButtonActionPerformed
        int selected_row=jTable.getSelectedRow();
        Model.removeRow(selected_row);
         if(Model.getRowCount()>0){
        Ortalama_jLabel.setText("ORTALAMANIZ:"+OrtalamaHesapla());
        }else{
        Ortalama_jLabel.setText("");
        }
    }//GEN-LAST:event_Sil_jButtonActionPerformed

    private void jButton_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_KaydetActionPerformed
        
        Yaz();
        
    }//GEN-LAST:event_jButton_KaydetActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ortalama_jLabel;
    private javax.swing.JButton Sil_jButton;
    private javax.swing.JTextField dersAdi;
    private javax.swing.JTextField dersOrtalamasi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Kaydet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField kredi;
    private javax.swing.JTextField sinifOrtalamasi;
    private javax.swing.JTextField standartSapma;
    // End of variables declaration//GEN-END:variables
}
