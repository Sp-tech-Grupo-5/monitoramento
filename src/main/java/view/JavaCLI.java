/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControllerComponentes;
import controller.ControllerHistoricoComponente;
import controller.ControllerLogin;
import controller.ControllerProcessos;
import java.net.UnknownHostException;

/**
 *
 * @author raylane
 */
public class JavaCLI {
    public static void main(String[] args) throws UnknownHostException {
        
    ControllerHistoricoComponente controllerHistoricoComponente = new ControllerHistoricoComponente();
    ControllerProcessos controllerProcessos = new ControllerProcessos();
    ControllerComponentes controllerComponentes = new ControllerComponentes();
    
    
        String Email = "raylane@rxmonitoramento.com.br";
        String Senha = "grupo5";
        ControllerLogin validation = new ControllerLogin();

        if (validation.validationDataLogin(Email, Senha)) {
            System.out.println("Bem vindo ao RX-Monitoramento");        
            
           
                controllerHistoricoComponente.insertHistoricoComponentes();
                controllerProcessos.insertProcessos();
                controllerProcessos.insertProcessosMysql();
                controllerComponentes.insertComponentes();
                controllerComponentes.insertComponentesMysql();
                
           
        } else {
            
            System.out.println("Usuario invalido");
            
        }        
    }
}
