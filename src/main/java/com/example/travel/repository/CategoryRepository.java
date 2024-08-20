package com.example.travel.repository;


import com.example.travel.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category WHERE category_id = :categoryId",nativeQuery = true)
    Category getCategoryById(@Param("categoryId") Long id);

    @Modifying
    @Query(value = "DELETE FROM category where category_id = :categoryId", nativeQuery = true)
    void deleteWithId(@Param("categoryId") Long id);
}
