package org.as2.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

// This repository will be used to interact with the AppUser table in the database.
// where we store username and password
@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser,Long> {
    Optional<AppUser> findByUsername(String username);
}
