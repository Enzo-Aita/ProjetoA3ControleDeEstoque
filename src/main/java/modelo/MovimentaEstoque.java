package modelo;

import dao.ProdutoDao;
import dao.MovimentaDao;
import java.util.List;
import java.util.Map;

public class MovimentaEstoque {
    
    private final ProdutoDao produtoDao;
    private final MovimentaDao movimentaDao;
    
    
    private int limiteEntrada = 150;
    private int limiteSaida = 25;
    
    public MovimentaEstoque() {
        this.produtoDao = new ProdutoDao();
        this.movimentaDao = new MovimentaDao();
    }
    
    
    public MovimentaEstoque(int limiteEntrada, int limiteSaida) {
        this();
        this.limiteEntrada = limiteEntrada;
        this.limiteSaida = limiteSaida;
    }
    
   
    public String movimentarEstoque(int id, int quantidade, boolean adicionar, String observacao) {
       
        if (quantidade <= 0) {
            return "Erro: Quantidade deve ser maior que zero.";
        }
        
        Produto produto = produtoDao.carregaProduto(id);
        if (produto == null) {
            return "Erro: Produto não encontrado.";
        }
        
       
        if (adicionar && quantidade > limiteEntrada) {
            return String.format("Erro: Quantidade de entrada excede o limite de %d unidades.", limiteEntrada);
        }
        
        if (!adicionar && quantidade > limiteSaida) {
            return String.format("Erro: Quantidade de saída excede o limite de %d unidades.", limiteSaida);
        }
        
       
        int novaQuantidade = adicionar ? 
                produto.getQuantidade() + quantidade : 
                produto.getQuantidade() - quantidade;
        
        if (novaQuantidade < 0) {
            return "Erro: Estoque insuficiente para esta saída.";
        }
        
       
        boolean estoqueAtualizado = produtoDao.updateQuantidadeBD(id, novaQuantidade);
        if (!estoqueAtualizado) {
            return "Erro: Falha ao atualizar estoque do produto.";
        }
        
       
        String tipo = adicionar ? "ENTRADA" : "SAÍDA";
        boolean movimentacaoRegistrada = movimentaDao.registrarMovimentacao(
                id, quantidade, tipo, observacao);
        
        if (!movimentacaoRegistrada) {
            return "Operação concluída com aviso: Estoque atualizado, mas histórico não registrado.";
        }
        
       
        produto.setQuantidade(novaQuantidade);
        
        if (!adicionar && novaQuantidade < produto.getQuantidademin()) {
            return "Operação concluída. ATENÇÃO: Estoque abaixo do mínimo (" + produto.getQuantidademin() + " unidades).";
        }
        
        if (adicionar && novaQuantidade > produto.getQuantidademax()) {
            return "Operação concluída. ATENÇÃO: Estoque acima do máximo (" + produto.getQuantidademax() + " unidades).";
        }
        
        return "Movimentação registrada com sucesso.";
    }
    
    
    public List<Map<String, Object>> getHistoricoPorProduto(int idProduto) {
        return movimentaDao.getHistoricoPorProduto(idProduto);
    }
    
    
    public List<Map<String, Object>> getTodasMovimentacoes() {
        return movimentaDao.getTodasMovimentacoes();
    }
    
    public int getLimiteEntrada() {
        return limiteEntrada;
    }
    
    public int getLimiteSaida() {
        return limiteSaida;
    }
    
    public void setLimiteEntrada(int limiteEntrada) {
        this.limiteEntrada = limiteEntrada;
    }
    
    public void setLimiteSaida(int limiteSaida) {
        this.limiteSaida = limiteSaida;
    }
}