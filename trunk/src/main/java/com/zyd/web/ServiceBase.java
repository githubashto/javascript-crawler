package com.zyd.web;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceBase {
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceNotFound(req, resp);
    }

    public void put(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceNotFound(req, resp);
    }

    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        serviceNotFound(req, resp);
    }

    private void serviceNotFound(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String msg = "The requested service: " + req.getRequestURI() + ", method:" + req.getMethod() + " is not found.";
        System.out.println(msg);
        resp.getWriter().write(msg);
    }

    private static Map<String, String> ResponseTypes;
    static {
        ResponseTypes = new HashMap<String, String>();
        ResponseTypes.put("html", "text/html; charset=GBK");
        ResponseTypes.put("xml", "application/xhtml+xml; charset=GBK");
        ResponseTypes.put("js", "application/javascript; charset=GBK");
        ResponseTypes.put("text", "text/plain; charset=GBK");
    }

    /**
     * 
     * @param type one of "html", "xml", "js", "text"
     * @param resp
     */
    protected void setResponseType(String type, HttpServletResponse resp) {
        String types = ResponseTypes.get(type);
        if (types == null) {
            System.err.println("Error: invalid type:" + type);
            types = ResponseTypes.get("text");
        }
        resp.setHeader("Content-Type", types);
    }

    protected void output(String s, String encoding, HttpServletResponse response) throws IOException {
        Writer writer = new OutputStreamWriter(response.getOutputStream(), encoding);
        writer.write(s);
        writer.flush();
        writer.close();
    }

    protected void output(String s, HttpServletResponse response) throws IOException {
        output(s, "GBK", response);
    }
}
