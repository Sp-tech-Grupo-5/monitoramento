
package connection;

import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author  grupo5- 2 ADSA
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
