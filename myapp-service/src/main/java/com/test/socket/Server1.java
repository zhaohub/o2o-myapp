package com.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Server1 {

    private static ExecutorService executorService = new ThreadPoolExecutor(3, 3, 5, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8899);
            System.out.println("server started at port 8899");
            //serverSocket.setSoTimeout(200000);
            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    List<Socket> list = new ArrayList<Socket>();
                    list.add(socket);

                    System.out.println("accept a client");
                    //new Thread(new ServerThread(socket)).start();
                    executorService.execute(new ServerThread(socket));
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String info = null;

            while ((info = br.readLine()) != null) {
                System.out.println("[Server thread-" + Thread.currentThread().getId() + "] accept client {" + info + "}");
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
        } catch (Exception e) {

        }
    }
}
