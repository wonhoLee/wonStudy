package main.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
		name = "NAME_AGE_UNIQUE",
		columnNames = {"NAME", "AGE"})})
public class Member {

	@Id
	@Column(name = "ID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "BOARD_SEQ_GENERATOR")
	//@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	private String id;

	@Column(name = "NAME", nullable = false, length = 10)
	private String username;

	private Integer age;

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Lob
	private String description;
}