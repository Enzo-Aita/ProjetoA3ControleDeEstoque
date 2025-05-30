package visao;

import modelo.Produto;
import javax.swing.JOptionPane;

public class FrmCadastroProduto extends javax.swing.JFrame {

    private Produto objetoproduto;

    public FrmCadastroProduto() {
        initComponents();
        this.objetoproduto = new Produto();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTFproduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFpreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFcategoria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTFquantidade = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JTFquantidademax = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTFquantidademin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Alunos");

        jLabel1.setText("Produto:");

        JTFproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFprodutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Preço:");

        jLabel3.setText("Categoria:");

        jLabel4.setText("Quantidade:");

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Quantidade Máxima:");

        jLabel6.setText("Quantidade Mínima:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBCancelar)
                            .addComponent(jLabel6))
                        .addGap(84, 84, 84)
                        .addComponent(JBCadastrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JTFquantidademin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addComponent(JTFquantidademax, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFquantidade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFcategoria, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFpreco, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFproduto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFquantidademax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTFquantidademin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBCadastrar))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        try {
            String produto = "";
            int preco = 0;
            String categoria = "";
            int quantidade = 0;
            int quantidademax = 150;
            int quantidademin = 25;

            if (this.JTFproduto.getText().length() < 2) {
                throw new Mensagem("Produto deve conter ao menos 2 caracteres.");
            } else {
                produto = this.JTFproduto.getText();
            }
            if (this.JTFpreco.getText().length() <= 0) {
                throw new Mensagem("Preço deve ser número e maior que zero.");
            } else {
                preco = Integer.parseInt(this.JTFpreco.getText());
            }

            if (this.JTFcategoria.getText().length() < 2) {
                throw new Mensagem("Categoria deve conter ao menos 2 caracteres.");
            } else {
                categoria = this.JTFcategoria.getText();
            }
            if (this.JTFquantidade.getText().length() <= 0) {
                throw new Mensagem("Quantidade deve ser número e maior que zero.");
            } else {
                quantidade = Integer.parseInt(this.JTFquantidade.getText());
            }
            if (quantidade < 25 ) {
                JOptionPane.showMessageDialog(null, "Quantidade menor que a mínima considere comprar mais");
            }
            if (quantidade > 150 ) {
                JOptionPane.showMessageDialog(null, "Quantidade maior que a máxima, não comprar mais");
            }
            

            if (this.JTFquantidademax.getText().length() == 150) {
                throw new Mensagem("Quantidade Máxima deve ser número");
            } else {
                quantidademax = Integer.parseInt(this.JTFquantidademax.getText());
            }
            if (quantidademax > 150) {
                throw new Mensagem("quantidade acima da quantidade máxima");
            }
            if (quantidademax < 150) {
                throw new Mensagem("quantidade abaixo da quantidade máxima");
            }
            if (this.JTFquantidademin.getText().length() == 25) {
                throw new Mensagem("Quantidade Mínima deve ser número");
            } else {
                quantidademin = Integer.parseInt(this.JTFquantidademin.getText());
            }
            if (quantidademin > 25) {
                throw new Mensagem("quantidade acima da quantidade mínima");
            }
            if (quantidademin < 25) {
                throw new Mensagem("quantidade abaixo da quantidade mínima");

            }

            if (this.objetoproduto.insertProdutoBD(produto, preco, categoria, quantidade, quantidademax, quantidademin)) {
                JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
                this.JTFproduto.setText("");
                this.JTFpreco.setText("");
                this.JTFcategoria.setText("");
                this.JTFquantidade.setText("");
                this.JTFquantidademax.setText("");
                this.JTFquantidademin.setText("");
            }
            System.out.println(this.objetoproduto.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTFprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFprodutoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFcategoria;
    private javax.swing.JTextField JTFpreco;
    private javax.swing.JTextField JTFproduto;
    private javax.swing.JTextField JTFquantidade;
    private javax.swing.JTextField JTFquantidademax;
    private javax.swing.JTextField JTFquantidademin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
