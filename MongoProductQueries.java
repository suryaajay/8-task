import com.mongodb.client.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class MongoProductQueries {
    public static void main(String[] args) {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("productdb");
        MongoCollection<Document> collection = database.getCollection("products");

        System.out.println("1) All product info:");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n2) Products priced between 400 and 800:");
        for (Document doc : collection.find(and(gte("price", 400), lte("price", 800)))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n3) Products NOT priced between 400 and 600:");
        for (Document doc : collection.find(not(and(gte("price", 400), lte("price", 600))))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n4) First 4 products priced above 500:");
        for (Document doc : collection.find(gt("price", 500)).limit(4)) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n5) Product name and material of all:");
        for (Document doc : collection.find().projection(fields(include("name", "material"), excludeId()))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n6) Product with row id 10:");
        Document doc6 = collection.find(eq("id", 10)).first();
        System.out.println(doc6 != null ? doc6.toJson() : "No product found.");

        System.out.println("\n7) Only name and material:");
        for (Document doc : collection.find().projection(fields(include("name", "material"), excludeId()))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n8) Products with 'soft' in material:");
        for (Document doc : collection.find(regex("material", ".*soft.*", "i"))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n9) Products with color 'indigo' and price 492.0:");
        for (Document doc : collection.find(and(eq("color", "indigo"), eq("price", 492.0)))) {
            System.out.println(doc.toJson());
        }

        System.out.println("\n10) Deleting products with price 28...");
        collection.deleteMany(eq("price", 28));
        System.out.println("Deleted.");
        
        mongoClient.close();
    }
}
