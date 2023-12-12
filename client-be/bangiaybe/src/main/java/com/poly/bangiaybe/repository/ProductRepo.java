package com.poly.bangiaybe.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poly.bangiaybe.dto.*;
import com.poly.bangiaybe.dto.Resp.RespProductDto;
import com.poly.bangiaybe.entity.*;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT new com.poly.bangiaybe.dto.ResponseProductDto(p.id, p.code, p.description, p.name, p.view, a.price, i.imageLink,p.brand.name, p.isActive) FROM Product p " +
            "inner join Attribute a on p.id = a.product.id " +
            "inner join Image i on p.id = i.product.id where a.size = :size and i.name = :name and p.isActive = :active")
    Page<ResponseProductDto> getAllProducts(@Param("size") Integer size,
                                 			@Param("name") String name,
                                 			@Param("active") Boolean active,
                                 			Pageable pageable);
    
    @Query("SELECT new com.poly.bangiaybe.dto.ResponseProductDto(p.id, p.code, p.description, p.name, p.view, a.price, i.imageLink,p.brand.name, p.isActive) FROM Product p inner join ProductCategory c on p.id = c.product.id " +
            "inner join Attribute a on p.id = a.product.id " +
            "inner join Image i on p.id = i.product.id where a.size = :size and i.name = :name and p.isActive = :active and c.category.id IN :category and p.brand.id in :brand and a.price between :min and :max")
    Page<ResponseProductDto> filterAllProducts(@Param("size") Integer size,
                                               @Param("name") String name,
                                               @Param("active") Boolean active,
                                               @Param("category") List<Long> category,
                                               @Param("brand") List<Long> brand,
                                               @Param("min") Double min,
                                               @Param("max") Double max,
                                               Pageable pageable);
    
    @Query("SELECT new com.poly.bangiaybe.dto.ResponseProductDto(p.id, p.code, p.description, p.name, p.view, a.price, i.imageLink,p.brand.name, p.isActive) FROM Product p " +
            "inner join Attribute a on p.id = a.product.id " +
            "inner join Image i on p.id = i.product.id where a.size = :size and i.name = :name and p.isActive = true and p.id = :id")
    ResponseProductDto getProductDetail(@Param("size") Integer size,
                                        @Param("name") String name,
                                        @Param("id") Long id);
    
    @Query("SELECT new com.poly.bangiaybe.dto.ResponseProductDto(p.id, p.code, p.description, p.name, p.view, a.price, i.imageLink,p.brand.name, p.isActive) FROM Product p " +
            "inner join Attribute a on p.id = a.product.id " +
            "inner join Image i on p.id = i.product.id where a.size = :size and i.name = :name and p.isActive = :active and p.brand.id = :brand and p.id <> :id")
    Page<ResponseProductDto> relateProduct( @Param("size") Integer size,
                                            @Param("name") String name,
                                            @Param("active") Boolean active,
                                            @Param("brand") Long brand,
                                            @Param("id") Long id,
                                            Pageable pageable);
    
    @Query("SELECT DISTINCT new com.poly.bangiaybe.dto.Resp.RespProductDto(p.id, p.name, p.code, p.description, p.view, a.price, i.imageLink, p.brand.name, p.isActive) FROM Product p " +
            "inner join Attribute a on p.id = a.product.id " +
            "inner join Image i on p.id = i.product.id where a.size = :size and i.name = :name and p.name like :keyword or p.brand.name like :keyword")
    List<RespProductDto> searchAllByKeyword(@Param("size") Integer size,
                                            @Param("name") String name,
                                            @Param("keyword") String keyword,
                                            Pageable pageable);

}
