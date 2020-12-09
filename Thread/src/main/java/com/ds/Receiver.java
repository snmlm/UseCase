package com.ds;

import java.io.PipedInputStream;

/**
 * @author: xxxxx
 * @create: 2020-12-03
 */
public class Receiver implements Runnable {
    private PipedInputStream pipedInputStream;

    public Receiver(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];
            int index = -1;
            while((index = pipedInputStream.read(bytes))>-1){
                System.out.println(new String(bytes,0,index).toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
