package cn.yr.strust2.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, 
		urlPatterns = { 
				"/TestFilter", 
				"*.action"
		})
public class Strust2FilterDespatcher implements Filter {

	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String servletPath = req.getServletPath();
		String url = null;

		
		if("/strust2-input.action".equals(servletPath))
		{
			url = "/WEB-INF/pages/input.jsp";
			req.getRequestDispatcher(url).forward(request, response);
			return;
		}
		if("/strust2-sava.action".equals(servletPath))
		{
			
			String name = req.getParameter("UserName");
			String words = req.getParameter("Passwords");
			String height = req.getParameter("Height");
			
			User user = new User(1001,name,words,Double.parseDouble(height));
			req.setAttribute("user", user);
			url = "/WEB-INF/pages/details.jsp";
			req.getRequestDispatcher(url).forward(request, response);
			return;
		}
		if(servletPath != "/strust2-input.action")
		{
			url = "index.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {}

}
;