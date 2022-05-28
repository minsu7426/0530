package jspbook.ch14;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.*;


//ch14 �뤃�뜑 �슂泥��뿉 ���빐�꽌留� �븘�꽣 �쟻�슜
@WebFilter("/ch14/*")
public class LogFilter implements Filter {
	// 濡쒓렇 泥섎━瑜� �쐞�븳 濡쒓굅 媛앹껜
	Logger log;
	
	// �븘�꽣 醫낅즺�떆 濡쒓렇硫붿떆吏�
	public void destroy() {
		log.info("LogFilter stop");
	}

	// �븘�꽣 �떎�뻾�떆 濡쒓렇硫붿떆吏�
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		log.debug("LogFilter run"+request.getRemoteAddr());
		arg2.doFilter(request, response);
	}

	// �븘�꽣 珥덇린�솕�떆 濡쒓렇硫붿떆吏�
	public void init(FilterConfig arg0) throws ServletException {
		log = LoggerFactory.getLogger(this.getClass());
		log.info("LogFilter start");
	}
}