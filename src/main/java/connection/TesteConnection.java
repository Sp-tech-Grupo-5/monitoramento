/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author raylane
 */
public class TesteConnection {
    public static void main(String[] args) {
        Connection conexao = new Connection();
        
        JdbcTemplate template = new JdbcTemplate(conexao.getBasicDataSource());
        
        template.execute("INSERT into Usuario VALUES (null,'Admin',"
                + "'admin@rxmonitoramento.com',"
                + "'admin123',"
                + "null)");
        
        List select = template.queryForList("SELECT * from Usuario");
        System.out.println(select);
        
        
    }
    
}
