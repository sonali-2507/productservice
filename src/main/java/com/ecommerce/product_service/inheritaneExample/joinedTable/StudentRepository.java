package com.ecommerce.product_service.inheritaneExample.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_student_repo")
public interface StudentRepository extends JpaRepository<Student,Long> {
}
