package ru.thesn.test_server;


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.thesn.test_server.servlets.DeleteServlet;
import ru.thesn.test_server.servlets.DownloadServlet;
import ru.thesn.test_server.servlets.FindServlet;


public final class Start {
    public static void main(String[] args) throws Exception {
        Mapping.getInstance();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new DownloadServlet()), "/download");
        context.addServlet(new ServletHolder(new FindServlet()), "/find");
        context.addServlet(new ServletHolder(new DeleteServlet()), "/delete");

        Server server = new Server(8080);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{context});
        server.setHandler(handlers);
        server.start();
        server.join();
    }
}