package com.simulcreare.respository;

import com.simulcreare.domain.entity.Artwork;
import org.springframework.data.repository.CrudRepository;

public interface ArtworkRepository extends CrudRepository<Artwork, Long> {
}
