package presentation;
import java.util.Scanner;

public class Menu {
    private Scanner in;
    private String[] options;

    Menu(String[] entries) {
        in = new Scanner(System.in);
        in.useDelimiter("[\r\n]");
        this.options = entries;
    }

    public int showMenu() {
        int option = 0;
        System.out.println("\n                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("                                       * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        for(int i = 0 ; i < options.length ; i++){
            System.out.println(options[i]);
        }
        System.out.println("                                                 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  ");
        while(option <= 0 || option > options.length) {
            option = readInt("\nIndique a opção desejada: \n");
            System.out.println("\n");
            if (option == 0 )
                break;
            if (option < 0 || option > options.length)
                System.out.println("\n> Opção inválida!\n");

        }

        return option;
    }


    public String readString (String msg){
        System.out.println(msg);
        return in.next();
    }

    public int readInt(String msg) {
        int num;

        try {
            System.out.print(msg + "\n");
            num = Integer.parseInt(in.next());
        } catch (NumberFormatException e) {
            System.out.println("\n> O valor introduzido não é válido!\n");
            num = readInt(msg);
        }

        return num;
    }
}
