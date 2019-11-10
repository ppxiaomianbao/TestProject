package com.example.springbootdemo.config.websocket;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.config.websocket
 * @ClassName: WebsocketConfig
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/11/10 17:47
 * @Version: 1.0
 */
@Configuration
@ConditionalOnWebApplication
public class WebSocketConfig {

    //使用boot内置tomcat时需要注入此bean
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public MySpringConfig getMySpringConfig(){
        return new MySpringConfig();
    }
}
