package MVP;

//add, remove, import, export, ask, exit

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Commands {

    static public void add(LinkedHashMap flashCards, Scanner scan) {
        String card, defin;
        System.out.println("The card:");
        card = scan.nextLine();
        if (flashCards.containsKey(card)) {
            System.out.println("The card \"" + card + "\" already exists.\n");
        } else {
            System.out.println("The definition of the card:");
            defin = scan.nextLine();
            if (flashCards.containsValue(defin)) {
                System.out.println("The definition \"" + defin + "\" already exists.\n");
            } else {
                flashCards.put(card, defin);
                System.out.println("The pair (\"" + card + "\":\"" + defin + "\") has been added.\n");
            }
        }
    }

    static public void remove(LinkedHashMap flashCards, Scanner scan) {
        String card;
        System.out.println("The card:");
        card = scan.nextLine();
        if (flashCards.containsKey(card)) {
            flashCards.remove(card);
            System.out.println("The card has been removed.\n");
        } else {
            System.out.println("Can't remove \"" + card + "\": there is no such card.\n");
        }
    }

    static public void exit() {
        System.out.println("Bye Bye!");
        System.exit(69);
    }

    static public void importCmd(LinkedHashMap flashCards, Scanner scan) {
        System.out.println("File name:");
        String fileName = scan.nextLine();
        String workingDir = System.getProperty("user.dir");
        String systemName = System.getProperty("os.name").split(" ")[0];
        File importFile = null;
        String lineFromFile;
        if (systemName.equals("Windows")) {
            importFile = new File(workingDir + "\\" + fileName);
        } else if (systemName.equals("Mac")) {
            importFile = new File (workingDir + "/" + systemName);
        }
        if (!importFile.isFile()) {
            System.out.println("File not found.\n");
            return;
        }
        try (Scanner scanFile = new Scanner(importFile)) {
            int i = 0;
            while (scanFile.hasNext()) {
                lineFromFile = scanFile.nextLine();
                flashCards.put(lineFromFile.split(" ")[0], lineFromFile.split(" ")[1]);
                i++;
            }
            if (i > 1) {
                System.out.println(i + " cards have been loaded.\n");
            } else if (i == 1) {
                System.out.println("1 card has been loaded.\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.\n");
            return;
        }
    }

    static public void ask(LinkedHashMap<String, String> flashCards, Scanner scan) {
        System.out.println("How many times to ask?");
        int timesToAsk = Integer.parseInt(scan.nextLine());
        int i = 0;
        String tmpValue, tmpKey = null;
        while (i < timesToAsk) {
            for (var elem : flashCards.entrySet()) {
                if (i < timesToAsk) {
                    System.out.println("Print the definition of \"" + elem.getKey() + "\":");
                    tmpValue = scan.nextLine();
                    if (tmpValue.equals(elem.getValue())) {
                        System.out.println("Correct answer.");
                        i++;
                    } else if (flashCards.containsValue(tmpValue)) {
                        for (var element : flashCards.entrySet()) {
                            if (element.getValue().equals(tmpValue)) {
                                tmpKey = element.getKey();
                                break;
                            }
                        }
                        System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\", you've just " +
                            "written the definition of \"" + tmpKey + "\".");
                        i++;
                    } else {
                        System.out.println("Wrong answer. The correct one is \"" + elem.getValue() + "\".");
                        i++;
                    }
                }
            }
        }
        System.out.println("");
    }

    static public void exportCmd(LinkedHashMap<String, String> flashCards, Scanner scan) {
        System.out.println("File name:");
        String fileName = scan.nextLine();
        int i = 0;
        String workingDir = System.getProperty("user.dir");
        String systemName = System.getProperty("os.name").split(" ")[0];
        File exportFile = null;
        if (systemName.equals("Windows")) {
            exportFile = new File(workingDir + "\\" + fileName);
        } else if (systemName.equals("Mac")) {
            exportFile = new File (workingDir + "/" + systemName);
        }
        try {
            if (!exportFile.createNewFile()) {
                System.out.println("The file is already created.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Exception happened.");
        }
        for (var elem : flashCards.entrySet()) {
            writeUsingFileWriter(elem.getKey() + " " + elem.getValue(), exportFile);
            i++;
        }
        if (i > 1) {
            System.out.println(i + " cards have been saved.\n");
        } else if (i == 1) {
            System.out.println("1 card has been saved.\n");
        }



    }

    private static void writeUsingFileWriter(String data, File FileToWrite) {
        FileWriter fr = null;
        try {
            fr = new FileWriter(FileToWrite);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
