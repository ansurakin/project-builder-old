package com.alex.development.tools.project.builder.common.tmp;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class ExtendedJpaRepositoryImpl<T extends Object, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements ExtendedJpaRepository<T, ID> {

    public ExtendedJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }
    
    public ExtendedJpaRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public T getByField(String fieldName, Object fieldValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getByFilter(Object filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
