package com.pch.admin.socket.three;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * socket服务端，nio模式
 */
public class SocketServer {

    public static void main(String[] args) {
        try {
            //服务端绑定9000端口
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9000));
            //通道设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            //创建选择器
            Selector selector = Selector.open();
            //将服务端通道注册到选择器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                //打开选择器监控，阻塞在这里
                selector.select();
                //获取注册在选择器上的key集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                //遍历key集合
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //如果是请求连接事件
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                        SocketChannel accept = socketChannel.accept();
                        accept.configureBlocking(false);
                        accept.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        //如果是读事件
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len;
                        while ((len = socketChannel.read(buffer)) > 0) {
                            System.out.println("服务端接收到数据：" + new String(buffer.array()));
                        }
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
