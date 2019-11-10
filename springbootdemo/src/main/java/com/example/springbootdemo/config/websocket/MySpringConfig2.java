package com.example.springbootdemo.config.websocket;

import org.apache.tomcat.websocket.server.DefaultServerEndpointConfigurator;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.config.websocket
 * @ClassName: MySpringConfig2
 * @Author: limingxing
 * @Description: todo 此方法主要为获取httpsession对象
 * @Date: 2019/11/10 19:40
 * @Version: 1.0
 */
public class MySpringConfig2 extends DefaultServerEndpointConfigurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
