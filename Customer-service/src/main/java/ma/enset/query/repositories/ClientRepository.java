package ma.enset.query.repositories;

import ma.enset.query.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,String> {
}
