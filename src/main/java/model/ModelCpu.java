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
public class ModelCpu extends Model{
    
    private Double emUso;
    private Double frequencia;
    private Processador processador;

    public ModelCpu() {
        super("cpu fritando");
        this.processador = new Processador();
        this.frequencia = Double.valueOf(processador.getFrequencia());
    }
    
    public Double emUso(){
        this.emUso = processador.getUso();
        this.notifyIfNecessary(emUso);
        return emUso;
    }
    
    public Double getfrequencia (){
        return frequencia;
    }
}
