package com.zyj.netty.nioTest;

import java.nio.ByteBuffer;

/**
 * 普通buffer可以通过asReadOnlyBuffer转换成只读buffer
 * 只读buffer不能转化为普通buffer
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println(buffer.getClass());

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        ByteBuffer readonlyBuffer = buffer.asReadOnlyBuffer();

        System.out.println(readonlyBuffer.getClass());
    }
}
