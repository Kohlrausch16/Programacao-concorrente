import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

public class FileInteractions {

    Random random = new Random();

    String filePath = "bankFile.txt";

    public void deposit(char thread) throws IOException{

        String content = "Test";

        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
        BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filePath));

        buffWriter.write("Hello Java 2!");
        buffWriter.close();
        /*
        System.out.print("Valor depositado: " + random.nextInt(0,100));

        FileWriter buffWrite = new FileWriter(filePath);
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));

        buffWrite.write("Thread " + thread + " - Depósito às:" + LocalDateTime.now());
        System.out.println(" - Deposito às: " + LocalDateTime.now());
        */
    }

    public void readAmount(){
        System.out.println("Arquivo lido");
    }

    public void withdraw(){
        System.out.print("Valor sacado: " + random.nextInt(0,100));
        System.out.println(" - Saque às: " + LocalDateTime.now());
    }
}