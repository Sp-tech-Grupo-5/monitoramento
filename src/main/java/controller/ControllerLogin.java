/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import model.ModelComputadores;
import model.ModelUsuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class ControllerLogin {

    ControllerUsuarioMaquina usuarioMaquina = new ControllerUsuarioMaquina();
    ModelComputadores serviceComputadores = new ModelComputadores();

    Connection config = new Connection();
    JdbcTemplate connect = new JdbcTemplate(config.getBasicDataSource());

    Boolean mysql = true;
    Connection configMysql = new Connection(mysql);
    JdbcTemplate connectMysql = new JdbcTemplate(configMysql.getBasicDataSource());
    

    public Boolean validationDataLogin(String email, String senha) {
        Boolean dataValid = false;
        try {
            List<ModelUsuario> getUser;
            getUser = connect.query("SELECT id,nome,email,senha FROM usuario WHERE email=? AND senha=?",
                    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);
            
            List<ModelUsuario> getUserMysql;
            getUserMysql = connectMysql.query("SELECT * FROM usuario WHERE email=? AND senha=?",
                    new BeanPropertyRowMapper<>(ModelUsuario.class), email, senha);
            
            if (!getUser.isEmpty() && !getUserMysql.isEmpty()) {
                dataValid = true;
                usuarioMaquina.insertUsuarioMaquinaLogin(getUser);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return dataValid;
    }

    public Boolean validationDataLogout() throws UnknownHostException {
        String selectIdMaquina = "select maquina.id from maquina where hostname=?";
        
        List<ModelUsuario> getIdMaquina;
        getIdMaquina = connect.query(selectIdMaquina,
                new BeanPropertyRowMapper<>(ModelUsuario.class),
                serviceComputadores.getHostName());
            
        List<ModelUsuario> getUsuarioMaquina;
        getUsuarioMaquina = connect.query("select fkMaquina, estado from usuarioMaquina where estado=1 and fKMaquina=?;",
                new BeanPropertyRowMapper<>(ModelUsuario.class),
                getIdMaquina.get(0).getId());
        
        
        if(getUsuarioMaquina.size() == 1){
            return true;
        }
        
        return false;

    }

}
