package com.test.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Client2 {

    private static ByteBuffer buffer = ByteBuffer.allocate(512);

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("localhost"),9900);

        SocketChannel socket = null;

        byte[] bytes = new byte[512];
        while (true){
            System.in.read(bytes);
            socket = SocketChannel.open();
            socket.connect(address);

            buffer.clear();
            buffer.put(bytes);
            buffer.flip();

            socket.write(buffer);
            buffer.clear();
        }

    }
}
