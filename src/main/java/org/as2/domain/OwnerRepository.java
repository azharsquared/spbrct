package org.as2.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource is used to customize the REST endpoint
@RepositoryRestResource(path="owners-rest")
public interface OwnerRepository extends
        CrudRepository<Owner, Long> {
}
