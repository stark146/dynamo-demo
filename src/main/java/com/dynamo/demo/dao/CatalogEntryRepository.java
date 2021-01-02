package com.dynamo.demo.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynamo.demo.entity.CatalogEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogEntryRepository {

    @Autowired
    private DynamoDBMapper dynamoDbMapper;

    public CatalogEntry save (CatalogEntry catalogEntry){
        dynamoDbMapper.save(catalogEntry);
        return catalogEntry;
    }

    public CatalogEntry getCatalogEntryById(String catalogEntryId){
        return dynamoDbMapper.load(CatalogEntry.class,catalogEntryId);
    }

    public CatalogEntry getAllCatalogEntries(String catalogEntryId){
        return dynamoDbMapper.load(CatalogEntry.class,catalogEntryId);
    }

    public String delete(String catalogEntryId){
        CatalogEntry catalogEntry = dynamoDbMapper.load(CatalogEntry.class,catalogEntryId);
        dynamoDbMapper.delete(catalogEntry);
        return "CatalogEntry Deleted";
    }

    public String update(String catalogEntryId,CatalogEntry catalogEntry){
        dynamoDbMapper.save(catalogEntry,
                new DynamoDBSaveExpression().withExpectedEntry("catalogEntryId",
                        new ExpectedAttributeValue(new AttributeValue().withS(catalogEntryId))));
        return catalogEntryId;
    }
}
