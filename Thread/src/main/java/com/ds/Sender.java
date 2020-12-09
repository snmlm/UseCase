package com.ds;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * @author: xxxxx
 * @create: 2020-12-03
 */
public class Sender implements Runnable {
    private PipedOutputStream pipedOutputStream;

    public Sender(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run(){
        try {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            byte[] bytes = str.getBytes();
            byte[] limitBytes = new byte[1024];
            int pages = bytes.length/limitBytes.length;
            for (int i = 0; i < pages; i++) {
                for (int j = 0; j < 1024; j++) {
                    limitBytes[j] = bytes[i*1024+j];
                }
                pipedOutputStream.write(limitBytes,0,1024);
            }
            //最后一段
            for (int i = 0; i < bytes.length-pages*1024; i++) {
                limitBytes[i] = bytes[pages*1024+i];
            }
            pipedOutputStream.write(limitBytes,0,bytes.length-pages*1024);
            pipedOutputStream.flush();
            pipedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
