package com.tsimul.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.OrgJsonUtil;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;

public class Util {

    public static final long MAXIMUM_CACHE_SIZE = 1000L;
    public static final String CONFIG_JSON_SCHEMA_FILE_PATH = "src/main/java/com/tsimul/configuration/schema-v1.json";
    public static final String CONFIG_JSON_SCHEMA_KEY = "configJsonSchema";
    public static final Cache<String, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(MAXIMUM_CACHE_SIZE)
            .build();

    private Util() {}

    /**
     * Validate the json data against the schema
     * @param data json data to be validate
     * @return true if the data is valid and false otherwise
     */
    public static boolean isValidConfiguration(String data)  {
        try {
            Schema jsonSchema = (Schema) cache.get(CONFIG_JSON_SCHEMA_KEY,
                    () -> {
                        JSONObject rawSchema = new JSONObject(
                                new JSONTokener(new FileInputStream(CONFIG_JSON_SCHEMA_FILE_PATH))
                        );
                        return SchemaLoader.builder()
                                .schemaJson(rawSchema)
                                .draftV7Support()
                                .build().load().build();
                    });
            System.out.println(jsonSchema.getDescription());
            jsonSchema.validate(new JSONObject(data));
        } catch (ValidationException | ExecutionException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * This is to avoid creating again the JsonObject from data
     * @param data json data to be validate
     * @return true if the data is valid and false otherwise
     */
    public static boolean isValidConfiguration(JSONObject data)  {
        try {
            Schema jsonSchema = (Schema) cache.get(CONFIG_JSON_SCHEMA_KEY,
                    () -> {
                        JSONObject rawSchema = new JSONObject(
                                new JSONTokener(new FileInputStream(CONFIG_JSON_SCHEMA_FILE_PATH))
                        );
                        return SchemaLoader.builder()
                                .schemaJson(rawSchema)
                                .draftV7Support()
                                .build().load().build();
                    });
            System.out.println(jsonSchema.getDescription());
            jsonSchema.validate(data);
        } catch (ValidationException | ExecutionException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ExecutionException {
        String dataPath = "src/main/java/com/tsimul/configuration/example.json";
        String data = new String(Files.readAllBytes(Paths.get(dataPath)));
        System.out.println(isValidConfiguration(data));
        System.out.println(OrgJsonUtil.toMap(new JSONObject(data)));


    }

}
