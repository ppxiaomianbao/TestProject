package io_nio_test;

import com.sun.security.ntlm.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @ProjectName: demo
 * @Package: io_nio_test
 * @ClassName: NioTest
 * @Author: limingxing
 * @Description: todo NIO（非阻塞io）测试类
 * @Date: 2019/8/8 18:31
 * @Version: 1.0
 */
public class NioTest {
    private Selector selector;

    /**
     * @Method initServerSocketChannal
     * @Author limingxing
     * @Version  1.0
     * @Description todo 初始化服务端
     * @param port
     * @Return void
     * @Exception
     * @Date 2019/8/8 18:56
     */
    public void initServerSocketChannal(int port) throws IOException {
        //创建服务端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //为服务端绑定端口号
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //创建监听对象
        this.selector = Selector.open();
        //为服务注册监听对象，并设置监听类型
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.err.println("服务端已启动。。。。。");
    }

    /**
     * @Method listenSelector
     * @Author limingxing
     * @Version  1.0
     * @Description todo 监听方法
     * @param
     * @Return void
     * @Exception
     * @Date 2019/8/8 18:56
     */
    public void listenSelector() throws IOException {
        while (true){
            //开始监听，进入这里会阻塞，知道有客户连接此服务
            this.selector.select();
            //得到连接此服务用户的监听key
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            //迭代这些对象，并进行处理
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                iterator.remove();
                handler(next);
            }

        }
    }

    /**
     * @Method handler
     * @Author limingxing
     * @Version  1.0
     * @Description 处理监听的对象
     * @param key
     * @Return void
     * @Exception
     * @Date 2019/8/8 18:59
     */
    private void handler(SelectionKey key) throws IOException {
        //如果是刚连接此服务的对象就会进入这个判断
        if(key.isAcceptable()){
            System.err.println("新用户连接...");
            //通过监听key获取服务端对象
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            SocketChannel accept = channel.accept();
            //设置客户端非阻塞
            accept.configureBlocking(false);
            //为客户端注册监听并设置读取类型
            accept.register(selector,SelectionKey.OP_READ);

        //如果是读取类型就进入这个判断
        }else if(key.isReadable()){
            //获取客户端对象
            SocketChannel socketChannel = (SocketChannel) key.channel();
            //创建字节缓冲流
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //利用缓冲流读取客户端传递过来的数据
            int read = socketChannel.read(byteBuffer);
            //如果数据不为空
            if(read > 0){
                String info = new String(byteBuffer.array(),"gbk");
                System.out.println("收到客户端数据： " + info);
            }else{
                System.out.println("客户端已关闭!!!");
                //关闭监听对象
                key.cancel();
            }


        }
    }
}
