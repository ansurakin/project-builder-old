package com.alex.development.tools.project.builder.common.crud;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Object, ID extends Serializable> extends JpaRepository<T, ID> {

}
