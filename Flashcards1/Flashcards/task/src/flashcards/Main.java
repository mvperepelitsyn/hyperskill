package flashcards;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> flashCard = new LinkedHashMap<>();
        String cmd;
        while (true) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            cmd = scan.nextLine();
            if (cmd != null) {
                if (cmd.equals("add")) {
                    Commands.add(flashCard, scan);
                } else if (cmd.equals("remove")) {
                    Commands.remove(flashCard, scan);
                } else if (cmd.equals("exit")) {
                    Commands.exit();
                } else if (cmd.equals("import")) {
                    Commands.importCmd(flashCard, scan);
                } else if (cmd.equals("ask")) {
                    Commands.ask(flashCard, scan);
                } else if (cmd.equals("export")) {
                    Commands.exportCmd(flashCard, scan);
                }
            }
        }
    }
}
