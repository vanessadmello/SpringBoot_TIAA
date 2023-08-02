package com.api.service.product;
import com.api.Exception.HnDBankException;
import com.api.dto.product.ProductDTO;

import java.util.List;
public interface ProductService {
    int addProduct(ProductDTO productDTO) throws HnDBankException;
    ProductDTO getProduct(Integer productId) throws HnDBankException;
    List<ProductDTO> findAll() throws HnDBankException;
    void updateProduct(Integer productId, ProductDTO productDTO) throws HnDBankException;
    void deleteProduct(Integer productId)throws HnDBankException;
}
