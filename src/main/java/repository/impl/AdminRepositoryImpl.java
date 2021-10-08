package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Admin;
import repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,Long>
implements AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntity() {
        return Admin.class;
    }
}
