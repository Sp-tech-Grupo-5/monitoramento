/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.util.List;
import model.ModelUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import logs.Logs;
/**
 *
 * @author raylane
 */
public class ControllerLogin {

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getBasicDataSource());
    
    ControllerUsuarioMaquina usuarioMaquina = new ControllerUsuarioMaquina();
    Logs logs = new Logs();
    
    
    public Boolean validationDataLogin(String email, String senha) {
        Boolean dataValid = false;
        try {
            List<ModelUsuario> getUser;
                getUser = connect.query("SELECT * FROM usuario WHERE email=? AND senha=?",
                        new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);
                if (!getUser.isEmpty()) {
                    dataValid = true;
                    usuarioMaquina.insertUsuarioMaquinaLogin(getUser);
                    logs.captarLogs("    - Login efetuado com sucesso!");
                }
                
        } catch (Exception e) {
            System.err.println(e);
            logs.captarLogs("   - Erro ao efetuar o login!");
        }
        return dataValid;
    }

}
