package ru.thesn.test_server.servlets;

import org.apache.commons.io.FileUtils;
import ru.thesn.test_server.Constants;
import ru.thesn.test_server.Mapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public final class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> md5ToName = Mapping.getInstance().getMd5ToName();
        String hash = req.getParameter("hash");

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        String deleted = md5ToName.remove(hash);
        if (deleted != null) {
            FileUtils.deleteQuietly(new File(Constants.ROOT_FOLDER + deleted));
            out.println("Completed!");
        } else {
            out.println("File was not found!");
        }
        out.flush();
        out.close();
    }
}
