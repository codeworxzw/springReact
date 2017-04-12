
/**
 *  WARN -  DO NOT MODIFY  - This file is generated by Witchcraftmda. Change TaskInstance.java instead
 *  Any changes will be overwritten by the next run of the code generator.
 */

package com.td.bbwp.wf;

import javax.persistence.*;
import org.witchcraft.base.entity.FileAttachment;
import org.witchcraft.base.entity.BaseEntity;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.IndexColumn;

import javax.validation.constraints.*;

import java.math.BigDecimal;

import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.witchcraft.base.entity.BaseEntity;

@MappedSuperclass

//@Indexed
//@Analyzer(definition = "entityAnalyzer")

public abstract class TaskInstanceBase extends BaseEntity {

	//@Unique(entityName = "com.td.bbwp.wf.TaskInstance", fieldName = "TASK_ID")

	@Column(name = "TASK_ID", unique = true)

	protected Long taskId

	;

	@Column(name = "NAME", unique = false)

	protected String name

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "TASK_DEFINITION_ID", nullable = false, updatable = true, insertable = true)

	protected TaskDefinition taskDefinition

	;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "CASE_INSTANCE_ID", nullable = false, updatable = true, insertable = true)
	@com.fasterxml.jackson.annotation.JsonBackReference

	protected CaseInstance caseInstance

	;

	@Column(name = "TASK_DATA", unique = false)

	protected String taskData

	;

	@Column(name = "STATUS", unique = false)

	protected TaskStatus status

	;

	@Lob
	@Column(name = "COMMENTS", unique = false)

	protected String comments

	;

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getTaskId() {

		return taskId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setTaskDefinition(TaskDefinition taskDefinition) {
		this.taskDefinition = taskDefinition;
	}

	public TaskDefinition getTaskDefinition() {

		return taskDefinition;
	}

	public void setCaseInstance(CaseInstance caseInstance) {
		this.caseInstance = caseInstance;
	}

	public CaseInstance getCaseInstance() {

		return caseInstance;
	}

	public void setTaskData(String taskData) {
		this.taskData = taskData;
	}

	public String getTaskData() {

		return taskData;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskStatus getStatus() {

		return status;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {

		return comments;
	}

	@Transient
	//Display name
	public String getDisplayName() {
		try {
			return name;
		} catch (Exception e) {
			return "Exception - " + e.getMessage();
		}
	}

	@Transient
	public String getCommentsAbbreviated() {
		try {
			return org.apache.commons.lang.WordUtils.abbreviate(comments.trim(), 100, 200, "...");
		} catch (Exception e) {
			return comments != null ? comments : "";
		}
	}

	/*
	public List<List<? extends BaseEntity>> getComposites(){
		List lst = new ArrayList();
		
		return lst;
	}
	*/

}
