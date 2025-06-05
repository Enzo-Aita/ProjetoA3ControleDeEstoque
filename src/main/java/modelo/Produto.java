package modelo;

import java.util.ArrayList;
import dao.ProdutoDao;

public class Produto extends Categoria {

    private String categoria;
    private int quantidade;
    private int quantidademax;
    private int quantidademin;
    private ProdutoDao dao;

    public Produto() {
        this(0, "", 0, "", "", 0, 0, 0);
    }

    public Produto(int id, String produto, double preco, String unidade,
            String categoria, int quantidade, int quantidademax, int quantidademin) {
        super(id, produto, preco, unidade);
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.quantidademax = quantidademax;
        this.quantidademin = quantidademin;
        this.dao = new ProdutoDao();
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
    public String toString() {
        return super.toString() + "categoria=" + categoria + ",quantidade=" + quantidade + ",quantidademax=" + quantidademax + ",quantidademin=" + quantidademin;
    }

    public ArrayList<Produto> getMinhaLista() {
        return dao.getMinhaLista();
    }

    public boolean insertProdutoBD(String produto, double preco, String unidade, String categoria, int quantidade, int quantidademax, int quantidademin) {
        int id = this.maiorID() + 1;
        Produto objeto = new Produto(id, produto, preco, unidade, categoria, quantidade, quantidademax, quantidademin);
        dao.insertProdutoBD(objeto);
        return true;
    }

    public boolean deleteProdutoBD(int id) {

        dao.deleteProdutoBD(id);
        return true;
    }

    public boolean updatePrecoBD(int id, int novoPreco) {
        return dao.updatePrecoBD(id, novoPreco);
    }

    public boolean updateProdutoBD(int id, String produto,
            double preco, String unidade, String categoria,
            int quantidade, int quantidademax, int quantidademin) {

        Produto objeto = new Produto(id, produto, preco, unidade,
                categoria, quantidade, quantidademax, quantidademin);

       
        return dao.updateProdutoBD(objeto);
    }

    public boolean updateQuantidadeBD(int id, int novaQuantidade) {
        return dao.updateQuantidadeBD(id, novaQuantidade);
    }

    public Produto carregaProduto(int id) {
        return dao.carregaProduto(id);
    }

    public int maiorID() {
        return dao.maiorID();
    }

    public boolean reajustarPrecos(double percentual) {
        try {
            ArrayList<Produto> produtos = getMinhaLista();

            for (Produto produto : produtos) {
                double precoAtual = produto.getPreco();
                int novoPreco = (int) Math.round(precoAtual * (1 + percentual / 100.0));
                produto.setPreco(novoPreco);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
