package com.zyj.netty.nioTest;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 *  ASCII
 *      7bit来表示一个字符，一共可以表示128个字符
 *
 *  ISO-8859-1(完全兼容ASCII)
 *      8bit来表示一个字符，一共可以表示256个字符
 *
 *  GB2312
 *      两个字节表示一个汉字
 *
 *  gbk(包含GB2312)
 *
 *  gb18030
 *      最全的表示汉字的字符集
 *
 *  big5
 *      繁体中文
 *
 *  unicode
 *      两个字节表示一个字符(存储空间大)
 *
 *  utf-8
 *      unicode是一种编码方式，儿UTF是一种存储方式，utf-8是unicode的实现方式之一
 *      utf-8是一种变长字节表示形式
 *      一般情况下，utf-8会通过3个字节来表示一个中文
 *
 *  BOM(Byte Order Mark)
 */
public class NioTest11Encode {
    public static void main(String[] args) throws Exception {
        String inputFile = "NioTest11_In.txt";
        String outputFile = "NioTest11_Out.txt";

        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(inputFile, "r");
        RandomAccessFile outputRandomAccessFile = new RandomAccessFile(outputFile, "rw");

        long inputLength = new File(inputFile).length();

        FileChannel inputRandomAccessFileChannel = inputRandomAccessFile.getChannel();
        FileChannel outputRandomAccessFileChannel = outputRandomAccessFile.getChannel();

        MappedByteBuffer buffer = inputRandomAccessFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, inputLength);

        Charset charset = Charset.forName("iso-8859-1");
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(buffer);
        ByteBuffer outputBuffer = encoder.encode(charBuffer);

        outputRandomAccessFileChannel.write(outputBuffer);

        inputRandomAccessFile.close();
        outputRandomAccessFile.close();
    }
}
