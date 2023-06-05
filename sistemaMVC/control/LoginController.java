
package sistemaMVC.control;

import java.util.List;
import sistemaMVC.DAO.ExceptionDAO;
import sistemaMVC.model.LoginModel;

/**
 *
 * @author norua
 */
public class LoginController {
    public List<LoginModel> listarLogin() throws ExceptionDAO{
        return new LoginModel().listarLogin();
    }
    
    public boolean verificarLogin(String email, String senha) throws ExceptionDAO{
        
        
        LoginModel login = new LoginModel();
        String em = login.getEmail();
        String sen = login.getSenha();
        if(email == em && senha == sen){
            return true;
        }
        return false;
        
        
    }
}
