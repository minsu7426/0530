package jspbook;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.*;

/**
 * File : LogContextListener.java
 * Desc : ë¦¬ìŠ¤?„ˆë¥? ?´?š©?•œ ë¡œê¹… ?…Œ?Š¤?Š¸ ë¦¬ìŠ¤?„ˆ ?˜ˆ? œ
 * @author ?™©?¬? •(dinfree@dinfree.com)
 */
@WebListener
public class LogContextListener implements ServletContextListener {
	// ë¡œê·¸ ì²˜ë¦¬ë¥? ?œ„?•œ ë¡œê±° ê°ì²´ 
	Logger log;
	
	// ë¦¬ìŠ¤?„ˆ ì¢…ë£Œ?‹œ ë¡œê·¸ ë©”ì‹œì§? ì¶œë ¥
	public void contextDestroyed(ServletContextEvent arg0) {
		log.info("LogContextListener stop");
	}

	// ë¦¬ìŠ¤?„ˆ ì´ˆê¸°?™”?‹œ ë¡œê·¸ ë©”ì‹œì§? ì¶œë ¥
	public void contextInitialized(ServletContextEvent arg0) {
		log = LoggerFactory.getLogger(this.getClass());
		log.info("LogContextListener start");
	}
}