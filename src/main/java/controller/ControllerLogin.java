/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.util.List;
import model.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class ControllerLogin {
    Connection config = new Connection();
    
    JdbcTemplate connect = new JdbcTemplate(config.getBasicDataSource());
    
    public Boolean validationData(String email,String senha){
        Boolean dataValid = false;
        try{
        List<Usuario> getUser;
        getUser= connect.query("SELECT * FROM Usuario WHERE email=? AND senha=?",
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
