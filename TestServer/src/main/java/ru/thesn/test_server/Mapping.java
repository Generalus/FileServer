package ru.thesn.test_server;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class Mapping {

    private static Mapping instance;

    private final Map<String, String> md5ToName = getInitialHashToFilenameFromRootDirectoryMapping();

    private Mapping() {

    }

    public static Mapping getInstance() {
        if (instance == null) {
            instance = new Mapping();
        }
        return instance;
    }

    private static String getMd5ForFile(File file) {
        String value = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            value = DigestUtils.md5Hex(IOUtils.toByteArray(inputStream));
        } catch (IOException e) {
            System.out.println("There is an error: " + e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return value;
    }

    public Map<String, String> getMd5ToName() {
        return md5ToName;
    }

    private Map<String, String> getInitialHashToFilenameFromRootDirectoryMapping() {
        Map<String, String> result = new HashMap<>();
        File directory = new File(Constants.ROOT_FOLDER);
        if (!directory.isDirectory() || directory.listFiles() == null) {
            return result;
        }
        for (File file : directory.listFiles()) {
            result.put(getMd5ForFile(file), file.getName());
        }
        return result;
    }


}
