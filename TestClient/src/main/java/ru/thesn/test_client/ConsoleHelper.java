package ru.thesn.test_client;

import ru.thesn.test_client.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public final class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String s = "";
        try {
            s = reader.readLine();
        } catch (IOException e) {
            writeMessage("Incorrect string");
        }
        if (s.equalsIgnoreCase("exit")) {
            throw new InterruptOperationException();
        }
        return s;
    }


    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException e) {
                writeMessage("Please write a number!");
            } catch (IllegalArgumentException e) {
                writeMessage("Incorrect operation!");
            }
        }
    }

    public static void printExitMessage() {
        writeMessage("Good luck!");
    }
}
