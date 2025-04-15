package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//1. intercept all resources under user catalog.
//@WebFilter("/user/*")
//2. only visit index.jsp will be intercepted.
//@WebFilter("/index.jsp")
//3. file name's suffix is 'jsp' will be intercepted
//@WebFilter("*.jsp")

//4. browser directly request for index.jsp, this filter will be executed
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

//5. only index.jsp is visited by forward, this filter will be executed
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.FORWARD)

//6. only index.jsp is visited by forward or browser directly request for index.jsp, this filter will be executed
@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterAnnotationConfig02 implements Filter {

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
//        System.out.println("FilterInherentMethod01 init....");
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
