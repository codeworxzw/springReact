
package com.td.bbwp.wf;

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

import com.td.bbwp.wf.TaskInstance;

import java.util.List;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "complete", types = {TaskInstance.class})
interface TaskInstanceCompleteProjectionBase {

	Long getTaskId();

	String getName();

	com.td.bbwp.wf.TaskDefinition getTaskDefinition();

	com.td.bbwp.wf.CaseInstance getCaseInstance();

	String getTaskData();

	com.td.bbwp.wf.TaskStatus getStatus();

	String getComments();

}
