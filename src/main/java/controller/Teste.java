/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import model.ModelComputadores;
import model.ModelCpu;
import model.ModelDiscos;
import model.ModelMemoria;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class Teste {
    public static void main(String[] args) throws UnknownHostException {
    ModelCpu modelCpu = new ModelCpu();
    ModelMemoria modelMemoria = new ModelMemoria();
    ModelDiscos modelDiscos = new ModelDiscos();
    ModelComputadores modelComputadores = new ModelComputadores();

    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());

    String selectInfo = "SELECT maquina.id,maquina.sistemaOp FROM maquina WHERE maquina.hostname= 'STFSAOC046710-L'";
    String selectValidFk = "SELECT componentes.fkMaquina FROM componentes JOIN maquina ON maquina.id=componentes.fkMaquina WHERE hostname='STFSAOC046710-L'";
   

        List<ModelComputadores> infoComputadores = template.query(selectInfo,
                new BeanPropertyRowMapper(ModelComputadores.class));
                //,modelComputadores.getHostName());

        List<ModelComputadores> infoFkComputador = template.query(selectValidFk,
                new BeanPropertyRowMapper(ModelComputadores.class));
                //,modelComputadores.getHostName());

        if (!infoComputadores.isEmpty()) {
                System.out.println("RX-MONITORAMENTO : Computador já registrado no SQL Server");
                System.out.println("-".repeat(72));
            if (infoFkComputador.isEmpty()) {
                System.out.println(infoFkComputador);
                
                System.out.println("INSERINDO OS DADOS EM COMPONENTES");
                
            } else {
                System.out.println("RX-MONITORAMENTO : Componentes já registrados");
            }
        } else {
            System.out.println("RX-MONITORAMENTO :Computador não registrado. Entre em contato com o administrador!");
        }
        
        
    }
    
    
}
