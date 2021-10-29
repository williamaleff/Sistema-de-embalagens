/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.dao.ProdutoDAO;
import model.bean.Produto;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author William Alefe <alefewilliam@gmail.com>
 */
public class ViewMain extends javax.swing.JFrame {

    /**
     * Creates new form ViewMain
     */
    public ViewMain() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(modelo));

        readJTable(); 
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/image/LogoHelice.jpeg"));
    }

    public String selectPesquisa(String s, String desc){
        if(s=="Id"){
            s = "id";
        }else if(s=="Código"){
            s = "codprod";
        }else if(s=="Logix Produto"){
            readJTableForLogix(desc);
        }else if(s=="Descrição Produto"){
            readJTableForDesc(desc);
        }else if(s=="Tipo"){
            readJTableForTipo(desc);
        }else if(s=="Peso Produto"){
            s = "pesoprod";
        }else if(s=="Embalagem"){
            s = "embalagem";
        }else if(s=="Peso Palete"){
            s = "pesopalete";
        }else if(s=="Paletização"){
            s = "paletizacao";
        }else if(s=="Logix Etiqueta"){
            s = "logixetiqueta";
        }else if(s=="Descrição Etiqueta"){
            s = "descetiqueta";
        } else {
            s = "";
        }    
        
            return s;
    }
    
    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCodprod(),
                p.getLogixprod(),
                p.getDescprod(),
                p.getTipo(),
                p.getPesoprod(),
                p.getEmbalagem(),
                p.getPesopalete(),
                p.getPaletizacao(),
                p.getLogixetiqueta(),
                p.getDescetiqueta(),
                p.getVersao(),
                p.getVigencia(),
                p.getDataDeInsercao(),
                p.getImagem()
            }
            );

        }
    }
    
    public void readJTableForDesc(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCodprod(),
                p.getLogixprod(),
                p.getDescprod(),
                p.getTipo(),
                p.getPesoprod(),
                p.getEmbalagem(),
                p.getPesopalete(),
                p.getPaletizacao(),
                p.getLogixetiqueta(),
                p.getDescetiqueta(),
                p.getVersao(),
                p.getVigencia(),
                p.getDataDeInsercao(),
                p.getImagem()
            }
            );

        }
    }
    
    public void readJTableForLogix(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.readForLogix(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCodprod(),
                p.getLogixprod(),
                p.getDescprod(),
                p.getTipo(),
                p.getPesoprod(),
                p.getEmbalagem(),
                p.getPesopalete(),
                p.getPaletizacao(),
                p.getLogixetiqueta(),
                p.getDescetiqueta(),
                p.getVersao(),
                p.getVigencia(),
                p.getDataDeInsercao(),
                p.getImagem()
            }
            );

        }
    }
    
    public void readJTableForTipo(String desc) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();
        for (Produto p : pdao.readForTipo(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getCodprod(),
                p.getLogixprod(),
                p.getDescprod(),
                p.getTipo(),
                p.getPesoprod(),
                p.getEmbalagem(),
                p.getPesopalete(),
                p.getPaletizacao(),
                p.getLogixetiqueta(),
                p.getDescetiqueta(),
                p.getVersao(),
                p.getVigencia(),
                p.getDataDeInsercao(),
                p.getImagem()
            }
            );

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewImagemFundo1 = new view.ViewImagemFundo();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTPesquisar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jCSelecionar = new javax.swing.JComboBox<>();
        jMenuGeral = new javax.swing.JMenuBar();
        jMAddProduto = new javax.swing.JMenu();
        jMUsuario = new javax.swing.JMenu();
        jMSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HELICE");

        viewImagemFundo1.setImg(new ImageIcon("src/image/BackgroundMain.jpg"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Código ", "Logix Produto", "Descrição Produto", "Tipo", "Peso Produto", "Embalagem", "Peso Palete", "Paletização", "Logix Etiqueta", "Descrição Etiqueta", "Versão", "Vigência", "Data De Inserção", "Imagem"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jBBuscar.setText("Buscar");

        jCSelecionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Logix Produto", "Descrição Produto", "Tipo", "Peso Produto", "Embalagem", "Peso Palete", "Paletização", "Logix Etiqueta", "Descrição Etiqueta", "Id", "Código" }));

        javax.swing.GroupLayout viewImagemFundo1Layout = new javax.swing.GroupLayout(viewImagemFundo1);
        viewImagemFundo1.setLayout(viewImagemFundo1Layout);
        viewImagemFundo1Layout.setHorizontalGroup(
            viewImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewImagemFundo1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1055, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(viewImagemFundo1Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewImagemFundo1Layout.setVerticalGroup(
            viewImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewImagemFundo1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(viewImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewImagemFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBBuscar)
                        .addComponent(jCSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jMAddProduto.setText("Adicionar");
        jMenuGeral.add(jMAddProduto);

        jMUsuario.setText("Usuário");
        jMenuGeral.add(jMUsuario);

        jMSobre.setText("Sobre");
        jMenuGeral.add(jMSobre);

        setJMenuBar(jMenuGeral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewImagemFundo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewImagemFundo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.getSelectedRow() != -1) {
            ViewAtualizarProduto a = new ViewAtualizarProduto();
            a.id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            a.codprod = (jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            a.logixprod = (jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            a.descprod = (jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            a.tipo = (jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            a.pesoprod = (jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
            a.embalagem = (jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            a.pesopalete = (jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
            a.paletizacao = (jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString());
            a.logixetiqueta = (jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString());
            a.descetiqueta = (jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString());
            a.versao = (jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString());
            a.vigencia = (jTable1.getValueAt(jTable1.getSelectedRow(), 12).toString());
            a.DataDeInsercao = (jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString());
            a.imagem = (jTable1.getValueAt(jTable1.getSelectedRow(), 14).toString());
         //   a.preencher();
            a.setVisible(true);
            
        }

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JComboBox<String> jCSelecionar;
    private javax.swing.JMenu jMAddProduto;
    private javax.swing.JMenu jMSobre;
    private javax.swing.JMenu jMUsuario;
    private javax.swing.JMenuBar jMenuGeral;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTable jTable1;
    private view.ViewImagemFundo viewImagemFundo1;
    // End of variables declaration//GEN-END:variables
}
