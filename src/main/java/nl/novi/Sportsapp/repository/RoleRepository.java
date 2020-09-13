package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}