package com.changfeng.codegen;

import io.github.swagger2markup.Swagger2MarkupConverter;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ChangFeng on 2017/7/12.
 */
public class SwaggerAndAsciiDocGenerator {

    public static final String TARGET_URL = "http://localhost:port/applicationName/v2/api-docs";

    public static void main(String[] args) throws IOException {
        Path asciiDocTargetFolder = Paths.get(args[0]);

        System.out.println("Generating AsciiDoc in " + asciiDocTargetFolder);
        convertSwaggerToAsciiDoc(asciiDocTargetFolder);
        System.out.println("Done.");
    }

    private static void convertSwaggerToAsciiDoc(Path asciiDocTargetFolder) {
        try {
            System.out.println("start to get swagger.json from giving url: " + TARGET_URL);
            Swagger2MarkupConverter.from(new URL(TARGET_URL))
                    .build()
                    .toFolder(asciiDocTargetFolder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}