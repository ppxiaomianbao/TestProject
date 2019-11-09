package io_nio_test;

import java.io.IOException;

/**
 * @ProjectName: demo
 * @Package: io_nio_test
 * @ClassName: TestNio
 * @Author: limingxing
 * @Description: ${description}
 * @Date: 2019/8/8 18:47
 * @Version: 1.0
 */
public class TestNio {

    public static void main(String[] args) throws IOException {
        NioTest nioTest = new NioTest();
        nioTest.initServerSocketChannal(1234);
        nioTest.listenSelector();
    }
}
