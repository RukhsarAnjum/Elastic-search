package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Product;
import java.util.Map;

public interface HighLevelClientProductService {

    Product getProduct(String id);

    Map<String, Long> aggregateTerm(String term);

    Product createProduct(Product product);

    boolean deleteProduct(String id);

    boolean createProductIndex();
}