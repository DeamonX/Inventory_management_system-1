package hu.pte.inventory_management_system.repositories;

import hu.pte.inventory_management_system.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}