    
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Produto;

public class ProdutoDao {
    public static ArrayList<Produto>minhaLista = new ArrayList<>();
    
    public ArrayList<Produto>getMinhaLista(){
        
        minhaLista.clear();
        
        try{
            Statement stmt = this.getConexao().createStatement();
            
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos");
            while(res.next()){
                
                int id = res.getInt("id");
                String produto = res.getString("produto");
                int preco = res.getInt("preco");
                String categoria = res.getString("categoria");
                int quantidade = res.getInt("quantidade");
                int quantidademax = res.getInt("quantidademax");
                int quantidademin = res.getInt("quantidademin");
                
                Produto objeto = new Produto(id,produto,preco,categoria,quantidade,quantidademax,quantidademin);
                minhaLista.add(objeto); 
            }
           stmt.close();
           
        }catch (SQLException ex){   
            System.out.println("Erro:" + ex);
            
        }
        
        return minhaLista;
    }
    public static void setMinhaLista(ArrayList<Produto>minhaLista){
        ProdutoDao.minhaLista = minhaLista;
}
    public  int maiorID(){
        int maiorID = 0;
        
        try{
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produtos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
            }catch (SQLException ex){
                System.out.println("Erro:" +ex);
        }
        return maiorID;
    }
    
    
    public Connection getConexao(){
        Connection connection = null;
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            
            String server = "localhost";
            String database = "db_produtos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "andreas030107";
            
            connection = DriverManager.getConnection(url,user,password);
            
            if(connection != null) {
                System.out.println("Status: Conectado!");
                
            }else{
                System.out.println("Status: NÃO CONECTADO!");
            }
            return connection;
        }catch (ClassNotFoundException e){
            System.out.println("O driver nao foi encontrado.");
            return null;
        }catch (SQLException e){
            System.out.println("Não foi possivel conectar...");
            return null;
        }
                
    }
    
    public boolean insertProdutoBD(Produto objeto){
        
        String sql = "INSERT INTO tb_produtos(id,produto,preco,categoria,quantidade,quantidademax,quantidademin) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getProduto());
            stmt.setDouble(3, objeto.getPreco());
            stmt.setString(4, objeto.getCategoria());
            stmt.setInt(5, objeto.getQuantidade());
            stmt.setInt(6, objeto.getQuantidademax());
            stmt.setInt(7, objeto.getQuantidademin());
            
            stmt.execute();
            stmt.close();
            
            return true;
        }catch (SQLException erro){
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    
    public boolean deleteProdutoBD(int id){
        try{
            Statement stmt = this.getConexao().createStatement();
            
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id =" +id);
            
            stmt.close();
        }catch (SQLException erro){
            System.out.println("Erro:" +erro);
        }
        return true;
    }
    public boolean updateProdutoBD(Produto objeto){
        String sql = "UPDATE tb_produtos set produto = ? ,preco =? ,categoria =? ,quantidade =? ,quantidademax =? ,quantidademin =? WHERE id = ?";
        
        try{
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            
            stmt.setString(1, objeto.getProduto());
            stmt.setDouble(2, objeto.getPreco());
            stmt.setString(3, objeto.getCategoria());
            stmt.setInt(4, objeto.getQuantidade());
            stmt.setInt(5, objeto.getQuantidademax());
            stmt.setInt(6, objeto.getQuantidademin());
            
            stmt.execute();
            stmt.close();
            
            return true;
        }catch (SQLException erro){
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    

    public Produto carregaProduto(int id){
        Produto objeto = new Produto();
        objeto.setId(id);
        try{
            Statement stmt = this.getConexao().createStatement();
            
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id =" +id);
            res.next();
            
            objeto.setProduto(res.getString("produto"));
            objeto.setPreco(res.getInt("preco"));
            objeto.setCategoria(res.getString("categoria"));
            objeto.setQuantidade(res.getInt("quantidade"));
            objeto.setQuantidademax(res.getInt("quantidademax"));
            objeto.setQuantidademin(res.getInt("quantidademin"));
            
            stmt.close(); 
        }catch (SQLException erro){
            System.out.println("Erro:" +erro);
        }
        return objeto;
    }
    
    }
    

