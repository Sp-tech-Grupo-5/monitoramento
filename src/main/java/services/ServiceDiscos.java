/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.discos.Volume;

/**
 *
 * @author raylane
 */
public class ServiceDiscos {

    private Double tamanhoTotal;
    private Double disponivel;
    private Double emUso;

    DiscosGroup discosGroup = new DiscosGroup();

    public Double getTamanhoTotal() {
        Double tamanhoTotal = Double.valueOf(discosGroup.getVolumes().get(0).getTotal());
        tamanhoTotal /= 1000000000;
        return tamanhoTotal;
    }

    public Double getDisponivel() {
        Double disponivel = Double.valueOf(discosGroup.getVolumes().get(0).getDisponivel());
        disponivel /= 1000000000;
        return disponivel;
    }

    public Double getEmUso() {
        Double emUso = this.getTamanhoTotal() - this.getDisponivel();
        return emUso;
    }
    
    

}
