package Database.mongodb;

import data.models.Catalog;
import org.bson.Document;
import org.bson.types.ObjectId;
import utils.ConfigurationReader;


public class CatalogDatabaseClient extends MongoDbClient {

    private static String collectionName = ConfigurationReader.getMongodbCatalogCollectionName();


    public static void insertCatalog(Catalog catalog) {
        Document document = new Document("_id", catalog.id != null ? new ObjectId(catalog.id) : new ObjectId())
                .append("name", catalog.name)
                .append("description", catalog.description);

        insertDocument(collectionName, document);
    }

    public static String getCatalogIdByName(String catalogName) {
        var doc = findDocument(collectionName, "name", catalogName);
        return doc != null ? doc.getObjectId("_id").toString() : null;
    }

    public static void clearCatalogCollection() {
        open();
        deleteAllDocuments("catalog");
    }
}
