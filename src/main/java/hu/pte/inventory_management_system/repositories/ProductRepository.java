package hu.pte.inventory_management_system.repositories;

import hu.pte.inventory_management_system.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
