package com.ecommerce.product_service.inheritaneExample.joinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_mentor_repo")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
}
