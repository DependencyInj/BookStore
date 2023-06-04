package com.bookstore.bookservice.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {

    @Autowired
    private AWSCredentialsProvider awsCredentialsProvider;

    @Value("${amazon.dynamodb.endpoint}")
    private String endPoint;


    @Bean
    AmazonDynamoDB getAmazonDynamoDB(){
        final AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, "us-east-1"))
                .withCredentials(awsCredentialsProvider)
                .build();
        return amazonDynamoDB;
    }

    @Bean
    DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(getAmazonDynamoDB());
    }
}
