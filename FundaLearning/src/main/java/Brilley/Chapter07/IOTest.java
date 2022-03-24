package Brilley.Chapter07;

import sun.java2d.pipe.SpanIterator;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Brilley
 * @date 2022/3/23
 */
public class IOTest {
    public static void test1() throws IOException {
        FileOutputStream fos=new FileOutputStream("fos.txt");
        fos.write("王小宝".getBytes());
        fos.close();
    }

    public static void test2() throws IOException {
        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pipedOutputStream.write("沉默王二".getBytes(StandardCharsets.UTF_8));
                    pipedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] flush =new byte[1024];
                    int len =0;
                    while(-1!=(len=pipedInputStream.read(flush))){
                        System.out.println(new String(flush,0,len));
                    }

                    pipedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        thread2.start();
    }

    public static void test3() throws IOException {
        DataOutputStream das = new DataOutputStream(new FileOutputStream("das.txt"));
        das.writeByte(10);
        das.writeShort(100);
        das.writeInt(1000);
        das.writeLong(10000L);
        das.writeFloat(12.34F);
        das.writeDouble(12.56);
        das.writeBoolean(true);
        das.writeChar('A');

        DataInputStream dis = new DataInputStream(new FileInputStream("das.txt")) ;
        byte b = dis.readByte() ;
        short s = dis.readShort() ;
        int i = dis.readInt();
        long l = dis.readLong() ;
        float f = dis.readFloat() ;
        double d = dis.readDouble() ;
        boolean bb = dis.readBoolean() ;
        char ch = dis.readChar() ;
        System.out.println(b);
        System.out.println(s);
        System.out.println(d);
    }

    public static void test4() throws IOException {
        File f = new File("test.txt") ;
        Writer out = new OutputStreamWriter(new FileOutputStream(f)) ; // 字节流变为字符流
        out.write("hello world!!\n") ;    // 使用字符流输出
        out.write("I love you, yanyan");
        out.close() ;
    }
}
