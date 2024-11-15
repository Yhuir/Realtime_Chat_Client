package com.qqclient.service;

import com.qqcommon.Message;
import com.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{

    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {

            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                Message msg = (Message) ois.readObject();

                if (msg.getMsgType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] onlineList = msg.getContent().split(" ");

                    System.out.println("-------Current Online User List-------");
                    for (int i=0; i < onlineList.length; i++) {
                        System.out.println("User: " + onlineList[i]);
                    }
                } else {
                    System.out.println("Other Msg Type");
                }



            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }
}
