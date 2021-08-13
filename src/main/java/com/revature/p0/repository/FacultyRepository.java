package com.revature.p0.repository;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class FacultyRepository {

    public boolean login(String facultyUsername, String facultyPassword) {
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
                        .applyToClusterSettings(builder -> builder.hosts(Arrays.asList(
                                new ServerAddress(ipAddress, port))))
                        .credential(MongoCredential.createScramSha1Credential(
                                username, dbName, password.toCharArray()))
                        .build()
        )) {
            MongoDatabase fdb = mongoClient.getDatabase("project0");
            MongoCollection<Document> fCollection = fdb.getCollection("facultyDB");

            boolean result = false;
            FindIterable<Document> docs = fCollection.
                    find(Filters.and(Filters.eq("username", facultyUsername),
                            Filters.eq("password", facultyPassword)));
            for (Document doc : docs) {
                if (doc != null){
                    result = true;
                }
            }

            return result;
        }
    }
}
