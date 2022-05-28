package jspbook;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.*;


//ch14 ï¿½ë¤ƒï¿½ëœ‘ ï¿½ìŠ‚ï§£ï¿½ï¿½ë¿‰ ï¿½ï¿½ï¿½ë¹ï¿½ê½Œï§ï¿½ ï¿½ë¸˜ï¿½ê½£ ï¿½ìŸ»ï¿½ìŠœ
@WebFilter("/*")
public class LogFilter implements Filter {
	// æ¿¡ì’“? ‡ ï§£ì„?”?‘œï¿? ï¿½ìï¿½ë¸³ æ¿¡ì’“êµ? åª›ì•¹ê»?
	Logger log;
	
	// ï¿½ë¸˜ï¿½ê½£ ?†«?‚…ì¦ºï¿½?–† æ¿¡ì’“? ‡ï§ë¶¿?–†ï§ï¿½
	public void destroy() {
		log.info("LogFilter stop");
	}

	// ï¿½ë¸˜ï¿½ê½£ ï¿½ë–ï¿½ë»¾ï¿½ë–† æ¿¡ì’“? ‡ï§ë¶¿?–†ï§ï¿½
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		log.debug("LogFilter run"+request.getRemoteAddr());
		arg2.doFilter(request, response);
	}

	// ï¿½ë¸˜ï¿½ê½£ ?¥?‡ë¦°ï¿½?†•ï¿½ë–† æ¿¡ì’“? ‡ï§ë¶¿?–†ï§ï¿½
	public void init(FilterConfig arg0) throws ServletException {
		log = LoggerFactory.getLogger(this.getClass());
		log.info("LogFilter start");
	}
}