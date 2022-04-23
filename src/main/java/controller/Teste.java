/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author raylane
 */
public class Teste {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("HOST NAME: " + InetAddress.getLocalHost().getHostName());
        System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
    }
    
}
