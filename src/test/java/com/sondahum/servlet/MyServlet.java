package com.sondahum.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;


/**
 * 이 Servlet은 "/test"으로 명시된 action의 요청이 발생했을때 동작하는 Servlet이다.
 */
@WebServlet("/test")
public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet 호출!!");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }


    /**
     * doGet이나 doPost는 결국
     * 클라이언트가 사용하는 메소드... ===> 정확하게는 Servlet Container 가 호출하는 메소드!!
     * html, jsp에서 하는 요청에 따라서 WAS가 매칭시켜 주겠지?
     * <p>
     * 아래의 doGet은 클라이언트가 get요청을 하면 요청할때 보낸 패킷의 해더이름과 그 값들을 서버 사이드에 출력한다.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Enumeration<String> e = req.getHeaderNames();

        while (e.hasMoreElements()) {
            String headerName = e.nextElement();
            String[] values = req.getParameterValues(headerName);
            for (String value : values) {
                System.out.println("name : " + headerName + ", value : " + value);
            }
        }

        Vector vector = new Vector(10);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 종료!!!");
    }
}
