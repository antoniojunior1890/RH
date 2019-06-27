package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class NotCoerceToZeroAppWebListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

}
