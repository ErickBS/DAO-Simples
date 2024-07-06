/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarefa.pkg05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Erick Stella
 */
public class ConnectionFactory {
    
    private ConnectionFactory() {
    }
    
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/parks_and_recreation";
        String user = "root";
        String pwd = "admin";
        return DriverManager.getConnection(
            url, user, pwd);
    }
    
}
