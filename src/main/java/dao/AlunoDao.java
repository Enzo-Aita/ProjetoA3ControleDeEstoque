
package dao;
import java.util.ArrayList;
import modelo.Produto;

public class AlunoDao {
    public static ArrayList<Produto>minhaLista = new ArrayList<>();
    
    public static ArrayList<Produto>getMinhaLista(){
        return minhaLista;
    }
    public static void setMinhaLista(ArrayList<Produto>minhaLista){
        AlunoDao.minhaLista = minhaLista;
    }

    public static int maiorID(){
        int maiorID = 0;
        for(int i=0; i < minhaLista.size();i++){
            if(minhaLista.get(i).getId()>maiorID){
                maiorID = minhaLista.get(i).getId();
            }
        }
        return maiorID;
    }
    
}
