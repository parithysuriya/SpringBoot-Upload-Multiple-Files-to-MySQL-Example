package com.example.user.repoasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.user.modal.FileModal;

@Repository
public interface FileRepository extends JpaRepository<FileModal, Long>{
	
}
