package org.example;

import java.io.IOException;

import static org.example.Engine.swap;

public class Main {
    public static void main(String[] args) {
        String pathToJsonMap = "/home/luiz/dev/YamlTemplateEngine/YamlTemplateEngine/src/main/resources/jsonMap.json";
        String pathToYmlTemplate ="/home/luiz/dev/YamlTemplateEngine/YamlTemplateEngine/src/main/resources/template1.yml";
        String pathToSwappedYml = "/home/luiz/dev/YamlTemplateEngine/YamlTemplateEngine/src/main/resources/swappedFile.yml";

        try {
            swap(pathToJsonMap, pathToYmlTemplate, pathToSwappedYml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}