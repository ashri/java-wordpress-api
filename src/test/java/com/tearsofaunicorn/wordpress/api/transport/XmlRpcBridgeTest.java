package com.tearsofaunicorn.wordpress.api.transport;


import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.junit.Test;

import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
public class XmlRpcBridgeTest {

    @Test
    public void testRawConnection() throws Exception {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:8080/pebble/xmlrpc/"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        // Params needed: blogid, username, password, struct, publish
        // First create the fourth parameter, struct:
        Map<String, String> m = new HashMap<String, String>();
        m.put("title", "Hello World " + Calendar.getInstance().toString());
        m.put("link", "http://www.indiwiz.com/");
        m.put("description", "This is the content of the post!");

        Object[] params = new Object[]{"default", "username", "password", m, true};

        String ret = (String) client.execute("metaWeblog.newPost", params);
        System.out.println(ret);
    }
}
