package com.casumo.store.lib.util;

import com.casumo.store.lib.exception.GenericException;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class VersionReader {

    private VersionReader() {
    }

    public static String readVersionInfo() {
        StringBuilder strBuilder = new StringBuilder();

        String gitVersionContent = JarResourceReader.readFile("git.properties");

        Properties propGit = new Properties();

        try {
            propGit.load(new StringReader(gitVersionContent));

            String commitId = propGit.getProperty("git.commit.id");

            if ( commitId != null && !commitId.isBlank() ) {
                strBuilder.append("commitId=").append(commitId);
            }

            String commitDate = propGit.getProperty("git.commit.time");

            if ( commitDate != null && !commitDate.isBlank() ) {
                strBuilder.append(" commitDate=").append(commitDate);
            }

            String tags = propGit.getProperty("git.tags");

            if ( tags != null && !tags.isBlank() ) {
                strBuilder.append(" tags=").append(tags);
            }

            return strBuilder.toString().replace('\n', ' ').replace('\r', ' ');

        } catch (IOException e) {
            throw new GenericException(e);
        }

    }
}
