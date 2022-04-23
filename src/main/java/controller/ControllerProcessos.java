/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import connection.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class ControllerProcessos {

    Connection connection = new Connection();
    JdbcTemplate template = new JdbcTemplate(connection.getBasicDataSource());
    ProcessosGroup processos = new ProcessosGroup();

    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");

    public void insertProcessos() {
        Timer timer = new Timer();
        Integer delay = 5000;
        Integer interval = 30000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-".repeat(72));
            System.out.println("RX-MONITORAMENTO : Executando Controller Processos. \n"
                    + "Coletando e inserindo dados dos processos");
                Date date = new Date();
                
                for (int i = 0; i < processos.getProcessos().size(); i++) {
                    template.update("INSERT INTO processos(nomeProcesso,cpuHist,memoria,dataHora)"
                            + "values (?,?,?,?)",
                            processos.getProcessos().get(i).getNome(),
                            processos.getProcessos().get(i).getUsoCpu(),
                            processos.getProcessos().get(i).getUsoMemoria(),
                            dateFormat.format(date));

                }

            }
        }, delay, interval);
    }

}
