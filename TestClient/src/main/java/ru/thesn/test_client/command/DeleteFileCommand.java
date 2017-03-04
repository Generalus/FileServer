package ru.thesn.test_client.command;


import okhttp3.Response;
import ru.thesn.test_client.ConsoleHelper;
import ru.thesn.test_client.Constants;
import ru.thesn.test_client.exception.InterruptOperationException;

import java.io.IOException;

final class DeleteFileCommand implements Command {

    private final static String URL_FORMAT = Constants.SERVER_URL + "delete?hash=%s";

    @Override
    public void execute() throws InterruptOperationException {
        try {
            ConsoleHelper.writeMessage("Hash?");
            String hash = ConsoleHelper.readString();
            Response response = Connector.connect(String.format(URL_FORMAT, hash));
            ConsoleHelper.writeMessage(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
