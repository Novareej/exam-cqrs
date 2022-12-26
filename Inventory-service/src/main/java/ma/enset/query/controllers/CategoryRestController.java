package ma.enset.query.controllers;

import lombok.AllArgsConstructor;
import ma.enset.queries.GetAllCategories;
import ma.enset.query.entities.Category;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/categories")
@AllArgsConstructor
public class CategoryRestController {

    private QueryGateway queryGateway;

    @GetMapping("/all")
    public List<Category> getAll(){
            List<Category> categories= queryGateway.query(new GetAllCategories(), ResponseTypes.multipleInstancesOf(Category.class)).join();
            return categories;
    }
}
