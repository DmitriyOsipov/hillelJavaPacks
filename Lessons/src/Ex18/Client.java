package Ex18;

import Ex16.students.Student;

import java.io.*;
import java.net.Socket;


public class Client {
    private static final String host = "127.0.0.1";
    private static final int port = 8080;


    public static void main(String[] args) {
        BufferedReader in = null;
        ObjectOutputStream out = null;

        try (Socket socket = new Socket(host, port)){
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Student student = generateStudent();
            System.out.println("Generate student");
            System.out.println(student);
            System.out.println();
            System.out.println("Get information from server:");
            out.writeObject(student);
            out.flush();

            String readed = null;
            while ((readed = in.readLine())!=null){
                System.out.println(readed);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if (in!=null){
                try {
                    in.close();
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }

    }

    private static Student generateStudent(){
        Student student = new Student(0, "Ivanov");
        student.putMark("Math", 50);
        student.putMark("Physics", 45);
        student.putMark("Programming", 49);
        return student;
    }
}
