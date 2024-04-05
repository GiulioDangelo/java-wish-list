import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Gift> giftList = new ArrayList<>();
        boolean flag = true;

        Scanner scan = new Scanner(System.in);

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
                System.out.println(giftList);
            }
        }

        scan.close();
    }
}
