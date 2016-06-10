package com.company;

/**
 * @author Jeff Lee
 * @since 2015-10-21 21:24:15
 * 回调模式-模拟服务端类
 */
class Server {
    void doSomeThing() {
        for (int i = 0; i < 100; i++ );
    }

    // EXP: 被调对象中有一个参数为callback的方法，特别的是这个callback参数其实是调用者对象
    // EXP：由于调用者实现了callback接口，所用可以被传进来,术语叫做Register a callback
    void getClientMsg(CSCallBack csCallBack , String msg) {
        System.out.println("服务端3：服务端接收到客户端发送的消息为:" + msg);

        // 模拟服务端需要对数据处理
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务端4：数据处理成功，返回成功状态 200");
        String status = "200";
        // EXP: 利用传进来callback参数来调用回调函数
        csCallBack.process(status);
    }
}
