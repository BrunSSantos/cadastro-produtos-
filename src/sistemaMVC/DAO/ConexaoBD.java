package sistemaMVC.DAO;

/**
 *
 * @author Bruno de Souza Santos
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBD {
Connection con = null;

    public Connection abrirConexao() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o driver sql: "+e);
            
        }
        //Usar o banco(bdprojetoproduto.sql) que está na pasta sistemaMVC 
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdprojetoproduto?useSSL=false",
                    "root",
                    "root");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexao sql: "+e);
          
        }

        return con;
    }
    
    public Connection fecharConexao(){
        try {
            this.con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao sql: "+e);
        }
        
        
        return con;
    }
}
