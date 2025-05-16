package utils;

import data.enums.Languages;
import data.translations.Translations;

import java.lang.reflect.Field;
import java.util.Map;

public class Translator {

    private static final String TRANSLATIONS_SUBKEY = "TRANSLATIONS.";

    public static String getTranslation(String key, Languages language) {
        try {
            Field field = Translations.class.getDeclaredField(key.replace(TRANSLATIONS_SUBKEY, ""));
            field.setAccessible(true);
            Map<Languages, String> translations = (Map<Languages, String>) field.get(null);

            return translations.getOrDefault(language, key);
        } catch (NoSuchFieldException e) {
            return "Translation not found";
        } catch (IllegalAccessException e) {
            return "Access error";
        }
    }
}
