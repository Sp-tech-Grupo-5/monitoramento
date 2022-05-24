
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
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://projeto-rxmonitoramento.database.windows.net:1433;"
                + "database=bd-grupo5-rxmonitoramento;"
                + "user=admin-rxmonitoramento@projeto-rxmonitoramento;"
                + "password={2ads@grupo5};"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("admin-rxmonitoramento");
        dataSource.setPassword("2ads@grupo5");
        
    }
      public Connection(Boolean mysql){
        dataSource= new  BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.20.20.4/rxmonitoramento");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        
    }
    
    public BasicDataSource getBasicDataSource(){
        return dataSource; 
    }
    
}
