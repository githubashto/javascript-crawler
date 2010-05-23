package com.zyd.web;

import java.util.HashMap;

import junit.framework.TestCase;

import com.tj.common.util.test.HttpTestUtil;
import com.zyd.ATestUtil;
import com.zyd.Constants;

public class TestLinkManager extends TestCase {
    int expire = 5 * 1000;
    int sleep = 5 * 1000;

    @Override
    protected void setUp() throws Exception {
        assertTrue(ATestUtil.clearServerData());
    }

    public void testLinkProcessingExpire() throws Exception {
        ATestUtil.createSomeLinks();
        HashMap<String, String> config = new HashMap<String, String>();
        config.put("LINK_PROCESSING_EXPIRE", Integer.toString(expire));
        config.put("LINK_MONITOR_SLEEP", Integer.toString(expire));
        String s = null;
        ATestUtil.updateServerConfigure(config);
        for (int i = 0; i < 5; i++) {
            ATestUtil.getNextLink();
        }
        try {
            System.err.println("Wait for thread sleep, make sure LinkManager is going through enough cycles");
            Thread.sleep(sleep * 5);
        } catch (Exception e) {
        }
        s = HttpTestUtil.httpGetForString(Constants.ServerUrl + "/service/controller?action=LinkSnapshot", null);
        assertNotNull(s);
        s = s.replaceAll(" ", "");
        assertTrue(s, s.indexOf("error:5") > 0);
        assertTrue(ATestUtil.reststoreServerConfigure());
    }

    /**
     * 
     * @throws Exception
     */
    public void testLinkManagerPurgeLinks() throws Exception {
        String s = null;
        assertTrue(ATestUtil.createSomeObject() > 0);
        HashMap<String, String> configure = new HashMap<String, String>();
        configure.put("LINK_MONITOR_SLEEP", sleep + "");
        configure.put("LINK_LOAD_BEFORE", sleep + "");
        ATestUtil.updateServerConfigure(configure);

        try {
            System.err.println("Wait for thread sleep, make sure LinkManager is going through enough cycles");
            Thread.sleep(sleep * 5);
        } catch (Exception e) {
        }
        s = HttpTestUtil.httpGetForString(Constants.ServerUrl + "/service/controller?action=LinkSnapshot", null);
        assertNotNull(s);
        s = s.replaceAll(" ", "");
        assertTrue(s, s.indexOf("processed:0") != -1);
        assertTrue(s, s.indexOf("error:0") != -1);
        assertTrue(s, s.indexOf("processing:0") != -1);
        assertTrue(s, s.indexOf("waiting:0") != -1);
        assertTrue(ATestUtil.reststoreServerConfigure());
    }
}
