package com.pch.admin.socket.two;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {

        try (FileInputStream is = new FileInputStream("F:\\client\\12.jpg")) {
            Socket socket = new Socket("127.0.0.1", 9999);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(".jpg");
            int len;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer, 0, len);
            }
            dos.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
