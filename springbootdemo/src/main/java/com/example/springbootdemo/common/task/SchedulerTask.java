package com.example.springbootdemo.common.task;

import com.example.springbootdemo.config.TimeUtil;
import com.example.springbootdemo.config.websocket.MySocket;
import com.example.springbootdemo.entity.User;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: springbootdemo
 * @Package: com.example.springbootdemo.common.task
 * @ClassName: SchedulerTask
 * @Author: limingxing
 * @Description: TODO 测试定时任务类
 * @Date: 2019/7/25 12:26
 * @Version: 1.0
 */
@Component
public class SchedulerTask {
    @Autowired
    private MySocket mySocket;

    /**
     * @Method taskTest
     * @Author limingxing
     * @Version  1.0
     * @Description 每30分钟执行一次
     * @param
     * @Return void
     * @Exception
     * @Date 2019/7/25 12:30
     */
    @Scheduled(cron = "0 0/30 * * * ?")
    private void taskTest() throws IOException {
        CopyOnWriteArraySet<MySocket> webSocketSet = mySocket.webSocketSet;
        if(webSocketSet!=null&&!webSocketSet.isEmpty()) {
            ExecutorService executorService = Executors.newFixedThreadPool(webSocketSet.size());
            for (MySocket socket : webSocketSet) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            User user = socket.getUser();
                            socket.sendMessage("定时任务通过websocket向前端id为：" + user.getId() + " 的用户发送消息");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            executorService.shutdown();
        }
        System.err.println(TimeUtil.dateFormat("yyyy-MM-dd HH:mm:ss") + " 定时任务");
    }
}
