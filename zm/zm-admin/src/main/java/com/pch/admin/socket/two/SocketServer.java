package com.pch.admin.socket.two;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketServer {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                2,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(100));
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                Socket socket = serverSocket.accept();
                threadPoolExecutor.execute(new Work(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Work extends Thread {

        private Socket socket;

        Work(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream is = new DataInputStream(socket.getInputStream());
                String suffix = is.readUTF();
                FileOutputStream os = new FileOutputStream("F:\\server\\" + UUID.randomUUID().toString() + suffix);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = is.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
