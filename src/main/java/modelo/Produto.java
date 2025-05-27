
package modelo;

import java.util.ArrayList;
import dao.ProdutoDao;

public class Produto extends Pessoa {
    
    private String categoria;
    private int quantidade;
    private int quantidademax;
    private int quantidademin;

    public Produto() {
        this(0,"",0,"",0,0,0);
    }

   public Produto(int id,String produto, int preco,
String categoria, int quantidade, int quantidademax, int quantidademin) {
        super(id, produto, preco);
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.quantidademax = quantidademax;
        this.quantidademin = quantidademin;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        
    }

    public int getQuantidademax() {
        return quantidademax;
    }

    public void setQuantidademax(int quantidademax) {
        this.quantidademax = quantidademax;
    }

    public int getQuantidademin() {
        return quantidademin;
    }

    public void setQuantidademin(int quantidademin) {
        this.quantidademin = quantidademin;
    }
    @Override
    public String toString(){
        return super.toString() + "categoria=" + categoria + ",quantidade=" + quantidade +",quantidademax=" + quantidademax +",quantidademin=" +quantidademin;
    }
    public ArrayList<Produto>getMinhaLista(){
        return ProdutoDao.getMinhaLista();
    }
    
    public boolean insertProdutoBD(String produto, int
preco, String categoria, int quantidade, int quantidademax, int quantidademin) {
    int id = this.maiorID() + 1;
    Produto objeto = new Produto(id, produto, preco,categoria, quantidade, quantidademax, quantidademin);
    getMinhaLista().add(objeto);
    return true;
}

    public boolean deleteProdutoBD(int id) {
    int indice = this.procuraIndice(id);
    getMinhaLista().remove(indice);
    return true;
}

    public boolean updateProdutoBD(int id, String produto,
    int preco, String categoria, int quantidade, int quantidademax, int quantidademin) {
    Produto objeto = new Produto(id, produto, preco,
categoria, quantidade, quantidademax, quantidademin );
    int indice = this.procuraIndice(id);
    getMinhaLista().set(indice, objeto);
    return true;
}

    private int procuraIndice(int id) {
    int indice = -1;
    for (int i = 0; i < getMinhaLista().size(); i++) {
    if (getMinhaLista().get(i).getId() == id) {
    indice = i;
}
}
return indice;
}

    public Produto carregaProduto(int id) {
    int indice = this.procuraIndice(id);
    return getMinhaLista().get(indice);
}
    public String movimentarEstoque(int id, int quantidadeMovimentada, boolean adicionar, boolean subtrair) {
        Produto produto = carregaProduto(id);
        
    if (produto == null) {
            return "Produto não encontrado.";
        }

        int LIMITE_ENTRADA = 100;
        int LIMITE_SAIDA = 80;

        if (adicionar && quantidadeMovimentada > LIMITE_ENTRADA) {
            return "Erro: A quantidade adicionada não pode ultrapassar " + LIMITE_ENTRADA + " unidades.";
        }

        if (!subtrair && quantidadeMovimentada > LIMITE_SAIDA) {
            return "Erro: A quantidade subtraida não pode ultrapassar " + LIMITE_SAIDA + " unidades.";
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

        produto.setQuantidade(novaQuantidade);

        updateProdutoBD(produto.getId(),
                produto.getProduto(), (int) produto.getPreco(),
                produto.getCategoria(),
                produto.getQuantidade(),
                produto.getQuantidademax(),
                produto.getQuantidademin()
        );

        if (!subtrair && novaQuantidade < produto.getQuantidademin()) {
            return "Produto subtraído.. Atenção: Estoque abaixo da quantidade mínima. Providencie nova compra.";
        }

        if (adicionar && novaQuantidade > produto.getQuantidademax()) {
            return "Produto adicionado. Atenção: Estoque acima da quantidade máxima. Não compre mais deste produto.";
        }

        return adicionar ? "Produto adicionado com sucesso." : "Produto subtraído com sucesso.";
    }

public int maiorID(){
    return ProdutoDao.maiorID();
    
}

}
    
    

