package com.zyd.web.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;

import com.zyd.core.Utils;
import com.zyd.core.busi.LinkManager;
import com.zyd.core.busi.TemplateManager;
import com.zyd.core.util.SpringContext;
import com.zyd.web.ServiceBase;

public class link extends ServiceBase {
    private LinkManager linkManager;
    private TemplateManager templateManager;

    public link() {
        linkManager = (LinkManager) SpringContext.getContext().getBean("linkManager");
        templateManager = (TemplateManager) SpringContext.getContext().getBean("templateManager");
    }

    /**
     * method: get 
     * description: get link to crawl 
     * parameter :action, list - shows the current list, 
     *                    get - get a link, this will remove the link as
     *                          well redirect to next url
     *                          
     *                    redirect - returns an html page that automatically redirect browser to next page,
     *                          remvoing the link as well.
     *                          
     *                    count, how many links to return, if action is list, default to 20,
     *                    if action is get, default to 1.  put -1 will return all.
     */
    @Override
    public void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action"), counts = req.getParameter("count");
        String s = "";
        if (StringUtils.isNotBlank(action) == false || (action.equals("list") == false && action.equals("get") == false && action.equals("redirect") == false)) {
            action = "list";
        }
        if (StringUtils.isNotBlank(counts) == false || StringUtils.isNumeric(counts) == false) {
            if (action.equals("list"))
                counts = "20";
            else
                counts = "1";
        }

        if ("list".equals(action)) {
            // TODO: count is ignored
            setResponseType("text", resp);
            s = Utils.stringToFlatList(linkManager.getAllLinks());
        } else if ("get".equals(action)) {
            setResponseType("js", resp);
            s = Utils.stringArrayToJsonString(new String[] { "result", linkManager.nextLink().url });
        } else if ("redirect".equals(action)) {
            setResponseType("html", resp);
            String l = linkManager.nextLink().url;
            ArrayList<String> p = new ArrayList<String>();
            p.add(l);
            s = templateManager.getTemplate("redirect", p);
        } else {
            s = "No action specified";
        }
        output(s, resp);
    }

    /**
     * method: post 
     * description: add link(s) to crawl 
     * parameters:   data,  containing json array of links. 
     * response: how many requests are added, some requests might be in system already. 
     *           An example response is "{'result':'2'}".
     */
    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseType("js", resp);
        String data = req.getParameter("data");
        if (StringUtils.isNotBlank(data) == false) {
            data = "[]";
        }

        int count = 0;
        try {
            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < arr.length(); i++) {
                if (linkManager.addLink(arr.getString(i)) != null) {
                    count++;
                }
            }
        } catch (JSONException e) {
            throw new IOException(e);
        }
        String s = Utils.stringArrayToJsonString(new String[] { "result", Integer.toString(count) });
        output(s, resp);
    }
}