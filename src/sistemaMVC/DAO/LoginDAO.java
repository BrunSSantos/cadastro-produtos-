
package sistemaMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sistemaMVC.model.LoginModel;

/**
 *
 * @author norua
 */
public class LoginDAO {
    public List<LoginModel> listarLogin() throws ExceptionDAO{
         List<LoginModel> lista = new ArrayList<LoginModel>();
         
         
         String sql= "select* from tb_login";
         
         Connection connection = null;
         PreparedStatement pStatement = null;
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatement = connection.prepareStatement(sql);
             ResultSet rs = pStatement.executeQuery(sql);
             
           if(rs != null){
             
               while(rs.next()){
                   LoginModel l = new LoginModel();
                   l.setId(rs.getInt("tb_login_id"));
                   l.setEmail(rs.getString("tb_login_email"));
                   l.setSenha(rs.getString("tb_login_senha"));
                   lista.add(l);
               }
          }
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao listar login "+e);
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
    
    public boolean verificarLogin(String email, String senha) throws ExceptionDAO{
        Connection connection = null;
         PreparedStatement pStatement = null;
         ResultSet rs = null;
        boolean check = false;
         
         
         try {
             connection = new ConexaoBD().abrirConexao();
             pStatement = connection.prepareStatement("select * from tb_login where tb_login_email = ? and tb_login_senha = ?");
             pStatement.setString(1, email);
             pStatement.setString(2, senha);
             rs = pStatement.executeQuery();
             
           if(rs != null){
             
               if(rs.next()){
                   check = true;
                   
                   
               }
          }
         } catch (SQLException e) {
             throw new ExceptionDAO("Erro ao listar login "+e);
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
        
        return check;
    }
}
