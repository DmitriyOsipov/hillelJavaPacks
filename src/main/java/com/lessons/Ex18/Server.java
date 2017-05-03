package com.lessons.Ex18;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException{
        //ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        ObjectInputStream in = null;

        try (ServerSocket serverSocket = new ServerSocket(port)){
            clientSocket = serverSocket.accept();
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            System.out.println("Got data...");
            Object student = in.readObject();

            out.println("...Server got your data");
            out.println("...Server deserialized object");
            out.println("...");
            out.println(String.format("It's class is: %s", student.getClass().toString()));
            out.println("...");
            out.println(student.toString());
            out.println("...Bye!");
            System.out.println("Deserialized student:");
            System.out.println(student);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        finally {
            if (clientSocket!=null) {
                clientSocket.close();
            }
            if (in!=null){
                in.close();
            }
            if (out!=null){
                out.close();
            }
        }
    }


}
