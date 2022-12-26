package ma.enset.query.repositories;

import ma.enset.query.entities.Order;
import ma.enset.query.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
