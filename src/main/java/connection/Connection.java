/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author raylane
 */
public class Connection {
    private BasicDataSource dataSource;
        
    //Conexão
    public Connection(){
        dataSource= new  BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rxmonitoramento");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //criar usuario 
        
    }
    
    public BasicDataSource getBasicDataSource(){
        return dataSource; 
    }
    
}
