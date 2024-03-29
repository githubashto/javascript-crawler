package com.zyd.web.service;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zyd.web.ServiceBase;

public class log extends ServiceBase {
    private static Logger logger = Logger.getLogger(log.class);

    static Vector<Log> msg = new Vector<Log>();

    static class Log {
        String level;
        String msg;
        Date time;
        String url;

        Log(String level, String msg, Date time, String url) {
            this.level = level;
            this.msg = msg;
            this.time = time;
            this.url = url;
        }

        @Override
        public String toString() {
            return time.toString() + " " + level + " " + msg + "     ," + url;
        }
    }

    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("view".equals(action)) {
            setResponseType("html", resp);
            Writer o = resp.getWriter();
            o.write("<html><head><script>window.setInterval('window.location = window.location.toString()', 15000)</script></head><body>");
            for (int i = msg.size() - 1; i > -1; i--) {
                o.write(msg.get(i).toString());
                o.write("<br>");
            }
            o.write("</body></html>");
        } else {
            setResponseType("text", resp);
            String level = req.getParameter("level");
            String m = req.getParameter("msg");
            if (m != null && level != null) {
                Log l = new Log(level, m, new Date(), req.getHeader("Referer"));
                msg.add(l);
                logger.info("Client logging message: " + l.toString());
            }
        }
    }
}
