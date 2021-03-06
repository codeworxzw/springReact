
package com.td.bbwp.web.action.commerce;

import com.td.bbwp.commerce.Department;
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

import com.td.bbwp.commerce.Department;

import com.td.bbwp.commerce.Employee;

//@RepositoryRestResource(exported=false)
public interface DepartmentRepositoryBase extends BaseRepository<Department> {

	@Query("select e from Department e")
	Stream<Department> allEntities();

	Optional<Department> findByNameContainingAllIgnoringCase(@Param("name") String name);

	Optional<Department> findByName(@Param("name") String name);
	Optional<Department> findByNameIgnoringCase(@Param("name") String name);

}
