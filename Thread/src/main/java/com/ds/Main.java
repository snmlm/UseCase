package com.ds;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: xxxxx
 * @create: 2020-12-03
 */
public class Main {
    public static void main(String[] args) throws Exception {
        new Main().pipe();
    }

    public void pipe() throws Exception{
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();
        pipedOutputStream.connect(pipedInputStream);
        Sender sender = new Sender(pipedOutputStream);
        Receiver receiver = new Receiver(pipedInputStream);
        Thread threadS = new Thread(sender);
        Thread threadR = new Thread(receiver);
        threadR.start();
        threadS.start();
    }
}
