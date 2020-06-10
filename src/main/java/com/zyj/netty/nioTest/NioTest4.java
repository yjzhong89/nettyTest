package com.zyj.netty.nioTest;

import java.nio.ByteBuffer;

public class NioTest4 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(15);
        buffer.putLong(15000L);
        buffer.putDouble(15.001);
        buffer.putChar('h');

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getChar());
    }
}
