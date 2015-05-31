package fi.monkeyball.repl;

import jline.console.ConsoleReader;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by juho on 31/05/15.
 */
public class ChezzRepl {

    public static void main(String[] args) throws IOException {
        ConsoleReader reader = new ConsoleReader();


        reader.setPrompt("chezz> ");
        boolean color = true;

        String line;
        PrintWriter out = new PrintWriter(reader.getOutput());

        while ((line = reader.readLine()) != null) {
            if(line.trim().isEmpty()) {
                continue;
            }
            if (color){
                out.println("\u001B[33m======>\u001B[0m\"" + line + "\"");

            } else {
                out.println("======>\"" + line + "\"");
            }
            out.flush();


            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                break;
            }
            if (line.equalsIgnoreCase("cls")) {
                reader.clearScreen();
            }

            reader.setPrompt("chezz[" + line + "]> ");
        }
    }
}
