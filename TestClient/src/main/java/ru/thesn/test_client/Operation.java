package ru.thesn.test_client;


public enum Operation {
    FIND_FILE, DOWNLOAD_FILE, DELETE_FILE, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {
        switch (i) {
            case 1:
                return FIND_FILE;
            case 2:
                return DOWNLOAD_FILE;
            case 3:
                return DELETE_FILE;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}
