package com.test.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Client2 {

    private static ByteBuffer buffer = ByteBuffer.allocate(512);
    private static ByteBuffer READ_BUFFER = ByteBuffer.allocate(512);

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress("169.254.81.9", 9900);

        SocketChannel socket = null;

        byte[] bytes = new byte[512];
        socket = SocketChannel.open();
        socket.connect(address);
        while (true) {
            System.in.read(bytes);

            buffer.clear();
            buffer.put(bytes);
            buffer.flip();

            socket.write(buffer);
            buffer.clear();

            socket.read(READ_BUFFER);
            System.out.println("Response from server:" + Server2.getString(READ_BUFFER));
            READ_BUFFER.clear();
        }

    }
}
