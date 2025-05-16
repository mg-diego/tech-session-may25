package data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum Languages {
    ENGLISH("en"),
    SPANISH("es"),
    PORTUGUESE("pt"),
    FRENCH("fr"),
    JAPANESE("jp");

    @Getter
    private String locale;

    private static final Map<String, Languages> localeToLanguageMap = new HashMap<>();

    static {
        for (Languages language : Languages.values()) {
            localeToLanguageMap.put(language.getLocale(), language);
        }
    }

    public static Languages fromLocale(String locale) {
        return localeToLanguageMap.get(locale);
    }
}
