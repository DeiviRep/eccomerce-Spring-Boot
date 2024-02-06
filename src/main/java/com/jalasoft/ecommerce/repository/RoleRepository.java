package com.jalasoft.ecommerce.repository;

import com.jalasoft.ecommerce.entity.Role;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

  //QUERY NATIVE
  /*@Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
  Optional<Role> findRoleByName(String name);

  //JPQL
  @Query(value = "SELECT r FROM roles r WHERE r.name = ?1")
  Optional<Role> findByRoleName(String name);*/

  //QUERY METHODS
  Optional<Role> findByName(String name);
}
