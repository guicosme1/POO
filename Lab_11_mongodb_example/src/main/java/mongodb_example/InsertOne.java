package mongodb_example;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class InsertOne {
    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
    	  String uri = "mongodb+srv://poo:poo@cluster0.5098y.mongodb.net/?retryWrites=true&w=majority";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> collection = database.getCollection("movies");

            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("title", "Ski Bloopers (llcostalonga 2022/2)")
                        .append("genres", Arrays.asList("Documentary", "Comedy")));

                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }
}
