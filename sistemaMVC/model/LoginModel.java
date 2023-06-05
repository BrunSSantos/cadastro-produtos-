
package sistemaMVC.model;

import java.util.List;
import sistemaMVC.DAO.ExceptionDAO;
import sistemaMVC.DAO.LoginDAO;


/**
 *
 * @author norua
 */
public class LoginModel {
    private int id;
    private String email;
    private String senha;

    
     public LoginModel(){
         
     }
    
    public LoginModel(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<LoginModel> listarLogin() throws ExceptionDAO{
        return new LoginDAO().listarLogin();
    }
    
    public void verificarLogin()throws ExceptionDAO{
        
    }
}
