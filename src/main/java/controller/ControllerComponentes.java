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
public class ControllerComponentes {

    ModelCpu modelCpu = new ModelCpu();
    ModelMemoria modelMemoria = new ModelMemoria();
    ModelDiscos modelDiscos = new ModelDiscos();
    ModelComputadores modelComputadores = new ModelComputadores();

    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());

    public void insertComponentes() throws UnknownHostException {
        List<ModelComputadores> infoComputadores;
        infoComputadores = template.query("SELECT * FROM maquina WHERE hostname=?",
                new BeanPropertyRowMapper<>(ModelComputadores.class),
                modelComputadores.getHostName());
        

        if (infoComputadores.isEmpty()) {
            template.update("INSERT INTO componentes(cpuCompPor,memoriaGb,discoGb) values (?,?,?)",
                    modelCpu.getfrequencia(),
                    modelMemoria.getMemoriaTotal(),
                    modelDiscos.getTamanhoTotal());
            
            template.update("INSERT INTO maquina(sistemaOp,hostname) values (?,?)",
                    modelComputadores.getSistemaOperacional(),
                    modelComputadores.getHostName());

            System.out.println("-".repeat(72));
            System.out.println("RX-MONITORAMENTO : Executando Controller Componentes. \n"
                    + "Coletando e inserindo dados dos componentes da máquina");

        } else {

            System.out.println("RX-MONITORAMENTO : Computador já registrado");
        }

    }

}
