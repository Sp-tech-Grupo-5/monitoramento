package model;

import com.github.britooo.looca.api.group.memoria.Memoria;
import logs.Logs;
/**
 *
 * @author raylane
 */
public class ModelMemoria extends NotifySlack{

    private Double memoriaTotal;
    private Memoria memoria;
    Logs logs = new Logs();
    public ModelMemoria() {
        super("Analista, há computadores com a memoria fritando :fire:");
        this.memoria = new Memoria(); 
        this.memoriaTotal = Double.valueOf(memoria.getTotal()/1000000000.0);
        
    }
    

    public Double getMemoriaTotal() {
        return memoriaTotal;
    }

    public Double getMemoriaEmUso() {
        Double memoriaUsoConvertida = Double.valueOf(memoria.getEmUso()/1000000000.0);
        Double percentMemory = (memoriaUsoConvertida * 100)/memoriaTotal;
        notifyIfNecessary(percentMemory);
        return memoriaUsoConvertida;
    }

    public Double getMemoriaDisponivel() {
        Double memoriaDisponivelConvertida = Double.valueOf(memoria.getDisponivel()/1000000000.0);
        return memoriaDisponivelConvertida;
    }
    


}
