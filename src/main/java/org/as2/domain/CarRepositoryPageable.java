package org.as2.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepositoryPageable extends PagingAndSortingRepository<Vehicle, Long> {



}
