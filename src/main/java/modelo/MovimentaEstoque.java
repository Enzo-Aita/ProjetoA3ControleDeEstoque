
package modelo;

import dao.ProdutoDao;
import java.util.ArrayList;

public class MovimentaEstoque {
    
    private ProdutoDao dao = new ProdutoDao();
    
    
     public String movimentarEstoque(int id, int quantidadeMovimentada, boolean adicionar) {
        Produto produto = dao.carregaProduto(id);

        if (produto == null) {
            return "Produto não encontrado.";
        }

        int LIMITE_ENTRADA = 150;
        int LIMITE_SAIDA = 25;

        if (adicionar && quantidadeMovimentada > LIMITE_ENTRADA) {
            return "Erro: A quantidade adicionada não pode ultrapassar " + LIMITE_ENTRADA + " unidades.";
        }

        if (!adicionar && quantidadeMovimentada > LIMITE_SAIDA) {
            return "Erro: A quantidade subtraída não pode ultrapassar " + LIMITE_SAIDA + " unidades.";
        }

        int novaQuantidade;
        if (adicionar) {
            novaQuantidade = produto.getQuantidade() + quantidadeMovimentada;
        } else {
            novaQuantidade = produto.getQuantidade() - quantidadeMovimentada;
            if (novaQuantidade < 0) {
                return "Erro: Estoque insuficiente para essa saída.";
            }
        }
        
        boolean atualizado = produto.updateQuantidadeBD(id, novaQuantidade);

        produto.setQuantidade(novaQuantidade);

        dao.updateProdutoBD(produto);

        if (!adicionar && novaQuantidade < produto.getQuantidademin()) {
            return "Produto subtraído.. Atenção: Estoque abaixo da quantidade mínima. Providencie nova compra.";
        }

        if (adicionar && novaQuantidade > produto.getQuantidademax()) {
            return "Produto adicionado. Atenção: Estoque acima da quantidade máxima. Não compre mais deste produto.";
        }

        return adicionar ? "Produto adicionado com sucesso." : "Produto subtraído com sucesso.";
    }

   
}
