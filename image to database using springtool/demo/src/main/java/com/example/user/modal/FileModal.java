package com.example.user.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

// Entity annotation defines that a
// class can be mapped to a table
@Entity
// @Table annotation defines name of the table
@Table(name="filemodal")
public class FileModal {
	// @Id annotation specifies the
	// primary key of an entity
	@Id
	// @GeneratedValue annotation Provides for the
	// specification of generation strategies
	// for the values of primary keys
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column annotation specifies
	// the name of the column
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String fileName;
	@Lob
	@Column(name = "content")
	private byte[] content;
	@Column(name = "filetype")
	private String fileType;

	public FileModal() {
		super();
	}

	public FileModal(String fileName, byte[] content, String fileType) {
		super();
		this.fileName = fileName;
		this.content = content;
		this.fileType = fileType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	

	
	
}
