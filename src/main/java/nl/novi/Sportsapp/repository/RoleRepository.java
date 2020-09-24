package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.ERole;
import nl.novi.Sportsapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name); // geeft aan welke gevens van ieder role in de database verwerkt moeten worden
}