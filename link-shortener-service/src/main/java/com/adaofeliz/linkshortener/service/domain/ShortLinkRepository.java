package com.adaofeliz.linkshortener.service.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 02/12/14.
 */

@Repository
public interface ShortLinkRepository extends CrudRepository<ShortLink, Long> {

}
