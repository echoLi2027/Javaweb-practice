package filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterInherentMethod01 implements Filter {

    /**
     * after server activated, it'll create filter obj, then call init method. Only execute once.
     * used for loading resources.
     *
     * @param filterConfig a <code>FilterConfig</code> object containing the
     *                     filter's configuration and initialization parameters
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterInherentMethod01 init....");
        Filter.super.init(filterConfig);
    }

    /**
     * will execute multiple times as long as each request was intercepted.
     *
     * @param request the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        1. action can be done before letting req&resp go to servlet
        System.out.println("before doFilter......");

//        2. execute corresponding servlet
        chain.doFilter(request, response);

//        3. action can be done after letting req&resp go to servlet
        System.out.println("after doFilter......");

    }

    /**
     *  after turn down the server, Filter obj will be destroyed.
     *  Only execute for one time, used to release resources.
     */
    @Override
    public void destroy() {
        System.out.println("FilterInherentMethod01 destroy...");
        Filter.super.destroy();
    }
}
