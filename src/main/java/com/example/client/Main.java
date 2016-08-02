package com.example.client;
import com.example.common.HelloWorld;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import org.glassfish.internal.api.ORBLocator;

/**
 * 
 * @author yandypiedra
 */
public class Main {

    public static void main(String[] args) throws NamingException {
        HelloWorld proxy = lookup();
        System.out.println(proxy.sayHello("EJB"));

    }

    // lookup for this UserManger proxy
    private static HelloWorld lookup() throws NamingException {
        Properties props = new Properties();
//        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
//        props.setProperty(ORBLocator.OMG_ORB_INIT_HOST_PROPERTY, "localhost");
//        props.setProperty(ORBLocator.OMG_ORB_INIT_PORT_PROPERTY, "3700");
//        props.put(Context.SECURITY_PRINCIPAL, "user");
//        props.put(Context.SECURITY_CREDENTIALS, "password");
          Context ctx = new InitialContext(props);
          return (HelloWorld)ctx.lookup("java:global/ejb-example/HelloWorldEJB");
    }
}
