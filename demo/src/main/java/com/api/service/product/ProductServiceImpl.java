package com.api.service.product;

import com.api.Exception.HnDBankException;
import com.api.dto.product.ProductDTO;
import com.api.entity.Product;
import com.api.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public int addProduct(ProductDTO productDTO) throws HnDBankException{
        Optional<Product> optional = productRepository.findById(productDTO.getProductId());
        if(optional.isPresent()) {
            throw new HnDBankException("Service.PRODUCT_FOUND");
        }
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductDesc(productDTO.getProductDesc());
        product.setProductName(productDTO.getProductName());
        product.setExpiryDate(productDTO.getExpiryDate());
        Product createdProduct = productRepository.save(product);
        return createdProduct.getProductId();
    }
    @Override
    public ProductDTO getProduct(Integer productId) throws HnDBankException{
        Optional<Product> optional = productRepository.findById(productId);
        Product product = optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setExpiryDate(product.getExpiryDate());
        productDTO.setProductDesc(product.getProductDesc());
        return productDTO;
    }
    @Override
    public List<ProductDTO> findAll() throws HnDBankException
    {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDTO>  productDTOs = new ArrayList<>();
        products.forEach(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());
            productDTO.setExpiryDate(product.getExpiryDate());
            productDTO.setProductDesc(product.getProductDesc());
            productDTOs.add(productDTO);
        });
        if(productDTOs.isEmpty()){
            throw new HnDBankException("Service.PRODUCTS_NOT_FOUND");
        }
        return productDTOs;
    }
    @Override
    public void updateProduct(Integer productId, ProductDTO productDTO) throws HnDBankException{
        Optional<Product> optional = productRepository.findById(productId);
        optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
        productRepository.updateProduct(productDTO.getProductName(), productDTO.getProductDesc(), productDTO.getExpiryDate(), productId);
    }
    @Override
    public void deleteProduct(Integer productId)throws HnDBankException{
        Optional<Product> optional = productRepository.findById(productId);
        optional.orElseThrow(() -> new HnDBankException("Service.PRODUCT_NOT_FOUND"));
        productRepository.deleteById(productId);
    }
}
