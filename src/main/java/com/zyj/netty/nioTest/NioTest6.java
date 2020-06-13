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
        // 数据不需要拷贝到堆内存中，而是直接与I/O交互
        // 由于jvm中有垃圾回收，会导致数据的内存地址不断变换，所以无法通过jni直接操作
        // 所以需要将jvm中的数据拷贝到对外内存中，而在拷贝过程中数据的位置不会发生变化
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
