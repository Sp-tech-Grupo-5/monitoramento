/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.github.britooo.looca.api.group.processador.Processador;

/**
 *
 * @author raylane
 */
public class ModelCpu {
    private String nomeProcessador;
    private Integer cpuLogicas;
    private Integer cpuFisicas;
    private Double emUso;
    private Double frequencia;
    
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
    
    public Double getfrequencia (){
        Double frequencia = Double.valueOf(processador.getFrequencia());
        return frequencia;
    }
   
   
   
    
}
