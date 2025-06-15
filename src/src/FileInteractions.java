import java.io.*;
import java.time.LocalDateTime;
import java.util.Random;

public class FileInteractions {

    Random random = new Random();
    String filePath = "C:/Users/elisa/OneDrive/Área de Trabalho/programacao-concorrente/src/src/bankFile.txt";

    public void deposit(char thread) throws IOException, FileNotFoundException {
        System.out.print("Valor depositado: " + random.nextInt(0,100));

        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePath));
        BufferedReader buffRead = new BufferedReader(new FileReader(filePath));

        lastValue = 
        buffWrite.append("Thread " + thread + " - Depósito às:" + LocalDateTime.now());
        System.out.println(" - Deposito às: " + LocalDateTime.now());
    }

    public void readAmount(){
        System.out.println("Arquivo lido");
    }

    public void withdraw(){
        System.out.print("Valor sacado: " + random.nextInt(0,100));
        System.out.println(" - Saque às: " + LocalDateTime.now());
    }
}