package data.translations;

import data.enums.Languages;

import java.util.Map;

public final class Translations {

    public static Map<Languages, String> LOGIN_USERNAME = Map.ofEntries(
        Map.entry(Languages.ENGLISH, "Username"),
        Map.entry(Languages.SPANISH, "Nombre de usuario"),
        Map.entry(Languages.PORTUGUESE, "Nome de usuário"),
        Map.entry(Languages.FRENCH, "Nom d'utilisateur"),
        Map.entry(Languages.JAPANESE, "ユーザー名")
    );

    public static Map<Languages, String> LOGIN_PASSWORD = Map.ofEntries(
            Map.entry(Languages.ENGLISH, "Password"),
            Map.entry(Languages.SPANISH, "Contraseña"),
            Map.entry(Languages.PORTUGUESE, "Senha"),
            Map.entry(Languages.FRENCH, "Mot de passe"),
            Map.entry(Languages.JAPANESE, "パスワード")
    );

    public static Map<Languages, String> MENU_CATALOG_BUTTON = Map.ofEntries(
            Map.entry(Languages.ENGLISH, "Catalog"),
            Map.entry(Languages.SPANISH, "Catálogo"),
            Map.entry(Languages.PORTUGUESE, "Catálogo"),
            Map.entry(Languages.FRENCH, "Catalogue"),
            Map.entry(Languages.JAPANESE, "カタログ")
    );

}
