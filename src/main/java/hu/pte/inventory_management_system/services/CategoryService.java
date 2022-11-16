package hu.pte.inventory_management_system.services;

import hu.pte.inventory_management_system.models.Category;
import hu.pte.inventory_management_system.repositories.CategoryRepository;
import hu.pte.inventory_management_system.services.interfaces.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Adds a new category to the DB
     * @param category RequestBody category
     * @return Created category
     */
    @Override
    public Category addCategory(Category category){
        if(categoryRepository.findByName(category.getName()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return categoryRepository.save(category);
    }

    /**
     * Gets a specified category by id
     * @param id PathVariable category's id
     * @return Category
     */
    @Override
    public Category getCategoryById(Integer id){
        if(categoryRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return categoryRepository.findById(id).get();
    }

    /**
     * Gets list of categories
     * @return List of categories
     */
    @Override
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    /**
     * Deletes a specified category
     * @param id PathVariable category's id
     */
    @Override
    public void deleteCategoryById(Integer id){
        if(categoryRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }

    /**
     * Updates a category with specified id
     * @param id PathVariable category's id
     * @param categoryNew RequestBody Category
     * @return Updated category
     */
    @Override
    public Category updateCategoryById(Integer id, Category categoryNew){
        if(categoryRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Category category = categoryRepository.findById(id).get();
        category.setName(categoryNew.getName());

        return categoryRepository.save(category);
    }

}
