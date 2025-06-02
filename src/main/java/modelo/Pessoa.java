
package modelo;




public class Pessoa {
    private int id;
    private String produto;
    private int preco;
    private String unidade;

    public Pessoa() {
        this(0,"",0,"");
    }

    public Pessoa(int id, String produto, int preco, String unidade) {
        this.id = id;
        this.produto = produto;
        this.preco = preco;
        this.unidade = unidade;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    

   
    @Override
    public String toString(){
        return "id=" + id +", produto=" + produto + ",preco=" + preco + ",unidade=" + unidade;
    }
}
