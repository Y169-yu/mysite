package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(
			ServletRequest request,ServletResponse response,
			FilterChain chain
			) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("フィルタの前処理");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("フィルタの開始");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("フィルタの終了");
	}
}
