package com.zyd.core.objecthandler;

import java.util.HashMap;

import com.zyd.core.objecthandler.Handler.Parameter;

@SuppressWarnings("unchecked")
public class ObjectManager {
    private final static HashMap<String, Handler> HandlerMapping = new HashMap<String, Handler>();
    private final static String PACKAGE_NAME = ObjectManager.class.getPackage().getName();

    private ObjectManager() {
    }

    /**
     * calls appropriate handler to handle create request,
     * must specify the Config.NAME_APP_PARAMETER parameter as the object name
     * @param values
     * @return
     */
    public Object create(HashMap values) {
        String objectName = (String) values.get(Parameter.PARAMETER_OBJECT_ID);
        Handler handler = lookupObjectHandler(objectName);
        if (handler == null) {
            System.err.println("Can not find handler for " + objectName);
            return false;
        }
        Object r = handler.create(values);
        return r;
    }

    /**
     * calls appropriate handler to handle query request,
     * must specify the Config.NAME_APP_PARAMETER parameter as the object name
     * @param criteria
     * @return
     */
    public SearchResult query(HashMap criteria) {
        String objectName = (String) criteria.get(Parameter.PARAMETER_OBJECT_ID);
        Handler handler = lookupObjectHandler(objectName);
        if (handler == null) {
            System.err.println("Can not find handler for " + objectName);
            return null;
        }
        SearchResult r = handler.query(criteria);
        return r;
    }

    private Handler lookupObjectHandler(String name) {
        if (name == null)
            return null;

        Handler service = null;
        synchronized (this) {
            if (HandlerMapping.containsKey(name)) {
                service = HandlerMapping.get(name);
            } else {
                try {
                    String className = PACKAGE_NAME + "." + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
                    service = (Handler) Class.forName(className).newInstance();
                    HandlerMapping.put(name, service);
                } catch (Exception e) {
                    System.err.println("Error trying to look up handler with name: " + name);
                    e.printStackTrace();
                }
            }
        }
        return service;
    }

    public void deleteAllObjects() {
        //TODO: have to auto load every thing, can't hard code here.
        (new House()).deleteAll();
        (new AppLog()).deleteAll();
    }

}