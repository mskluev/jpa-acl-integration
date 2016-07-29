package com.skogul.spring.jpaaclintegration.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
import org.springframework.security.acls.model.Sid;

@Entity(name = "AclSid")
@Table(name = "acl_sid")
@Immutable
public class AclSid implements Sid, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "principal", nullable = false, unique = false)
	private Boolean principal;

	@Column(name = "sid", length = 150, nullable = false, unique = false)
	private String sid;

	public AclSid() {
	}

	public AclSid(Long id, Boolean principal, String sid) {
		setId(id);
		setPrincipal(principal);
		setSid(sid);
	}

	public AclSid flat() {
		return new AclSid(getId(), getPrincipal(), getSid());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "AclSid [id=" + id + ", principal=" + principal + ", sid=" + sid
				+ "]";
	}

}
