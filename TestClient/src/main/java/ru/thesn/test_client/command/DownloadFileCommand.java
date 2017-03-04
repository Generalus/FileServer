package ru.thesn.test_client.command;


import okhttp3.Response;
import ru.thesn.test_client.ConsoleHelper;
import ru.thesn.test_client.Constants;
import ru.thesn.test_client.exception.InterruptOperationException;

import java.io.FileOutputStream;
import java.io.IOException;

final class DownloadFileCommand implements Command {

    private final static String URL_FORMAT = Constants.SERVER_URL + "download?hash=%s";

    @Override
    public void execute() throws InterruptOperationException {
        try {
            ConsoleHelper.writeMessage("Hash?");
            String hash = ConsoleHelper.readString();

            ConsoleHelper.writeMessage("Choose filename:");
            String filename = ConsoleHelper.readString();

            Response response = Connector.connect(String.format(URL_FORMAT, hash));
            FileOutputStream fos = new FileOutputStream(Constants.ROOT_FOLDER + filename);
            fos.write(response.body().bytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
