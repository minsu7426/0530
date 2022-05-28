package jspbook;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.*;

/**
 * File : LogContextListener.java
 * Desc : 리스?���? ?��?��?�� 로깅 ?��?��?�� 리스?�� ?��?��
 * @author ?��?��?��(dinfree@dinfree.com)
 */
@WebListener
public class LogContextListener implements ServletContextListener {
	// 로그 처리�? ?��?�� 로거 객체 
	Logger log;
	
	// 리스?�� 종료?�� 로그 메시�? 출력
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("LogContextListener stop");
	}

	// 리스?�� 초기?��?�� 로그 메시�? 출력
	public void contextInitialized(ServletContextEvent arg0) {
		log = LoggerFactory.getLogger(this.getClass());
		log.info("LogContextListener start");
	}
}