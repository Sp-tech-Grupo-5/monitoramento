/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;

/**
 *
 * @author raylane
 */
public class ModelDiscos {

    private Double tamanhoTotal;
    private Double disponivel;
    private Double emUso;

    DiscosGroup discosGroup = new DiscosGroup();

    public Double getTamanhoTotal() {
        Double tamanhoTotal = Double.valueOf(discosGroup.getVolumes().get(0).getTotal());
        tamanhoTotal /= 1000000000;
        return tamanhoTotal;
    }

    public Double getEmUso() {
        Double emUso = Double.valueOf(discosGroup.getVolumes().get(0).getDisponivel());
        emUso /= 1000000000;
        return emUso;
    }

    public Double getDisponivel() {
        Double disponivel = this.getTamanhoTotal() - this.getEmUso();
        return disponivel;
    }
    
    

}
