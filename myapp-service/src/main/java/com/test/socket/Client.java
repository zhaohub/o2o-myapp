package com.test.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.195.34", 8000);
        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os);

        pw.write("request from client! 2323243242");
        pw.flush();

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("[Client] server response " + info);
        }

        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
}
