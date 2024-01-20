package com.ecommerce.product_service.inheritaneExample.tablePerClass;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_user_repo")
public interface UserRepository extends JpaRepository<User,Long> {
}
