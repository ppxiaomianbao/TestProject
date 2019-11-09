package io_nio_test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName: demo
 * @Package: PACKAGE_NAME
 * @ClassName: IoTest
 * @Author: limingxing
 * @Description: todo 这是传统网络编程的做法，缺点，只能点对点的通讯，无法同事和多个客户通讯
 * @Date: 2019/8/8 16:42
 * @Version: 1.0
 */
public class IoTest_1 {

    public static void main(String[] args) throws IOException {
        //创建服务端socket
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务端启动成功。。。。。");
        while(true){
            //获取客户端socket
            Socket socket = serverSocket.accept();
            System.err.println("有新的用户连接。。。。。");
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            while(true){
                int read = inputStream.read(b);
                if(read != -1){
                    String str = new String(b,0,read);
                    System.out.println(str);
                } else {
                    break;
                }
            }
        }
    }
}
