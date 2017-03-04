package ru.thesn.test_client.command;


import okhttp3.Response;
import ru.thesn.test_client.ConsoleHelper;
import ru.thesn.test_client.Constants;
import ru.thesn.test_client.exception.InterruptOperationException;

import java.io.IOException;


final class FindFileCommand implements Command {


    private final static String URL_FORMAT = Constants.SERVER_URL + "find?keyword=%s&is_regexp=%s";

    @Override
    public void execute() throws InterruptOperationException {
        try {
            ConsoleHelper.writeMessage("Keyword?");
            String keyword = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Is your keyword regexp? (true/false)");
            String regexp = ConsoleHelper.readString();

            Response response = Connector.connect(String.format(URL_FORMAT, keyword, regexp));

            ConsoleHelper.writeMessage(response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
