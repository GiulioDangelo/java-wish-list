import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Gift> giftList = new ArrayList<>();
        boolean flag = true;

        Scanner scan = new Scanner(System.in);

        try(Scanner fileReader = new Scanner(new File("./resources/data.txt"))){
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                System.out.println(line + "aggiunto alla lista");
                giftList.add(new Gift(line));
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }

        while (flag) {
            System.out.println("che regalo vuoi aggiungere alla lista?");
            String inputRegalo = scan.nextLine();

            Gift nuovoRegalo = new Gift(inputRegalo);
            giftList.add(nuovoRegalo);
            System.out.println(giftList.size());

            System.out.println("vuoi aggiungere un altro regalo?");
            String risposta = scan.nextLine();

            if (risposta.equals("no")) {
                flag = false;
                Collections.sort(giftList, new Comparator<Gift>() {
                    @Override
                    public int compare(Gift gift1, Gift gift2) {
                        return gift1.toString().compareTo(gift2.toString());
                    }
                });

                System.out.println(giftList);

                try (FileWriter fileWriter = new FileWriter("./resources/data.txt")) {
                    for (Gift gift : giftList) {
                        fileWriter.write(gift + "\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        scan.close();
    }
}
