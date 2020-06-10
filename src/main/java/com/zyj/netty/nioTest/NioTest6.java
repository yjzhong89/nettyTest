package com.zyj.netty.nioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest6 {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input1.txt");
        FileOutputStream outputStream = new FileOutputStream("output1.txt");

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        // 分配直接缓冲
        ByteBuffer buffer = ByteBuffer.allocateDirect(512);

        while (true) {
            buffer.clear();

            int read = inputChannel.read(buffer);
            if (-1 == read) {
                break;
            }

            buffer.flip();

            outputChannel.write(buffer);
        }

        inputChannel.close();
        outputChannel.close();
    }
}
