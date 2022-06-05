/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import connection.Connection;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import model.ModelMaquinas;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import logs.Logs;
/**
 *
 * @author raylane
 */
public class ControllerProcessos {

    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());
    ProcessosGroup processos = new ProcessosGroup();
    ModelMaquinas serviceComputadores= new ModelMaquinas();
    Logs logs = new Logs();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String selectIdComponentes = "select componentes.id from componentes join maquina on maquina.id=componentes.fkmaquina where maquina.hostname=?";

    public void insertProcessos() throws UnknownHostException {
          List<ModelMaquinas> getIdComponentes = template.query(selectIdComponentes,
                new BeanPropertyRowMapper(ModelMaquinas.class),
                serviceComputadores.getHostName());
                logs.captarLogs(String.format("    - Coletando o hostname da máquina: %s", serviceComputadores.getHostName()));
               
        Timer timer = new Timer();
        Integer delay = 5000;
        Integer interval = 60000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-".repeat(36) + "[RX-MONITORAMENTO]" + "-".repeat(36));
                System.out.println("Coletando e inserindo dados dos processos");
                Date date = new Date();
                
                Integer IdComponentes = getIdComponentes.get(0).getId();
                
                for (int i = 0; i < processos.getProcessos().size(); i++) {
                     
                        template.update("INSERT INTO processos(nomeProcesso,cpuHist,memoria,dataHora,fkComponentes)"
                                + "values (?,?,?,?,?)",
                                processos.getProcessos().get(i).getNome(),
                                processos.getProcessos().get(i).getUsoCpu(),
                                processos.getProcessos().get(i).getUsoMemoria(),
                                dateFormat.format(date),
                                IdComponentes);
                                
                  logs.captarLogs(String.format("    - Registrando processos de uso da cpu: %.2f", processos.getProcessos().get(i).getUsoCpu()));
                  logs.captarLogs(String.format("    - Registrando processos de uso da memória: %.2f", processos.getProcessos().get(i).getUsoMemoria()));
                  logs.captarLogs(String.format("    - Coletando o nome de usuário: %s", serviceComputadores.getUsuario()));
                  
                    }

            }
        }, delay, interval);
    }
    
}
