package filter;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

//    store the sensitive words from the config file
    private List<String> list = new ArrayList<String>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        1. create proxy, enhance the getParameter method
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                1.1 enhance "getParameter"
//                1.1.1 if it's this method
                if (method.getName().equals("getParameter")) {
//                    1.1.2 enhance return value
                    String value = (String)method.invoke(request, args);
                    if (value != null && !"".equals(value)) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replace(s, "**");
                            }
                        }
                    }
                    return value;

                }else if(method.getName().equals("getParameterMap")) {
                    Map<String, String[]> entries = (Map<String, String[]>) method.invoke(request, args);

                    if (entries != null) {
                        Set<String> keys = entries.keySet();

                        for (String key : keys) {
                            String[] values = entries.get(key);
                            for (int i = 0; i < values.length; i++) {
                                if (values[i] != null && !"".equals(values[i])) {
                                    for (String str : list) {
                                        if (values[i].contains(str)) {
                                            values[i] = values[i].replace(str, "**");
                                        }
                                    }
                                }
                            }
                        }

                    }

                    return entries;
                }
                else if(method.getName().equals("getParameterValues")){

                    String[] values = (String[]) method.invoke(request, args);

                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            if (values[i] != null && !"".equals(values[i])) {
                                for (String str : list) {
                                    if (values[i].contains(str)) {
                                        values[i] = values[i].replace(str, "**");
                                    }
                                }
                            }
                        }
                    }

                    return values;

                }

                return method.invoke(request, args);
            }
        });

//        2. access to next resources
        chain.doFilter(proxy_req,response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {



//        2. read the file
        try {
//        1. get file real path
//        1.1 get servletContext, this is the same servletContext as the obj in the servlet
            ServletContext context = filterConfig.getServletContext();
//        1.2 because this been explored by tomcat, all file under "java" is put in classes
            String path = context.getRealPath("/WEB-INF/classes/sensitive_word.txt");
            System.out.println("real path is:"+path);

            BufferedReader br = new BufferedReader(new FileReader(path));
//            3. get each line in the sensitiveWord.txt into list
            String line = null;
            while((line = br.readLine())!=null){
                list.add(line);
            }

            br.close();

            System.out.println(list);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Filter.super.init(filterConfig);
    }




    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
