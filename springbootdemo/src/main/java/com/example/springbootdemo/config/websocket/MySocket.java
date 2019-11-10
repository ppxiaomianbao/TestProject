package com.example.springbootdemo.config.websocket;

import com.example.springbootdemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.config.websocket
 * @ClassName: MySocket
 * @Author: limingxing
 * @Description: 测试websocket
 * @Date: 2019/11/10 11:05
 * @Version: 1.0
 * */

@Component
@ServerEndpoint(value = "/websocketTest",configurator = MySpringConfig.class)
public class MySocket {
    public User getUser() {
        return user;
    }

    private User user;
    private static AtomicInteger count = new AtomicInteger(0);
    public static CopyOnWriteArraySet<MySocket> webSocketSet = new CopyOnWriteArraySet<MySocket>();
    private Session session;
    private Logger logger = LoggerFactory.getLogger(MySocket.class);




    //连接时调用
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        User user = (User) httpSession.getAttribute("user");
        this.user = user;
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }


    //关闭调用
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    //收到消息时调用
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        for (MySocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onErrr(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();

    }

    private String getOnlineCount() {
        return count.toString();
    }

    private void addOnlineCount() {
        count.incrementAndGet();
    }

    private void subOnlineCount() {
        count.decrementAndGet();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

}
