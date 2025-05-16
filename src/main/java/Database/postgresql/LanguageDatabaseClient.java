package Database.postgresql;


public class LanguageDatabaseClient extends PostgresqlClient {

    public static void updateLanguageTo(String language) {
        try {
            openConnection();
            executeUpdate(String.format("UPDATE public.languages SET active = false WHERE language != '%s'", language));
            executeUpdate(String.format("UPDATE public.languages SET active = true WHERE language = '%s'", language));
        } finally {
            closeConnection();
        }
    }
}
