package ru.thesn.test_server.servlets;


import ru.thesn.test_server.Mapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public final class FindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        boolean regexp = "true".equals(req.getParameter("is_regexp"));

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        Mapping
                .getInstance()
                .getMd5ToName()
                .entrySet()
                .stream()
                .filter(entry -> isNameMatched(entry.getValue(), keyword, regexp))
                .limit(25)
                .forEach(entry -> out.println(entry.getKey() + " / " + entry.getValue()));

        out.flush();
        out.close();
    }


    private boolean isNameMatched(String name, String keyword, boolean regexp) {
        return regexp ? name.matches(keyword) : name.contains(keyword);
    }

}
