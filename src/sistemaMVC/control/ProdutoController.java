
package sistemaMVC.control;

import java.util.Date;
import java.util.List;
import sistemaMVC.DAO.ExceptionDAO;
import sistemaMVC.model.ProdutoModel;
/**
 *
 * @author norua
 */
public class ProdutoController {
    public boolean cadastrarProduto(String cod, String status, String nome, String descricao, int qtd_estoque, 
            int estoque_min, int estoque_max, float preco_compra, float preco_venda,
            int bar_code, int ncm, float fator, String data_cadastro, String imagem) throws ExceptionDAO{
        
      ProdutoModel produto = new ProdutoModel(cod, status, nome, descricao, qtd_estoque, estoque_min, estoque_max, preco_compra, preco_venda, bar_code, ncm, fator, data_cadastro, imagem);
      produto.cadastrarProduto(produto);
      
      return true;
        
    }
    public List<ProdutoModel> listarProdutos() throws ExceptionDAO{
        return new ProdutoModel().listarProdutos();
    }
    
    public boolean alterarProduto(int id, String cod, String status, String nome, String descricao, int qtd_estoque, 
            int estoque_min, int estoque_max, float preco_compra, float preco_venda,
            int bar_code, int ncm, float fator, String data_cadastro, String imagem) throws ExceptionDAO{
        
      ProdutoModel produto = new ProdutoModel(cod, status, nome, descricao, qtd_estoque, estoque_min, estoque_max, preco_compra, preco_venda, bar_code, ncm, fator, data_cadastro, imagem);
      produto.setId(id);
      produto.alterarProduto(produto);
      
      return true;
        
    }
    
    
     public boolean excluirProduto(int id) throws ExceptionDAO{
         ProdutoModel produto = new ProdutoModel();
         produto.setId(id);
         produto.excluirProduto(produto);
      
      return true;
        
    }
    
}
