package io_nio_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: demo
 * @Package: PACKAGE_NAME
 * @ClassName: IoTest
 * @Author: limingxing
 * @Description: todo 这是传统网络编程的做法，运用多线程，可以同事和多个客户通讯
 * @Date: 2019/8/8 16:42
 * @Version: 1.0
 */
public class IoTest_2 {

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建服务端socket
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端启动成功。。。。。");
        while(true){
            //获取客户端socket
            Socket socket = serverSocket.accept();
            System.err.println("有新的用户连接。。。。。");
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    InputStream inputStream = null;
                    try {
                        inputStream = socket.getInputStream();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] b = new byte[1024];
                    while(true){
                        int read = -1;
                        try {
                            read = inputStream.read(b);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(read != -1){
                            String str = new String(b,0,read);
                            System.out.println(str);
                        } else {
                            break;
                        }
                    }
                }
            });
        }
    }
}
