
package model;

import com.github.britooo.looca.api.group.sistema.Sistema;
import java.net.InetAddress;
import java.net.UnknownHostException;
import logs.Logs;
/**
 *
 * @author raylane
 */
public class ModelMaquinas {
    private Integer id;
    private String sistemaOp;
    private Integer fkMaquina;
    Logs logs = new Logs();
    Sistema sistema = new Sistema();

    public String getUsuario() {
     
        return System.getProperty("user.name");
    }

    public String getSistemaOperacional() {
       
        return sistema.getSistemaOperacional();
    }
    
    public String getHostName() throws UnknownHostException {
   
        return InetAddress.getLocalHost().getHostName();
    }

    public Integer getId() {
      
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSistemaOp(String sistemaOp) {
        this.sistemaOp = sistemaOp;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }


    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        logs.captarLogs("ModelComputadores{" + "id=" + id + ", sistemaOp=" + sistemaOp + ", sistema=" + sistema + '}');
        return "ModelComputadores{" + "id=" + id + ", sistemaOp=" + sistemaOp + ", sistema=" + sistema + '}';
    }

   

    
    

    

    
    
    
    
    
    
}
