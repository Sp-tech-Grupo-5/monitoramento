/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.github.britooo.looca.api.group.processador.Processador;

/**
 *
 * @author raylane
 */
public class ServiceCpu {
    private String nomeProcessador;
    private Integer cpuLogicas;
    private Integer cpuFisicas;
    private Double emUso;
    
   Processador processador = new Processador();

    public String getNomeProcessador() {
        return processador.getNome();
    }

    public Integer cpuLogicas(){
        return processador.getNumeroCpusLogicas();
    }

    public Integer cpuFisicas(){
        return processador.getNumeroCpusFisicas();
    }

    public Double emUso(){
        return processador.getUso();
    }
   
   
   
    
}
