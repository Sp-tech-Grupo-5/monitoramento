
package model;

import com.github.britooo.looca.api.group.sistema.Sistema;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author raylane
 */
public class ModelComputadores {
    private String usuario;
    private String sistemaOperacional;
    private Integer arquitetura;
    private String ip;
    private String hostName;
    
    Sistema sistema = new Sistema();

    public String getUsuario() {
        return System.getProperty("user.name");
    }

    public String getSistemaOperacional() {
        return sistema.getSistemaOperacional();
    }

    public Integer getArquitetura() {
        return sistema.getArquitetura();
    }
    
    public String getIp() throws UnknownHostException{
        return InetAddress.getLocalHost().getHostAddress();
    }

    public String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
    
    
    
}
