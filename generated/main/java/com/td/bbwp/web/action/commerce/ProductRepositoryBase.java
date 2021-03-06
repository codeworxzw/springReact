
package com.td.bbwp.web.action.commerce;

import com.td.bbwp.commerce.Product;
import org.witchcraft.base.entity.BaseRepository;

import java.util.stream.Stream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.math.BigDecimal;
import java.util.Date;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.data.jpa.repository.Query;

import com.td.bbwp.commerce.Product;

//@RepositoryRestResource(exported=false)
public interface ProductRepositoryBase extends BaseRepository<Product> {

	@Query("select e from Product e")
	Stream<Product> allEntities();

	Stream<Product> findByNameContainingAllIgnoringCase(@Param("name") String name);

	Stream<Product> findByName(@Param("name") String name);
	Stream<Product> findByNameIgnoringCase(@Param("name") String name);

}
