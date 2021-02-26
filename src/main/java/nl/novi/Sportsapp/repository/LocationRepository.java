package nl.novi.Sportsapp.repository;

import nl.novi.Sportsapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface LocationRepository extends JpaRepository<Location, Serializable>, JpaSpecificationExecutor<Location> {


}