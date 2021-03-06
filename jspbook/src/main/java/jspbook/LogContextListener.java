package jspbook;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.*;

/**
 * File : LogContextListener.java
 * Desc : λ¦¬μ€?λ₯? ?΄?©? λ‘κΉ ??€?Έ λ¦¬μ€? ?? 
 * @author ?©?¬? (dinfree@dinfree.com)
 */
@WebListener
public class LogContextListener implements ServletContextListener {
	// λ‘κ·Έ μ²λ¦¬λ₯? ?? λ‘κ±° κ°μ²΄ 
	Logger log;
	
	// λ¦¬μ€? μ’λ£? λ‘κ·Έ λ©μμ§? μΆλ ₯
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("LogContextListener stop");
	}

	// λ¦¬μ€? μ΄κΈ°?? λ‘κ·Έ λ©μμ§? μΆλ ₯
	public void contextInitialized(ServletContextEvent arg0) {
		log = LoggerFactory.getLogger(this.getClass());
		log.info("LogContextListener start");
	}
}