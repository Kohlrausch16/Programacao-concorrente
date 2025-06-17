import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class FileInteractions {
    Random random = new Random();

    String filePath = "C:/Users/Link/Desktop/Programacao-concorrente/src/src/bankFile.txt";

    public void deposit(char thread) throws IOException{

        String content = "Test";

        try (BufferedReader buffRead = new BufferedReader(new FileReader(filePath));) {
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = buffRead.readLine()) != null) {
                list.add(line);
            }

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filePath, true));
            int lastValue = Integer.parseInt(list.getLast());
            int depositValue = random.nextInt(0,100);
            buffWriter.write("\n " + Thread.currentThread().getName() + " - Depósito às: " + LocalDateTime.now() + " de " + depositValue);
            buffWriter.write("\n" + (lastValue + depositValue));
            buffWriter.close();
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }

    public void readAmount(){
        try (BufferedReader buffRead = new BufferedReader(new FileReader(filePath));) {
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = buffRead.readLine()) != null) {
                list.add(line);
            }

            System.out.println("Leiura do valor " + list.getLast() + " feita pela thread " + Thread.currentThread().getName());
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }

    public void withdraw(){
        try (BufferedReader buffRead = new BufferedReader(new FileReader(filePath));) {
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = buffRead.readLine()) != null) {
                list.add(line);
            }

            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(filePath, true));
            int lastValue = Integer.parseInt(list.getLast());
            int depositValue = random.nextInt(0,100);
            if((lastValue - depositValue) < 0){
                return;
            } else {
                buffWriter.write("\n " + Thread.currentThread().getName() + " - Saque às: " + LocalDateTime.now() + " de " + depositValue);
                buffWriter.write("\n" + (lastValue - depositValue));
            }

            buffWriter.close();
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }
}