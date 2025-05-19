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
import utils.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

public class MongoDbClient {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void open() {
        var connectionString = ConfigurationReader.getMongodbConnectionString();
        var dbName = ConfigurationReader.getMongodbDatabaseName();

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

        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase(dbName);
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    protected static void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
        System.out.println("Document inserted: " + document.toJson());
    }

    protected static List<Document> findAllDocuments(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find().into(new ArrayList<>());
    }

    protected static Document findDocument(String collectionName, String key, Object value) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find(Filters.eq(key, value)).first();
    }

    protected static void updateDocument(String collectionName, String key, Object value, String updateKey, Object updateValue) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.updateOne(Filters.eq(key, value), Updates.set(updateKey, updateValue));
        System.out.println("Document updated where " + key + " = " + value);
    }

    protected static void deleteDocument(String collectionName, String key, Object value) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteOne(Filters.eq(key, value));
        System.out.println("Document deleted where " + key + " = " + value);
    }

    protected static void deleteAllDocuments(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.deleteMany(new Document()); // Deletes all documents
        System.out.println("All documents deleted from collection: " + collectionName);
    }
}
