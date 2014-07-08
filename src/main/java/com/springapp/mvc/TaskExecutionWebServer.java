package com.springapp.mvc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zdsoft on 14-5-28.
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException{
        ServerSocket socket = new ServerSocket();
        while (true){
//            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("task");
                }
            };
            exec.execute(task);
        }
    }
}
