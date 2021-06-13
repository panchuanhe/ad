package com.pch.admin.socket.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用nio复制图片
 */
public class Copy {

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("F:\\client\\12.jpg");
            FileOutputStream os = new FileOutputStream("F:\\server\\13.jpg");
            //声明缓冲区,一次读一个字节
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //获取输入通道
            FileChannel isChannel = is.getChannel();
            //获取输出通道
            FileChannel osChannel = os.getChannel();

            while (true) {
                //先清空缓冲区
                buffer.clear();
                //从输入流通道中读取数据到缓冲区
                int read = isChannel.read(buffer);
                //如果返回-1，则说明读完了
                if (read == -1) {
                    break;
                }
                //将缓冲区设置成可读模式
                buffer.flip();
                //从缓冲区读取数据到输出流通道中
                osChannel.write(buffer);
            }
            //关闭输入，输出通道
            isChannel.close();
            osChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cop() {
        try {
            FileInputStream is = new FileInputStream("F:\\client\\12.jpg");
            FileOutputStream os = new FileOutputStream("F:\\server\\14.jpg");
            //获取输入通道
            FileChannel isChannel = is.getChannel();
            //获取输出通道
            FileChannel osChannel = os.getChannel();

            isChannel.transferTo(isChannel.position(), isChannel.size(), osChannel);
            isChannel.close();
            osChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
