package com.webcammusica.ejercicios.springboot.CRUD.entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Entidad auditable de JPA
 * @Temporal se usaba con las antiguas clases Date y Calendar.
 * @author kumo
 *
 */
@EntityListeners({ AuditingEntityListener.class })
@MappedSuperclass
public class EntidadAuditable {

	@CreatedDate
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime lastModifiedDate;

	@CreatedBy
	@Column(nullable = false)
	private String createBy;

	@LastModifiedBy
	private String lastModifiedBy;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	
}