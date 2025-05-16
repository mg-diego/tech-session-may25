package TestContext;

import DriverManager.WebDriverManager;
import data.enums.Languages;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class TestContext {
    @Getter
    @Setter
    private WebDriverManager webDriverManager;

    @Getter
    @Setter
    private String token;

    @Getter
    @Setter
    private Response lastResponse;

    @Getter
    @Setter
    private Languages currentLanguage;

    private Map<String, String> storage;

    public void addToStorage(String key, String value) {
        this.storage.put(key, value);
    }

    public String getFromStorage(String key) {
        return this.storage.get(key);
    }
}
