package edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.impl;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.model.ProductDocument;
import edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.ProductIndexService;
import edu.famous.E_Commerce_Product_Search.product_service.utils.indexing.DocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductIndexServiceImpl implements ProductIndexService {

    private final SolrClient solrClient;

    @Override
    public void indexProduct(Product product) throws Exception {
        // Convert the product to a ProductDocument
        ProductDocument productDocument = DocumentMapper.convertProductToDocument(product);
        // Save the ProductDocument to Solr
        solrClient.addBean("products", productDocument);
        try {
            solrClient.commit("products");
            log.info("Product indexed successfully: {}", product.getId());
        } catch (Exception e) {
            log.error("Error indexing product: {}", product.getId(), e);
            throw new RuntimeException("Failed to index product: " + product.getId(), e);
        }
    }

    @Override
    public void indexAllProducts(List<Product> products) throws Exception {
        // Fetch all products from the database
        int batchSize = 200;
        for (int i = 0; i < products.size(); i += batchSize) {
            List<ProductDocument> batch = products.stream()
                    .skip(i)
                    .limit(batchSize)
                    .map(DocumentMapper::convertProductToDocument)
                    .toList();
            // Add the batch of ProductDocuments to Solr
            solrClient.addBeans("products", batch);
            // Commit the changes to Solr
            try {
                solrClient.commit("products");
                log.info("Indexed batch of products from index {} to {}", i, i + batch.size() - 1);
            } catch (Exception e) {
                log.error("Error committing batch of products from index {} to {}", i, i + batch.size() - 1, e);
                throw new RuntimeException("Failed to commit batch of products", e);
            }
        }
    }
}
