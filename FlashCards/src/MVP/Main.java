package MVP;

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
//        System.out.println("Input the number of cards:");
//        int size = Integer.parseInt(scan.nextLine());
//        String tmpKey = null, tmpValue;
//        for (int i = 0; i < size; i++) {
//            System.out.println("The card #" + (i + 1) + ":");
//            outerloop:
//            while (true) {
//                tmpKey = scan.nextLine();
//                if (!flashCard.containsKey(tmpKey)) {
//                    System.out.println("The definition of the card #" + (i + 1) + ":");
//                    while (true) {
//                        tmpValue = scan.nextLine();
//                        if (!flashCard.containsValue(tmpValue)) {
//                            flashCard.put(tmpKey, tmpValue);
//                            break outerloop;
//                        } else {
//                            System.out.println("The definition \"" + tmpValue + "\" already exists. Try again:");
//                        }
//                    }
//                } else {
//                    System.out.println("The card \"" + tmpKey + "\" already exists. Try again:");
//                }
//            }
//        }
//        for (var elem : flashCard.entrySet()) {
//            System.out.println("Print the definition of \"" + elem.getKey() + "\":");
//            tmpValue = scan.nextLine();
//            if (tmpValue.equals(elem.getValue())) {
//                System.out.println("Correct answer.");
//            } else if (flashCard.containsValue(tmpValue)) {
//                for (var element : flashCard.entrySet()) {
//                    if (element.getValue().equals(tmpValue)) {
//                        tmpKey = element.getKey();
//                        break;
//                    }
//                }
//                System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\", you've just " +
//                        "written the definition of \"" + tmpKey + "\".");
//            } else {
//                System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\".");
//            }
//        }
    }
}
