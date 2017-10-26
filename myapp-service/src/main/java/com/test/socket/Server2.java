package com.test.socket;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zhaogang3 on 2017/10/26.
 */
public class Server2 {

    public static int BUFFER_SIZE = 2048;

    public static void main(String[] args) {
        try {
            ServerSocketChannel socketChannel = ServerSocketChannel.open();

            Selector selector = Selector.open();

            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9900);
            socketChannel.socket().bind(inetSocketAddress);

            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT).attach((int) (Math.random() * 100));
            System.out.println("Server started at port 9900");

            while (true) {
                try {

                    selector.select();
                    Set<SelectionKey> selectionKeySet = selector.selectedKeys();

                    Iterator<SelectionKey> it = selectionKeySet.iterator();

                    while (it.hasNext()) {
                        SelectionKey selectionKey = it.next();
                        if(!selectionKey.isValid()) continue;
                        if (selectionKey.isAcceptable()) {
                            System.out.println(selectionKey.attachment() + "-接受请求事件");

                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                            serverSocketChannel.accept().configureBlocking(false)
                                    .register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE).attach((int) (Math.random() * 100));

                            System.out.println(selectionKey.attachment() + "-已连接");

                        }

                        if (selectionKey.isReadable()) {
                            System.out.println(selectionKey.attachment() + " - 读数据事件");
                            SocketChannel clientChannel = (SocketChannel) selectionKey.channel();

                            ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);

                            int n = clientChannel.read(buf);
                            if (n == -1) {
                                clientChannel.close();
                            } else {
                                System.out.println(selectionKey.attachment() + " - 读数据" + getString(buf));
                            }

                        }

                        if (selectionKey.isWritable()) {
                            System.out.println(selectionKey.attachment() + " - 写数据事件");
                            SocketChannel clientChannel = (SocketChannel) selectionKey.channel();

                            ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
                            String s = "hello, client!\n";
                            buf.put(s.getBytes());
                            buf.flip();
                            clientChannel.write(buf);
                            clientChannel.close();
                        }
                        if (selectionKey.isConnectable()) {
                            System.out.println(selectionKey.attachment() + "连接事件");
                        }
                        it.remove();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(ByteBuffer buffer) {
        String s = "";
        try {
            for (int i = 0; i < buffer.position(); i++) {
                s += (char) buffer.get(i);
            }
            return s;
        } catch (Exception e) {
            return "";
        }
    }
}
