package com.promotion.action.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws Exception {
        FileChannelTest test = new FileChannelTest();
        //test.read();
        test.testFile();
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
