package Database.mongodb;

import data.Catalog;
import org.bson.Document;

import java.util.Objects;
import java.util.UUID;

public class CatalogDatabaseClient extends MongoDbClient {

    private String collectionName = "catalog";

    public void insertCatalog(Catalog catalog) {
        Document document = new Document("_id", !Objects.equals(catalog.id, "") ? catalog.id : UUID.randomUUID())
                .append("name", catalog.name)
                .append("description", catalog.description);

        super.insertDocument(collectionName, document);
    }
}
