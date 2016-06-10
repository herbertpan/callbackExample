package com.company;

/**
 * @author Jeff Lee
 * @since 2015-10-21 21:25:14
 * 回调模式-模拟客户端类
 */
class Client implements CSCallBack {

    //EXP: 作为调用方必须持有被调用方的引用，不然没等被调用方返回就可能退出了。
    private Server server;
    Client(Server server) {
        this.server = server;
    }

    //EXP: 作为调用方，需要调用被调用方的方法, 且需要在新的线程中执行。
    void sendMsg(final String msg){
        System.out.println("客户端1：发送的消息为：" + msg);
        //EXP: 通常情况下，调用方都要创建新的线程来调用指令，不然就阻塞在这里了。
        //EXP: 可以尝试注释掉Thread部分来感受一下同步回调和异步回调的差别。
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.getClientMsg(Client.this, msg);
            }
        }).start();
//        server.getClientMsg(Client.this,msg);
        System.out.println("客户端2：异步发送成功");
    }

    //EXP: 调用方需要提供方法以供被调用方回调使用
    @Override public void process(String status) {
        System.out.println("客户端5：服务端回调状态为：" + status);
    }
}
