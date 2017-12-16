package com.promotion.action.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        FileChannelTest test = new FileChannelTest();
        //test.read();
        //test.testFile();
        //demoRandomAccessFile();

        testBuffer();
    }


    public static void testBuffer() throws Exception {
        RandomAccessFile file = new RandomAccessFile(new File("demo.txt"), "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);//分配字节缓存区
        int bytesRead = channel.read(byteBuffer);

        while (-1 != bytesRead) {
            byteBuffer.flip();//把Buffers从写模式调整为读模式

            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());

            }

            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }
        file.close();
    }


    public static void demoRandomAccessFile() throws IOException {
        File file = new File("demo.txt");
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
        byte[] bytes = new byte[100];

        int i = 0;
        while (-1 != (i = accessFile.read(bytes))) {
            System.out.println(new String(bytes, 0, i));
        }
        accessFile.close();

    }

    public void testFile() throws Exception {
        File file = new File(this.getClass().getResource("/").getPath() + "\\nio-data_0.txt");
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
    }


    public void read() throws Exception {
        File f = new File(this.getClass().getResource("/").getPath() + "\\nio-data.txt");
        RandomAccessFile file = new RandomAccessFile(f.getAbsolutePath(), "rw");

        FileChannel fileChannel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytes = fileChannel.read(buf);
        while (-1 != bytes) {
            System.out.println("Read " + bytes);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get() + "===");
            }
            buf.clear();
            bytes = fileChannel.read(buf);
        }
        file.close();
    }
}
