package services;

import com.github.britooo.looca.api.group.memoria.Memoria;

/**
 *
 * @author raylane
 */
public class ServiceMemoria {

    private Double memoriaTotal;
    private Double memoriaEmUso;
    private Double memoriaDisponivel;

    Memoria memoria = new Memoria();

    public Double getMemoriaTotal() {
        Double memoriaTotalConvertida = Double.valueOf(memoria.getTotal()/1000000000.0);
        return memoriaTotalConvertida;
    }

    public Double getMemoriaEmUso() {
        Double memoriaUsoConvertida = Double.valueOf(memoria.getEmUso()/1000000000.0);
        return memoriaUsoConvertida;
    }

    public Double getMemoriaDisponivel() {
        Double memoriaDisponivelConvertida = Double.valueOf(memoria.getDisponivel()/1000000000.0);
        return memoriaDisponivelConvertida;
    }

}
