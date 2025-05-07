package view;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Produto;
import model.Usuario;


/**
 * TelaBusca.java
 * 
 * @author Anthony
 * 
 * 
 * Descrição:
 * Esta classe implementa a interface gráfica da tela de busca de clientes ou produtos
 * no sistema GrafX. Permite visualizar informações a partir de seleção no comboBox.
 */


public class TelaBusca extends javax.swing.JFrame {

    
    private Usuario usuario;
    DefaultTableModel modeloTabela;
    
    
    /**
 * Construtor da tela de busca.
 * Inicializa a interface e define o modelo da tabela.
 *
 * @param usuario O usuário logado, utilizado para controle de permissões e retorno à tela anterior.
 */
    

    public TelaBusca(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        modeloTabela = new DefaultTableModel();
        tabelaResultado.setModel(modeloTabela);
    }

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTelaBusca = new javax.swing.JPanel();
        lblBusca = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        lblLogoGrafx = new javax.swing.JLabel();
        comboBoxTipo = new javax.swing.JComboBox<>();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lblTelaBusca.setBackground(new java.awt.Color(0, 0, 0));

        lblBusca.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBusca.setForeground(new java.awt.Color(255, 255, 255));
        lblBusca.setText("BUSCA");
        lblBusca.setToolTipText("TELA BUSCA");

        javax.swing.GroupLayout lblTelaBuscaLayout = new javax.swing.GroupLayout(lblTelaBusca);
        lblTelaBusca.setLayout(lblTelaBuscaLayout);
        lblTelaBuscaLayout.setHorizontalGroup(
            lblTelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblTelaBuscaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBusca)
                .addContainerGap(458, Short.MAX_VALUE))
        );
        lblTelaBuscaLayout.setVerticalGroup(
            lblTelaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblTelaBuscaLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblBusca)
                .addGap(19, 19, 19))
        );

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar.setText("VOLTAR ");
        btnVoltar.setToolTipText("CLIQUE PARA VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        lblLogoGrafx.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        lblLogoGrafx.setText("GrafX");
        lblLogoGrafx.setToolTipText("LOGO GRAFX");

        comboBoxTipo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE UMA OPÇÃO", "CLIENTE", "PRODUTO" }));
        comboBoxTipo.setToolTipText("CLIQUE PARA SELECIONAR UMA OPÇÃO");
        comboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipoActionPerformed(evt);
            }
        });

        btnEnviar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnviar.setText("ENVIAR ");
        btnEnviar.setToolTipText("CLIQUE PARA ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        tabelaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaResultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTelaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLogoGrafx))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(lblLogoGrafx)))
                .addGap(25, 25, 25)
                .addComponent(comboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        btnVoltar.getAccessibleContext().setAccessibleParent(btnVoltar);
        lblLogoGrafx.getAccessibleContext().setAccessibleParent(lblLogoGrafx);
        comboBoxTipo.getAccessibleContext().setAccessibleName("");
        comboBoxTipo.getAccessibleContext().setAccessibleParent(comboBoxTipo);
        btnEnviar.getAccessibleContext().setAccessibleParent(btnEnviar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
 * Ação do botão "Voltar".
 * Retorna para a tela inicial passando o usuário logado.
 *
 * @param evt Evento de clique no botão.
 */
    
    
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    TelaInicio telaInicio = new TelaInicio(usuario);
    telaInicio.setVisible(true);
    dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void comboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipoActionPerformed
       
    }//GEN-LAST:event_comboBoxTipoActionPerformed

    /**
 * Ação do botão "Enviar".
 * Executa a busca de clientes ou produtos conforme a seleção do comboBox.
 * Atualiza a tabela com os resultados obtidos do banco de dados.
 *
 * @param evt Evento de clique no botão.
 */
    
    
    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
    
    
    String tipo = comboBoxTipo.getSelectedItem().toString();

    modeloTabela.setRowCount(0); // limpa linhas antigas

    if (tipo.equalsIgnoreCase("cliente")) {
        modeloTabela.setColumnIdentifiers(new String[]{"Nome", "Telefone", "CPF", "Email", "Endereço"});

        List<Cliente> listaClientes = new ClienteDAO().buscarTodos();
        for (Cliente c : listaClientes) {
            modeloTabela.addRow(new Object[]{
                c.getNome(),
                c.getTelefone(),
                c.getCpf(),
                c.getEmail(),
                c.getEndereco()
            });
        }
    } else if (tipo.equalsIgnoreCase("produto")) {
        modeloTabela.setColumnIdentifiers(new String[]{"Descricao", "Quantidade","Valor Unitario"});

        List<Produto> listaProdutos = new ProdutoDAO().buscarTodos();
        for (Produto p : listaProdutos) {
            modeloTabela.addRow(new Object[]{
                p.getDescricao(),
                p.getQuantidade(),
                p.getValorUnitario()
            });
        }
    } else {
        JOptionPane.showMessageDialog(this, "Selecione Cliente ou Produto.");
    }


    }//GEN-LAST:event_btnEnviarActionPerformed

 
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
            java.util.logging.Logger.getLogger(TelaBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBusca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboBoxTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblLogoGrafx;
    private javax.swing.JPanel lblTelaBusca;
    private javax.swing.JTable tabelaResultado;
    // End of variables declaration//GEN-END:variables

    

    
}
