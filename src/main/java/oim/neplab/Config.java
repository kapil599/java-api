package oim.neplab;

//import com.thortech.util.logging.Logger;
import oracle.iam.platform.OIMClient;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class Config {
    //    public static final Logger logger = Logger.getLogger(Config.class.getName());
    OIMClient oimClient = null;

    public static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(UserManagement.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            System.out.println("Couldn't open properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String propertyName) {
        return PROPERTIES.getProperty(propertyName);
    }

    public static final String OIM_USERNAME = getProperty("oim_username");
    public static final String OIM_PASSWORD = getProperty("oim_pass");


    @SuppressWarnings({"rawtypes", "unchecked"})
    public void getOIMConnection() {
        Hashtable oimenv = new Hashtable();
        oimClient = new OIMClient(oimenv);
        try {
            oimClient.login(OIM_USERNAME, OIM_PASSWORD.toCharArray());
            System.out.println("Connected");

        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
