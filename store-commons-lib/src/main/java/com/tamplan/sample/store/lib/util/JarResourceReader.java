package com.tamplan.sample.store.lib.util;

import com.tamplan.sample.store.lib.exception.GenericException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JarResourceReader {

    private JarResourceReader() {
    }

    public static String readFile(String fileName) {
        return new String(readFileAsBytes(fileName), StandardCharsets.UTF_8);
    }

    public static byte[] readFileAsBytes(String fileName) {
        try(InputStream is = JarResourceReader.class.getResourceAsStream("/" + fileName)) {
            int ch = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            while ((ch = is.read()) != -1) {
                bos.write(ch);
            }

            bos.close();

            return bos.toByteArray();

        } catch (IOException e) {
            throw new GenericException(e);
        }
    }
}
