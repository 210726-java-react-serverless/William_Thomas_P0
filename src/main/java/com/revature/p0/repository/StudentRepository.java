package com.revature.p0.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.revature.p0.models.Student;
import com.mongodb.client.model.*;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class StudentRepository {

    public Student save(Student student){
        System.out.println("registered " + student.getFirstName());

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            //throw new ResourcePersistenceException("Cannot find application.properties");
        }

        String ipAddress = prop.getProperty("ipAddress");
        int port = Integer.parseInt(prop.getProperty("port"));
        String dbName = prop.getProperty("dbName");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        try(MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(ipAddress, port))))
                        .credential(MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray()))
                        .build()
        )){
            MongoDatabase sdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> sCollection = sdb.getCollection("studentDB");
            Document sDoc = new Document("firstName", student.getFirstName())
                                .append("lastName", student.getLastName())
                                .append("emailAddress", student.getEmailAddress())
                                .append("username", student.getUsername())
                                .append("password", student.getPassword());

            sCollection.insertOne(sDoc);

            student.setId(sDoc.get("_id").toString());
            System.out.println(student);
        }


        return student;
    }

    public void login(String studentUsername, String studentPassword){

        Properties prop = new Properties();
        //Student student;

        try {
            prop.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            //throw new ResourcePersistenceException("Cannot find application.properties");
        }

        String ipAddress = prop.getProperty("ipAddress");
        int port = Integer.parseInt(prop.getProperty("port"));
        String dbName = prop.getProperty("dbName");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        try(MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(ipAddress, port))))
                        .credential(MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray()))
                        .build()
                )){
                MongoDatabase sdb = mongoClient.getDatabase("project0");
                MongoCollection<Document> sCollection = sdb.getCollection("studentDB");

                FindIterable<Document> docs = sCollection.
                        find(Filters.and(Filters.eq("username", studentUsername), Filters.eq("password", studentPassword)));
                for(Document doc : docs) {
                    System.out.println(doc);
                }

        }

       // Student student = new Student("a","a","a","a","a");
        //return student;
    }
}
