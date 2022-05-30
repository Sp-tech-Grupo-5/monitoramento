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
public class ModelDiscos extends Model {

    private Double tamanhoTotal;
    private Double disponivel;
    private Double emUso;
    private DiscosGroup discosGroup ;

    public ModelDiscos() {
        super("disco lotando");
        this.discosGroup = new DiscosGroup();
        this.tamanhoTotal = (Double.valueOf(discosGroup.getVolumes()
                                                       .get(0)
                                                       .getTotal()))/1000000000;
    }
    

    public Double getTamanhoTotal() {
        return tamanhoTotal;
    }

    public Double getEmUso() {
        Double emUso = Double.valueOf(discosGroup.getVolumes().get(0).getDisponivel());
        Double percentDisco = (emUso * 100)/tamanhoTotal;
        notifyIfNecessary(percentDisco);
        return emUso /= 1000000000;
    }

    public Double getDisponivel() {
        Double disponivel = this.getTamanhoTotal() - this.getEmUso();
        return disponivel;
    }
    

}
