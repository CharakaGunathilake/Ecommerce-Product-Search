package edu.famous.E_Commerce_Product_Search.product_service.service.impl;

import edu.famous.E_Commerce_Product_Search.product_service.entity.Brand;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Category;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Discount;
import edu.famous.E_Commerce_Product_Search.product_service.exception.custom.*;
import edu.famous.E_Commerce_Product_Search.product_service.dto.request.ProductRequestDto;
import edu.famous.E_Commerce_Product_Search.product_service.dto.response.ProductResponseDto;
import edu.famous.E_Commerce_Product_Search.product_service.entity.Product;
import edu.famous.E_Commerce_Product_Search.product_service.enums.ProductStatus;
import edu.famous.E_Commerce_Product_Search.product_service.repository.BrandRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.CategoryRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.DiscountRepository;
import edu.famous.E_Commerce_Product_Search.product_service.repository.ProductRepository;
import edu.famous.E_Commerce_Product_Search.product_service.search.service.indexing.ProductIndexService;
import edu.famous.E_Commerce_Product_Search.product_service.service.ProductService;
import edu.famous.E_Commerce_Product_Search.product_service.utils.indexing.persistence.ProductUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final DiscountRepository discountRepository;
    private final ProductIndexService productIndexService;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) {
        // Fetch category from the request DTO
        Category category = categoryRepository.findById(productRequestDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + productRequestDto.getCategory()));
        // Fetch brand from the request DTO
        Brand brand = null;
        if (productRequestDto.getBrand() != null) {
            brand = brandRepository.findById(productRequestDto.getBrand())
                    .orElseThrow(() -> new BrandNotFoundException("Brand not found with ID: " + productRequestDto.getBrand()));
        }
        // Fetch discount from the request DTO if applicable
        Discount discount = null; // Uncomment if discount is part of the request DTO
        if (productRequestDto.getDiscount() != null) {
            discount = discountRepository.findById(productRequestDto.getDiscount())
                    .orElseThrow(() -> new DiscountNotFoundException("Discount not found with ID: " + productRequestDto.getDiscount()));
        }
        //Map the request dto into entity
        Product product = modelMapper.map(productRequestDto, Product.class);

        //Set the default status, new arrival, category and brand or discount  fields
        ProductUtils.setupNewProduct(product, category, brand, discount);

        // Save the product entity to the repository
        try {
            final Product savedEntity = productRepository.save(product);
            log.info("Product created successfully with Id: {}", savedEntity.getId());
            return modelMapper.map(savedEntity, ProductResponseDto.class);
        } catch (Exception e) {
            log.error("Error occurred while creating product: {}", e.getMessage(), e);
            throw new ProductPersistenceException("Failed to create product", e);
        }
    }

    @Override
    @Transactional
    public ProductResponseDto getProductById(Long id) {
        // Fetch the product by ID
        Product product = productRepository.findByIdAndStatusNot(id, ProductStatus.DELETED)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        // Convert the Product entity to ProductResponseDto
        try {
            log.info("Product with ID {} fetched successfully", id);
            return modelMapper.map(product, ProductResponseDto.class);
        } catch (Exception e) {
            log.error("Error converting product to response DTO: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to convert product to response DTO", e);
        }
    }

    @Override
    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductRequestDto productRequestDto) {
        // Fetch the product by ID
        Product existingProduct = productRepository.findByIdAndStatusNot(id, ProductStatus.DELETED)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        // Fetch category from the request DTO
        if (!productRequestDto.getCategory().equals(existingProduct.getCategory().getId())) {
            Category category = categoryRepository.findById(productRequestDto.getCategory())
                    .orElseThrow(() -> new CategoryNotFoundException("Category not found with ID: " + productRequestDto.getCategory()));
            log.info("Setting new category: {} product: {}", category.getId(), existingProduct.getId());
            existingProduct.setCategory(category);
        }
        // Fetch brand from the request DTO
        if (null != productRequestDto.getBrand() && null != existingProduct.getBrand().getId()) {
            if (!productRequestDto.getBrand().equals(existingProduct.getBrand().getId())) {
                Brand brand = brandRepository.findById(productRequestDto.getBrand())
                        .orElseThrow(() -> new BrandNotFoundException("Brand not found with ID: " + productRequestDto.getBrand()));
                log.info("Setting new brand: {} product: {}", brand.getId(), existingProduct.getId());
                existingProduct.setBrand(brand);
            }
        }
        // Fetch discount from the request DTO if applicable
        if (null != productRequestDto.getDiscount() && null != existingProduct.getDiscount().getId()) {
            if (!productRequestDto.getDiscount().equals(existingProduct.getDiscount().getId())) {
                Discount discount = discountRepository.findById(productRequestDto.getDiscount())
                        .orElseThrow(() -> new DiscountNotFoundException("Discount not found with ID: " + productRequestDto.getDiscount()));
                log.info("Setting new discount: {} product: {}", discount.getId(), existingProduct.getId());
                existingProduct.setDiscount(discount);
            }
        }
        //Map the request dto into entity
        Product product = modelMapper.map(productRequestDto, Product.class);
        // Update the product fields
        try {
            log.info("Updating product with ID: {}", id);
            modelMapper.map(product, existingProduct);
        } catch (Exception e) {
            log.error("Error occurred while updating product: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to update product", e);
        }
        // Save the updated product entity to the repository
        try {
            final Product savedEntity = productRepository.save(existingProduct);
            log.info("Product with ID {} updated successfully", id);
            return modelMapper.map(savedEntity, ProductResponseDto.class);
        } catch (Exception e) {
            log.error("Error occurred while updating product: {}", e.getMessage(), e);
            throw new ProductPersistenceException("Failed to update product", e);
        }
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        // Fetch the product by ID
        Product existingProduct = productRepository.findByIdAndStatusNot(id, ProductStatus.DELETED)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        // Check if the product is already deleted
        if (existingProduct.getStatus() == ProductStatus.DELETED) {
            log.info("Product with ID {} is already deleted", id);
            throw new ProductNotFoundException("Product already deleted with ID: " + id);
        }
        // Set the status to DELETED
        existingProduct.setStatus(ProductStatus.DELETED);
        // Save the updated product entity to the repository
        try {
            productRepository.save(existingProduct);
            log.info("Product with ID {} deleted successfully", id);
        } catch (Exception e) {
            log.error("Error occurred while deleting product: {}", e.getMessage(), e);
            throw new ProductPersistenceException("Failed to delete product", e);
        }
    }

    @Override
    public ProductResponseDto getProductByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public ProductResponseDto updateProductStatus(Long id, ProductStatus newStatus) {
        log.info("Updating product status for product with ID: {}, new status: {}", id, newStatus);

        // Fetch and validate product
        Product existingProduct = productRepository.findByIdAndStatusNot(id, ProductStatus.DELETED)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));

        // Update and persist
        existingProduct.setStatus(newStatus);
        Product savedProduct = productRepository.save(existingProduct);

        log.info("Product status updated successfully for product with ID: {}", id);

        // Map entity → DTO
        return modelMapper.map(savedProduct, ProductResponseDto.class);
    }

    @Override
    public Page<ProductResponseDto> searchProducts(String query, Pageable pageable) {
        // This method should implement the logic to search products based on the query
        return null;
    }

    @Override
    public List<ProductResponseDto> filterProductsByCategory(String category) {
        return List.of();
    }

    @Override
    @Transactional
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        // This method should implement the logic to retrieve all products with pagination
        log.info("Fetching all products with pagination: {}", pageable);
        return productRepository.findAll(pageable).map(product -> {
            try {
                // Convert Product entity to ProductResponseDto
                return modelMapper.map(product, ProductResponseDto.class);
            } catch (Exception e) {
                log.error("Error converting product to response DTO: {}", e.getMessage());
                throw new RuntimeException("Failed to convert product to response DTO", e);
            }
        });
    }

    @Override
    @Transactional
    public void indexProduct(Long productId) {
        // Fetch the product by ID
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
        // Index the product using the ProductIndexService
        try {
            productIndexService.indexProduct(product);
        } catch (IOException | SolrServerException e) {
            log.error("Error indexing product with ID {}: {}", productId, e.getMessage());
            throw new ProductIndexingException("Product with Id: " + productId + " indexing failed", e);
        } catch (Exception e) {
            log.error("Error indexing product with ID {}: {}", productId, e.getMessage());
            throw new RuntimeException("Unknown error indexing product with id: " + productId, e);
        }
        log.info("Product with ID {} indexed successfully", productId);
    }

    @Override
    @Transactional
    public void indexAllProducts() {
        // Fetch all products from the repository
        List<Product> products = productRepository.findAll();
        // Index each product using the ProductIndexService
        try {
            productIndexService.indexAllProducts(products);
        } catch (IOException | SolrServerException e) {
            log.error("Error indexing products: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            log.error("Error indexing products: {}", e.getMessage());
            throw new RuntimeException("Failed to index products", e);
        }
        log.info("All products indexed successfully");
    }
}
