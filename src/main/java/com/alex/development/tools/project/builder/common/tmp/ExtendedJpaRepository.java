package com.alex.development.tools.project.builder.common.tmp;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//https://stackoverflow.com/questions/42781264/multiple-base-repositories-in-spring-data-jpa
@NoRepositoryBean
public interface ExtendedJpaRepository<T extends Object, ID extends Serializable> extends JpaRepository<T, ID> {

    T getByField(String fieldName, Object fieldValue);

    T getByFilter(Object filter);

}
