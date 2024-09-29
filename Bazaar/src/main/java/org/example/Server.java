package org.example;

public class Server {
    Referee ref;

    public Server() {
        this.ref = new Referee(this);


    }

    public static void main(String[] args) {
        Server server = new Server();


    }
}
