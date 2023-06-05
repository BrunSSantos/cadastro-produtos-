
package sistemaMVC.DAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import sistemaMVC.model.ProdutoModel;
import java.sql.ResultSet;
/**
 *
 * @author norua
 */
public class ProdutoDAO {
     public void cadastrarProduto(ProdutoModel produto) throws ExceptionDAO{
         String sql = "insert into  tb_produto(tb_produto_cod, tb_produto_statuss, tb_produto_nome, tb_produto_descricao, tb_produto_qtd_estoque, tb_produto_estoque_minimo,\n" +
" tb_produto_estoque_maximo, tb_produto_preco_compra, tb_produto_preco_venda, tb_produto_bar_code, tb_produto_ncm, tb_produto_fator, tb_produto_data_cadastro, tb_produto_imagem) \n" +
" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement pStatment = null;
         Connection connection = null;
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatment = connection.prepareStatement(sql);
             pStatment.setString(1, produto.getCod());
             pStatment.setString(2, produto.getStatus());
             pStatment.setString(3, produto.getNome());
             pStatment.setString(4, produto.getDescricao());
             pStatment.setInt(5, produto.getQtd_estoque());
             pStatment.setInt(6, produto.getEstoque_min());
             pStatment.setInt(7, produto.getEstoque_max());
             pStatment.setFloat(8, produto.getPreco_compra());
             pStatment.setFloat(9, produto.getPreco_venda());
             pStatment.setInt(10, produto.getBar_code());
             pStatment.setInt(11, produto.getNcm());
             pStatment.setDouble(12, produto.getFator());
             pStatment.setString(13, produto.getData_cadastro());
             pStatment.setString(14, produto.getImagem());
             pStatment.execute();
             
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao inserir dados no banco: "+e);
         }finally{
             try {
                 if(pStatment !=null){
                     pStatment.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar o Statment: "+e);
             }try {
                 if(connection != null){
                     connection.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar conexao: "+e);
             }
         }
     }
     
     public List<ProdutoModel> listarProdutos() throws ExceptionDAO{
         List<ProdutoModel> lista = new ArrayList<ProdutoModel>();
         
         
         String sql= "select* from tb_produto";
         
         Connection connection = null;
         PreparedStatement pStatement = null;
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatement = connection.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery(sql);
             
           if(rs != null){
             
               while(rs.next()){
                   ProdutoModel p = new ProdutoModel();
                   p.setId(rs.getInt("tb_produto_id"));
                   p.setCod(rs.getString("tb_produto_cod"));
                   p.setStatus(rs.getString("tb_produto_statuss"));
                   p.setNome(rs.getString("tb_produto_nome"));
                   p.setDescricao(rs.getString("tb_produto_descricao"));
                   p.setQtd_estoque(rs.getInt("tb_produto_qtd_estoque"));
                   p.setEstoque_min(rs.getInt("tb_produto_estoque_minimo"));
                   p.setEstoque_max(rs.getInt("tb_produto_estoque_maximo"));
                   p.setPreco_compra(rs.getFloat("tb_produto_preco_compra"));
                   p.setPreco_venda(rs.getFloat("tb_produto_preco_venda"));
                   p.setBar_code(rs.getInt("tb_produto_bar_code"));
                   p.setNcm(rs.getInt("tb_produto_ncm"));
                   p.setFator(rs.getFloat("tb_produto_fator"));
                   p.setData_cadastro(rs.getString("tb_produto_data_cadastro"));
                   p.setImagem(rs.getString("tb_produto_imagem"));
                   lista.add(p);
                  
               }
          }
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao listar produtos "+e);
         }finally{
             try {
                 if(pStatement!=null){
                     pStatement.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar o Statment "+e);
             }
             
             try {
                 if(connection!=null){
                     connection.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar a conexao "+e);
             }
         }
         
         return lista;
     }
     
     public void alterarProduto(ProdutoModel produto) throws ExceptionDAO{
         String sql = "update tb_produto set tb_produto_cod=?, tb_produto_statuss=?, tb_produto_nome=?, tb_produto_descricao=?, tb_produto_qtd_estoque=?, tb_produto_estoque_minimo=?,\n" +
" tb_produto_estoque_maximo=?, tb_produto_preco_compra=?, tb_produto_preco_venda=?, tb_produto_bar_code=?, tb_produto_ncm=?, tb_produto_fator=?, tb_produto_data_cadastro=?, tb_produto_imagem=?"
                 + "where tb_produto_id=?";
         PreparedStatement pStatment = null;
         Connection connection = null;
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatment = connection.prepareStatement(sql);
             pStatment.setString(1, produto.getCod());
             pStatment.setString(2, produto.getStatus());
             pStatment.setString(3, produto.getNome());
             pStatment.setString(4, produto.getDescricao());
             pStatment.setInt(5, produto.getQtd_estoque());
             pStatment.setInt(6, produto.getEstoque_min());
             pStatment.setInt(7, produto.getEstoque_max());
             pStatment.setFloat(8, produto.getPreco_compra());
             pStatment.setFloat(9, produto.getPreco_venda());
             pStatment.setInt(10, produto.getBar_code());
             pStatment.setInt(11, produto.getNcm());
             pStatment.setDouble(12, produto.getFator());
             pStatment.setString(13, produto.getData_cadastro());
             pStatment.setString(14, produto.getImagem());
             pStatment.setInt(15, produto.getId());
             pStatment.execute();
             
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao inserir dados no banco: "+e);
         }finally{
             try {
                 if(pStatment !=null){
                     pStatment.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar o Statment: "+e);
             }try {
                 if(connection != null){
                     connection.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar conexao: "+e);
             }
         }
     }
     
     public void excluirProduto(ProdutoModel produto) throws ExceptionDAO{
         String sql = "delete from tb_produto where tb_produto_id=?";
         PreparedStatement pStatment = null;
         Connection connection = null;
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatment = connection.prepareStatement(sql);
             pStatment.setInt(1, produto.getId());
             pStatment.execute();
             
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao inserir dados no banco: "+e);
         }finally{
             try {
                 if(pStatment !=null){
                     pStatment.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar o Statment: "+e);
             }try {
                 if(connection != null){
                     connection.close();
                 }
             } catch (SQLException e) {
                 throw new ExceptionDAO("Erro ao fechar conexao: "+e);
             }
         }
     }
}
