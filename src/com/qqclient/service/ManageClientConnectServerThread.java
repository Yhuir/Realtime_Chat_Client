package com.qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {

    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    public static void addClientConnectServerThread(String id, ClientConnectServerThread clientConnectServerThread) {
        hm.put(id, clientConnectServerThread);

    }

    public static ClientConnectServerThread getClientConnectServerThread(String id) {
        return hm.get(id);
    }


}
