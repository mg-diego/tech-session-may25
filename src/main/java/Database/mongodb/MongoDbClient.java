package Database.mongodb;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.codecs.UuidCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.ArrayList;
import java.util.List;

public class MongoDbClient {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public MongoDbClient() {
        var connectionString = "mongodb://localhost:27017";
        var dbName = "testing-sample-app";

        // Create a CodecRegistry that includes the UUID codec
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromCodecs(new UuidCodec(UuidRepresentation.STANDARD))
        );

        // Create MongoClientSettings with the custom CodecRegistry
        MongoClientSettings settings = MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .codecRegistry(codecRegistry)
                .build();

        this.mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase(dbName);
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
        System.out.println("Document inserted: " + document.toJson());
    }

    public static List<Document> findAllDocuments(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find().into(new ArrayList<>());
    }

    public static Document findDocument(String collectionName, String key, Object value) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(Filters.eq(key, value)).first();
    }

    public static void updateDocument(String collectionName, String key, Object value, String updateKey, Object updateValue) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(Filters.eq(key, value), Updates.set(updateKey, updateValue));
        System.out.println("Document updated where " + key + " = " + value);
    }

    public static void deleteDocument(String collectionName, String key, Object value) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(Filters.eq(key, value));
        System.out.println("Document deleted where " + key + " = " + value);
    }

    public static void deleteAllDocuments(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteMany(new Document()); // Deletes all documents
        System.out.println("All documents deleted from collection: " + collectionName);
    }
}
