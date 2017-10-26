package com.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8899);

        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        String info = null;

        while ((info = br.readLine()) != null) {
            System.out.println("[Server] accept client {" + info + "}");
        }

        socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);

        pw.write("welcome!");
        pw.flush();

        pw.close();
        os.close();
        br.close();
        isr.close();
        socket.close();
        serverSocket.close();
    }
}
