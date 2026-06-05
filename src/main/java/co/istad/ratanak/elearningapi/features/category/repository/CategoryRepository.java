package co.istad.ratanak.elearningapi.features.category.repository;

import co.istad.ratanak.elearningapi.features.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}