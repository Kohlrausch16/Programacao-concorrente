import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        FileInteractions fileInt = new FileInteractions();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            char threadId = (char) ('A' + i);

            Thread thread = new Thread(() -> {
                for (int j = 0; j < 50; j++) {
                    int option = random.nextInt(1, 4);

                    switch (option) {
                        case 1 -> {
                            try {
                                fileInt.deposit(threadId);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        case 2 -> {
                            fileInt.readAmount();
                        }
                        case 3 -> {
                            fileInt.withdraw();
                        }
                    }

                    try {
                        Thread.sleep(random.nextInt(500, 1500)); // pausa entre ações
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            thread.start();
        }
    }
}
