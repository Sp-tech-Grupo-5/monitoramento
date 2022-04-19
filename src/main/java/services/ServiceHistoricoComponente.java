/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.Connection;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class ServiceHistoricoComponente {

    ServiceCpu serviceCpu = new ServiceCpu();
    ServiceMemoria serviceMemoria = new ServiceMemoria();
    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());

    public void insertHistoricoComponentes() {
        Timer timer = new Timer();
        Integer delay = 5000;
        Integer interval = 10000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                template.update("INSERT INTO historicoComponente(cpuHist,memoriaHist,dataHora) values (?,?,now())",
                        serviceCpu.emUso(), serviceMemoria.getMemoriaEmUso());
            }
        }, delay, interval);
    }

}
