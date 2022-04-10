
package controller;

import connection.Connection;
import java.util.List;
import model.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author  grupo5- 2 ADSA
 */
public class ControllerLogin {
    Connection config = new Connection();
    
    JdbcTemplate connect = new JdbcTemplate(config.getBasicDataSource());
    
    public Boolean validationData(String email,String senha){
        Boolean dataValid = false;
        try{
        List<Usuario> getUser;
        getUser= connect.query("SELECT * FROM usuario WHERE email=? AND senha=?",
                new BeanPropertyRowMapper<>(Usuario.class),email,senha);
        if(!getUser.isEmpty()){
        dataValid= true;
        }
        
        }catch(Exception e){
            System.err.println(e);
        }
        return dataValid;
    }
    
}
