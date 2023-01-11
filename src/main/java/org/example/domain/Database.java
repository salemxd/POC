package org.example.domain;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;

public class Database {
    private final String DYNAMODB_TABLE_NAME = System.getenv("TABLE_NAME");
    private final DynamoDB dynamoDb = new DynamoDB(AmazonDynamoDBClientBuilder.defaultClient());

    public void UploadPerson(Person person){
        dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                .putItem(new PutItemSpec().withItem(new Item().withNumber("id", person.getId()).withString("name", person.getName())));
    }
}
//.withString("name", person.getName()