package DBPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;


public class DataBaseProvider{
	
	public static Connection conn = null;
	
	private static DataBaseProvider _instance = new DataBaseProvider();
	
	private String uri = null;
	private String login = null;
	private String pass = null;
	
	//constructor
	private DataBaseProvider(){
		InitConnection();
	}
	
	private void InitConnection()	{
		try{
			LoadDbConfig();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loading success!");
	        }
	        catch (ClassNotFoundException e) {
	           System.err.println (e) ;
	           System.exit (-1) ;
	        }
            
			String url = "jdbc:mysql://localhost/";
			conn = DriverManager.getConnection(url,"alexoander","12345D");
			// create a statement
			Statement statement = conn.createStatement();
			boolean res = statement.execute("Select * from fmdat.customer");
			if (res)
				System.out.println("Connected to fmdat");
			else
				System.out.println("Something wrong! Check SQL connect");
		}
		catch(java.sql.SQLException e)
		{
			e.printStackTrace();
			System.out.println("Connect to MySql failed!");
			System.exit (-1) ;
		}
	}
	
	public static DataBaseProvider GetInstance()
    {
        return _instance;
    }
	
	private void LoadDbConfig()	{
		FileInputStream fis;
        Properties property = new Properties();
 
        try {
            fis = new FileInputStream("src/config.cfg");
            // load config.sys from stream
            property.load(fis);
 
            uri = property.getProperty("db.uri");
            login = property.getProperty("db.login");
            pass = property.getProperty("db.password");
 
            System.out.println("CHECK->HOST: " + uri
                            + ", LOGIN: " + login
                            + ", PASSWORD: " + pass);
 
        } catch (IOException e) {
            System.err.println("������: ���� config.sys ���������� ��� ��� ���������� �������!");
        }
	}
	
	@Override
    protected void finalize() throws Throwable
    {
        //close connection when exit application
		conn.close();
        super.finalize();
    }
}