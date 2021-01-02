package com.dynamo.demo.controller;

import com.dynamo.demo.dao.CatalogEntryRepository;
import com.dynamo.demo.entity.CatalogEntry;
import com.dynamo.demo.entity.CatalogEntryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catentry")
public class CatalogEntryController {

    @Autowired
    private CatalogEntryRepository catalogEntryRepository;

    @PostMapping
    public CatalogEntry saveCatalogEntry(@RequestBody CatalogEntry catalogEntry){
        return catalogEntryRepository.save(catalogEntry);
    }

    @GetMapping("/{catalogEntryId}")
    public CatalogEntry getCatalogEntry(@PathVariable("catalogEntryId") String catalogEntryId){
        return catalogEntryRepository.getCatalogEntryById(catalogEntryId);
    }

    @DeleteMapping("/{catalogEntryId}")
    public String deleteCatalogEntry(@PathVariable("catalogEntryId") String catalogEntryId){
        return catalogEntryRepository.delete(catalogEntryId);
    }

    @PutMapping("/{catalogEntryId}")
    public String updateCatalogEntry(@PathVariable("catalogEntryId") String catalogEntryId, @RequestBody CatalogEntry catalogEntry){
        return catalogEntryRepository.update(catalogEntryId,catalogEntry);
    }

}
