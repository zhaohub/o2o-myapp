package com.test.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Client1 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9900);
        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os);
        pw.write("client id = " + (int) (Math.random() * 100000));

        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        pw.write("\n");
        pw.write(s);

        for (int i = 0; i < 100; i++) {
            pw.print(i + " ");
        }

        pw.flush();
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println("[Client] server response " + info);
        }

        socket.shutdownInput();

        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }
}
