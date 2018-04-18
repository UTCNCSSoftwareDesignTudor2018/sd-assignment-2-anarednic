package mongoDB;

import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.Student;
import repo.StudentRepo;

public class EstablishConnection {

	public void getConnection() {

		try {
			MongoClient mongo = new MongoClient("127.0.0.1", 27017);
			MongoDatabase database = mongo.getDatabase("Grades");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSingleReport() {
		// Creating a Mongo client
		MongoClient mongo = new MongoClient("127.0.0.1", 27017);
		MongoDatabase database = mongo.getDatabase("Ana");
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("Students");
		StudentRepo srepo = new StudentRepo();
		List<Student> list = srepo.viewAllStudents();
		for (int i = 0; i < list.size(); i++) {
			Document document = new Document("name", list.get(i).getName()).append("e-mail", list.get(i).getEmail())
					.append("group", list.get(i).getGroup());
			collection.insertOne(document);
		}

		System.out.println("Document inserted successfully");
	}
}
