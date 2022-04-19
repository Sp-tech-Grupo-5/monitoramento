/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import services.ServiceMemoria;

/**
 *
 * @author raylane
 */
public class Teste {
    public static void main(String[] args) {
        ServiceMemoria serviceMemoria = new ServiceMemoria();
        ServiceDiscos serviceDiscos = new ServiceDiscos();
        
        //String emUso = String.format("%.2f GiB", serviceMemoria.getMemoriaEmUso());
        System.out.println(serviceDiscos.getEmUso());   

    }
}
