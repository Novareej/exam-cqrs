package ma.enset.query.service;

import lombok.AllArgsConstructor;
import ma.enset.events.CategoryCreatedEvent;
import ma.enset.queries.GetAllCategories;
import ma.enset.query.entities.Category;
import ma.enset.query.repositories.CategoryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceHandler {
    private CategoryRepository categoryRepository;

    @EventHandler
    @Transactional
    public void on(CategoryCreatedEvent categoryCreatedEvent){
        Category category = new Category();
        category.setId(categoryCreatedEvent.getId());
        category.setNom(categoryCreatedEvent.getNom());
        category.setDescription(categoryCreatedEvent.getDescription());
        categoryRepository.save(category);
    }

    @QueryHandler
    public List<Category> on(GetAllCategories query){
        return categoryRepository.findAll();
    }
}
