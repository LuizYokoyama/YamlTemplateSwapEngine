package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Engine {

    public static final String REGEX_START = Pattern.quote("{{");
    public static final String REGEX_END = Pattern.quote("}}");
    public static final Pattern PATTERN = Pattern.compile(REGEX_START + "(.*?)" + REGEX_END);


    public static void swap(String pathToJsonMap, String pathToYmlTemplate, String pathToSwappedYml) throws IOException {

        File swappedFile = new File(pathToSwappedYml);
        File jsonSourceMap = new File(pathToJsonMap);
        String templateYML = new String(Files.readAllBytes(Paths.get(pathToYmlTemplate)));

        Map<String,Object> valuesMap =
                new ObjectMapper().readValue(jsonSourceMap, HashMap.class);

        Matcher matcher = PATTERN.matcher(templateYML);

        int lastIndex = 0;
        StringBuilder output = new StringBuilder();

        // Check for matches
        while (matcher.find()) {
            String value = matcher.group(1);
            if ( valuesMap.containsKey(value)){
                output.append(templateYML, lastIndex, matcher.start())
                        .append(valuesMap.get(value));
                lastIndex = matcher.end();
            }
        }

        // Print
        System.out.println("\n- Template file:\n\n" + templateYML);
        System.out.println("\n- Swapped file:\n\n" + output);

        FileWriter wr = new FileWriter(swappedFile);
        wr.write(output.toString());

        //flushing the writer
        wr.flush();

        //closing the writer
        wr.close();

    }

}
