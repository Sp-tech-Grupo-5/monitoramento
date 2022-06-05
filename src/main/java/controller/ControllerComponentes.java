/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.net.UnknownHostException;
import java.util.List;
import logs.Logs;
import model.ModelComponentes;
import model.ModelCpu;
import model.ModelDiscos;
import model.ModelMaquinas;
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
    ModelMaquinas modelComputadores = new ModelMaquinas();
    Logs logs = new Logs();
    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());

    String selectInfo = "SELECT maquina.id,maquina.sistemaOp FROM maquina WHERE maquina.hostname= ?";
    String selectValidFk = "SELECT componentes.fkMaquina FROM componentes JOIN maquina ON maquina.id=componentes.fkMaquina WHERE hostname=?";
    String insertComponentes = "INSERT INTO componentes(cpuCompPor,memoriaGb,discoGb,fkMaquina) VALUES (?,?,?,?)";
    String selectComponentes = "SELECT cpuCompPor,memoriaGb,discoGb FROM componentes WHERE fkMaquina=?";
    String updateComponentesCpu = "UPDATE componentes SET cpuCompPor=?,memoriaGb=?, discoGb=? WHERE fkMaquina=?";

    public void insertComponentes() throws UnknownHostException {

        List<ModelMaquinas> infoComputadores = template.query(selectInfo,
                new BeanPropertyRowMapper(ModelMaquinas.class),
                modelComputadores.getHostName());

        List<ModelMaquinas> infoFkComputador = template.query(selectValidFk,
                new BeanPropertyRowMapper(ModelMaquinas.class),
                modelComputadores.getHostName());

        List<ModelComponentes> validaComponentes = template.query(selectComponentes,
                new BeanPropertyRowMapper(ModelComponentes.class),
                infoComputadores.get(0).getId());

        if (!infoComputadores.isEmpty()) {
            if (infoFkComputador.isEmpty()) {
                System.out.println("RX-MONITORAMENTO : Computador já registrado no SQL Server");
                logs.captarLogs("   - Computador já registrado no SQL Server");
                template.update(insertComponentes,
                        modelCpu.getFrequencia(),
                        modelMemoria.getMemoriaTotal(),
                        modelDiscos.getTamanhoTotal(),
                        infoComputadores.get(0).getId());

                System.out.println("-".repeat(36) + "[RX-MONITORAMENTO]" + "-".repeat(36));
                System.out.println("Coletando e inserindo dados dos componentes da máquina");

            }

            if (!infoFkComputador.isEmpty()) {
                var componentes = validaComponentes.get(0);
                var condicaoCpu = componentes.getCpuCompPor() == modelCpu.getFrequencia();
                var condicaoMemoria = componentes.getMemoriaGb() == modelMemoria.getMemoriaTotal();
                var condicaoDiscos = componentes.getDiscoGb() == modelDiscos.getTamanhoTotal();

                if (!(condicaoCpu || condicaoMemoria || condicaoDiscos)) {
                    template.update(updateComponentesCpu,
                            modelCpu.getFrequencia(),
                            modelMemoria.getMemoriaTotal(),
                            modelDiscos.getTamanhoTotal(),
                            infoComputadores.get(0).getId());

                }

                System.out.println("-".repeat(36) + "[RX-MONITORAMENTO]" + "-".repeat(36));
                System.out.println("Componentes registrados e atualizados");

            }
            
        } else {

            System.out.println("-".repeat(36) + "[RX-MONITORAMENTO]" + "-".repeat(36));
            System.out.println("Computador não registrado. Entre em contato com o administrador!");
        }

    }
}
