package ru.thesn.test_client.command;


import ru.thesn.test_client.ConsoleHelper;
import ru.thesn.test_client.Operation;
import ru.thesn.test_client.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public final class CommandExecutor {
    private static Map<Operation, Command> map = new HashMap<>();

    static {
        map.put(Operation.FIND_FILE, new FindFileCommand());
        map.put(Operation.DOWNLOAD_FILE, new DownloadFileCommand());
        map.put(Operation.DELETE_FILE, new DeleteFileCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {
    }

    public static void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
    }

}
