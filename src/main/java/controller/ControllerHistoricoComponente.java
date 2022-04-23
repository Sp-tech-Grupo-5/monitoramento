/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import model.ModelCpu;
import model.ModelMemoria;

/**
 *
 * @author raylane
 */
public class ControllerHistoricoComponente {

    ModelCpu serviceCpu = new ModelCpu();
    ModelMemoria serviceMemoria = new ModelMemoria();
    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());
    
    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");

    public void insertHistoricoComponentes() {
        Timer timer = new Timer();
        Integer delay = 5000;
        Integer interval = 10000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                template.update("INSERT INTO historicoComponente(cpuHist,memoriaHist,dataHora) values (?,?,?)",
                        serviceCpu.emUso(),
                        serviceMemoria.getMemoriaEmUso(),
                        dateFormat.format(date));
                
                System.out.println("-".repeat(72));
            System.out.println("RX-MONITORAMENTO : Executando Controller Historico Componentes. \n"
                    + "Coletando e inserindo dados em tempo real dos componentes da máquina");
            }
        }, delay, interval);
    }

}
