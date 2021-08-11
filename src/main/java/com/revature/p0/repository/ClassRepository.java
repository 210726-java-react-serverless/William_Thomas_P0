package com.revature.p0.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.revature.p0.models.Classes;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class ClassRepository {

    public void add(Classes c){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");
            Document cDoc = new Document("subject", c.getSubject())
                    .append("code", c.getCode())
                    .append("classLevel", c.getLevel())
                    .append("description", c.getDescription());

            cCollection.insertOne(cDoc);

            c.setId(cDoc.get("_id").toString());
            System.out.println(c);
        }
    }

    public void remove(String cd){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            cCollection.deleteOne(Filters.eq("code", cd));
        }
    }

    public void edit(Classes c, String cd){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

        //    cCollection.updateOne(Filters.eq("code", cd),
      //              new Document("$set", new Document(Filters.and("subject", c.getSubject()), ("code", c.getCode()))));


            cCollection.updateOne(Filters.eq("code", cd),
                    new Document("$set", new Document("classLevel", c.getLevel())));

            cCollection.updateOne(Filters.eq("code", cd),
                    new Document("$set", new Document("subject", c.getSubject())));

            cCollection.updateOne(Filters.eq("code", cd),
                    new Document("$set", new Document("description", c.getDescription())));

            System.out.println(c);
        }
    }

    public void showAll(){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            FindIterable<Document> docs = cCollection.find();
            for (Document doc : docs){
                System.out.println("this " + doc);
            }

        }
    }

    public boolean empty(String cd){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            FindIterable<Document> docs = cCollection.find();
            for (Document doc : docs){
                System.out.println("this " + doc);
            }

        }

        return true;
    }

    public void register(String cd){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            String user = "username";
            FindIterable<Document> docs = cCollection.
                    find(Filters.eq("code", cd));

            for (int i = 0; i < 20; i++){
                FindIterable<Document> check = cCollection.find(Filters.exists(String.valueOf(i)));
                //for (Document check : checks) {
                    System.out.println("check is " + check);
                    if (check == null) {
                        cCollection.updateOne(Filters.eq("code", cd),
                                new Document("$set", new Document(String.valueOf(i), user)));
                        break;
                    }
                //}
            }

        }
    }

    public void drop(String cd) {
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

        try (MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(ipAddress, port))))
                        .credential(MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray()))
                        .build()
        )) {
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            String user = "username";
            cCollection.updateOne(Filters.eq("code", cd),
                    new Document("$set", new Document(user, user)));

            cCollection.deleteOne(Filters.eq(user, user));

        }
    }

    public void show(){
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
            MongoDatabase cdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> cCollection = cdb.getCollection("classDB");

            String user = "bill";

            FindIterable<Document> docs = cCollection.find(Filters.exists(user));
            for (Document doc : docs){
                System.out.println("this " + doc);
            }

        }
    }

}
