package com.example.springbootdemo.config.websocket;

import org.apache.tomcat.websocket.server.DefaultServerEndpointConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.config.websocket
 * @ClassName: MySpringConfig
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/11/10 17:53
 * @Version: 1.0
 */
public class MySpringConfig extends DefaultServerEndpointConfigurator implements ApplicationContextAware {
    private static volatile BeanFactory context;

    //获取httpservletrequest并保存
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession=(HttpSession) request.getHttpSession();
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MySpringConfig.context = applicationContext;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return context.getBean(clazz);
    }

}
