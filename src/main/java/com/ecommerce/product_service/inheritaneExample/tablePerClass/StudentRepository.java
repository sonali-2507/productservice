package com.ecommerce.product_service.inheritaneExample.tablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_student_repo")
public interface StudentRepository extends JpaRepository<Student,Long> {
}
