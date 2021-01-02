package com.dynamo.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class CatalogEntryType {

    @DynamoDBAttribute
    private String catalogEntryTypeId;
    @DynamoDBAttribute
    private String catalogEntryType;
}
