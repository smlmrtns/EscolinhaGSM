/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AlunoVO;
import servicos.EscolaServicos;
import servicos.ServicosFactory;
import utilidades.GerarPDF;

/**
 * @author GSM
 * @since 03/04/2018 - 19:11
 * @version 1.5 Los Angeles
 */
public class UINotasAluno extends javax.swing.JInternalFrame {

    AlunoVO a = new AlunoVO();

    DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"ID Aluno", "Nome"});

    public UINotasAluno() {
        initComponents();
        atualizarDados();
    }

    private void verificarAluno() {
        try {
            int linha = jtableDados.getSelectedRow();

            if (linha == -1) {
                JOptionPane.showMessageDialog(this,
                        "Selecione seu nome! ");
            } else {
                EscolaServicos ps = ServicosFactory.getEscolaServicos();
                ArrayList<AlunoVO> aluno = new ArrayList<>();
                String id = (String) jtableDados.getValueAt(linha, 0);
                String query = "where idaluno = " + id;
                aluno = ps.filtrarAluno(query);

                for (int i = 0; i < aluno.size(); i++) {
                    jtDetalhes.setText(aluno.get(i).toString());
                }

                jtableDados.setModel(dtm);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro! " + e.getMessage());
        }
    }

    public void gerarPDF() {
        try {
            String nomePDF = "Boletim" + Math.random();
            GerarPDF.setNomePDF(nomePDF);

            int linha = jtableDados.getSelectedRow();

            EscolaServicos ps = ServicosFactory.getEscolaServicos();
            ArrayList<AlunoVO> aluno = new ArrayList<>();
            String id = (String) jtableDados.getValueAt(linha, 0);
            String query = "where idaluno = " + id;
            aluno = ps.filtrarAluno(query);

            for (int i = 0; i < aluno.size(); i++) {
                jtDetalhes.setText(aluno.get(i).toString());
            }

            jtableDados.setModel(dtm);

            GerarPDF.gerarPDF(aluno);

            JOptionPane.showMessageDialog(this,
                    "PDF gerado com sucesso!"
                    + "\nNome do arquivo gerado: " + nomePDF);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro! " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        jbImprimir = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDetalhes = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Meus Dados");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jbImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Aluno", "Nome"
            }
        ));
        jtableDados.getTableHeader().setReorderingAllowed(false);
        jtableDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableDados);

        jtDetalhes.setColumns(20);
        jtDetalhes.setRows(5);
        jScrollPane2.setViewportView(jtDetalhes);

        jLayeredPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(228, 228, 228))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        gerarPDF();
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtableDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableDadosMouseClicked
        verificarAluno();
    }//GEN-LAST:event_jtableDadosMouseClicked

    private void atualizarDados() {
        try {

            EscolaServicos ps = ServicosFactory.getEscolaServicos();

            ArrayList<AlunoVO> prod = new ArrayList<>();

            prod = ps.buscarAluno();

            for (int i = 0; i < prod.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(prod.get(i).getIdAluno()),
                    String.valueOf(prod.get(i).getNomeAluno()),
                    String.valueOf(prod.get(i).getIdadeAluno()),
                    String.valueOf(prod.get(i).getSexo()),
                    String.valueOf(prod.get(i).getN1()),
                    String.valueOf(prod.get(i).getN2()),
                    String.valueOf(prod.get(i).getTurma()),
                    String.valueOf(prod.get(i).calcularMedia())
                });
            }
            jtableDados.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }
    }

    private void limparTabela() {
        dtm.setNumRows(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JTextArea jtDetalhes;
    private javax.swing.JTable jtableDados;
    // End of variables declaration//GEN-END:variables
}
