package com.zyd.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.zyd.ncore.Utils;
import com.zyd.ncore.busi.CrawlerManager;
import com.zyd.web.ServiceBase;

public class chapterlist extends ServiceBase {
    /**
     * method: post
     * description: add chapters to a book
     * parameters: data, containing a json string has a book, with all the chapters, the format is like:
     *             book - { name:'', author:'', chapters:[{name:'', updateTime:'' etc...},{...}]
     *             name and author for the book are must, name for chapter is must. 
     * response: 
     */
    @Override
    public void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setResponseType("js", resp);
        String data = req.getParameter("data"), fromUrl = req.getHeader("referer");
        boolean changed = false;
        if (StringUtils.isNotBlank(data)) {
            changed = CrawlerManager.getInstance().processBook(data, fromUrl);
        }
        String s = Utils.stringArrayToJsonString(new String[] { "result", Boolean.toString(changed) });
        output(s, resp);
    }
}
