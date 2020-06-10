package com.zyj.netty.nioTest;

import java.nio.IntBuffer;
import java.security.SecureRandom;


/**
 *  Buffer本身就是一块内存，底层是一个数组。Buffer还提供了对于数据的结构化访问方式
 *  Java中的8中原生数据类型都有各自对应的Buffer类型，并没有BooleanBuffer类型
 *
 *  buffer的相关参数
 *  0 <= mark <= position <= limit <= capacity
 *  还有一个address的成员变量，与direct buffer有关
 */

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
