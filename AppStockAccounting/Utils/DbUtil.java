package persaccounting.AppStockAccounting.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// TODO: consired suppression of the class
public class DbUtil {
    private static String connectionString;
    private static Connection con;

    static {
        Properties p = new Properties();        
        
        // D:\inet_technologies\PersAccounting\src\persaccounting\AppStockAccounting\Utils
        String path = "D:\\inet_technologies\\PersAccounting\\src\\persaccounting\\AppStockAccounting\\Utils";
        String javapath = path.replace("\\", "/");
        
        String file_last_name = "database.properties";
        String file_full_name = javapath + "/" + file_last_name;
        
        String home = System.getProperty("user.home"); // C:\Users\Olena
        System.out.println(home); // debug
        
        InputStream input = Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(file_full_name); // file_last_name
        try {
            p.load(input);
            input.close();
            connectionString = new StringBuilder()
                            .append(p.getProperty("dburl")).append("?user=")
                            .append(p.getProperty("user")).append("&login=")
                            .append(p.getProperty("login")).append("&useUnicode=")
                            .append(p.getProperty("useUnicode"))
                            .append("&characterEncoding=")
                            .append(p.getProperty("characterEncoding")).toString();
        } catch (IOException e) {
            System.out.println(input); // debug
            e.printStackTrace();
        }
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            createConnection();
        }
        return con;
    }
    
    // TODO: consider: usage cases
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
        }
    }
}
