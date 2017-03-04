package ru.thesn.test_client;


import ru.thesn.test_client.command.CommandExecutor;
import ru.thesn.test_client.exception.InterruptOperationException;

public final class Start {

    public static void main(String[] args) {

        try {
            Operation operation;
            do {
                ConsoleHelper.writeMessage("\n Choose an operation: \n" +
                        " - Search files: 1;\n" +
                        " - Download files from the server: 2;\n" +
                        " - Delete file from the server: 3;\n" +
                        " - Exit: 4.");
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }

}
