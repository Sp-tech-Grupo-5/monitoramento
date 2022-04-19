
package services;

import com.github.britooo.looca.api.group.sistema.Sistema;

/**
 *
 * @author raylane
 */
public class ServiceSistema {
    private String usuario;
    private String sistemaOperacional;
    private Integer arquitetura;
    
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
    
    
    
}
