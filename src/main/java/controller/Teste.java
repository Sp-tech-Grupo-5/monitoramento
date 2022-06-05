/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import com.github.britooo.looca.api.group.processador.Processador;
import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import model.ModelComponentes;
import model.ModelMaquinas;
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
    ModelMaquinas modelComputadores = new ModelMaquinas();

    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());

    String selectInfo = "SELECT maquina.id,maquina.sistemaOp FROM maquina WHERE maquina.hostname= ?";
    String selectValidFk = "SELECT componentes.fkMaquina FROM componentes JOIN maquina ON maquina.id=componentes.fkMaquina WHERE hostname=?";
    String insertComponentes = "INSERT INTO componentes(cpuCompPor,memoriaGb,discoGb,fkMaquina) VALUES (?,?,?,?)";
    String selectComponentes = "SELECT cpuCompPor,memoriaGb,discoGb FROM componentes WHERE fkMaquina=?";
    String updateComponentesCpu = "UPDATE componentes SET cpuCompPor=?,memoriaGb=?, discoGb=? WHERE fkMaquina=?";
    

   
            List<ModelMaquinas> infoComputadores;
            infoComputadores = template.query(selectInfo,
                    new BeanPropertyRowMapper(ModelMaquinas.class),
                    modelComputadores.getHostName());

            List<ModelMaquinas> infoFkComputador = template.query(selectValidFk,
                    new BeanPropertyRowMapper(ModelMaquinas.class),
                    modelComputadores.getHostName());
            
            List<ModelComponentes> validaComponentes = template.query(selectValidFk,
                    new BeanPropertyRowMapper(ModelComponentes.class),
                    infoComputadores.get(0).getId());
            
            
    }
}
