package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigurationReader {
    private static JSONObject config;
    private static String CONFIGURATION_FILE_PATH = "\\src\\main\\java\\Configuration.json";

    public static void loadConfiguration() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + CONFIGURATION_FILE_PATH)));
            config = new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWebUrl() {
        return config.getString("webUrl");
    }

    public static String getMongodbConnectionString() {
        return getMongodbConfig()
                .getString("connectionString");
    }

    public static String getMongodbDatabaseName() {
        return getMongodbConfig()
                .getString("databaseName");
    }

    public static String getMongodbCatalogCollectionName() {
        return getMongodbConfig()
                .getString("catalogCollection");
    }

    public static String getPostgresqlConnectionString() {
        return getPostgresqlConfig()
                .getString("connectionString");
    }

    public static String getPostgresqlDatabaseName() {
        return getPostgresqlConfig()
                .getString("databaseName");
    }

    public static String getPostgresqlUser() {
        return getPostgresqlConfig()
                .getString("user");
    }

    public static String getPostgresqlPassword() {
        return getPostgresqlConfig()
                .getString("password");
    }

    public static String getApiBaseUrl() {
        return config.getString("apiBaseUrl");
    }

    public static int getUserManagementPort() {
        return getEndpointsObject().getInt("userManagement");
    }

    public static int getCatalogPort() {
        return getEndpointsObject().getInt("catalog");
    }

    public static int getLanguagePort() {
        return getEndpointsObject().getInt("language");
    }

    public static String getDefaultUser() {
        return config.getString("defaultUser");
    }

    public static String getDefaultPassword() {
        return config.getString("defaultPassword");
    }

    private static JSONObject getMongodbConfig() {
        return config
                .getJSONObject("database")
                .getJSONObject("mongodb");
    }

    private static JSONObject getPostgresqlConfig() {
        return config
                .getJSONObject("database")
                .getJSONObject("postgresql");
    }

    private static JSONObject getEndpointsObject() {
        return config.getJSONObject("endpoints");
    }
}
