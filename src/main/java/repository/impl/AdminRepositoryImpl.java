package repository.impl;

import base.repository.BaseRepositoryImpl;
import domain.Admin;
import domain.Customer;
import repository.AdminRepository;
import util.CriteriaCustom;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin,Long>
implements AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntity() {
        return Admin.class;
    }

    @Override
    public Admin findAdminByUserNameAndPassword(String userName, String password) {
        try{
            CriteriaQuery<Admin> criteriaQuery = CriteriaCustom.getCriteriaBuilderCutom().createQuery(Admin.class);
            Root<Admin> customerRoot = criteriaQuery.from(Admin.class);
            criteriaQuery.select(customerRoot)
                    .where(CriteriaCustom.getCriteriaBuilderCutom().and(
                            CriteriaCustom.getCriteriaBuilderCutom().equal(
                                    customerRoot.get("userName"), userName),
                            CriteriaCustom.getCriteriaBuilderCutom().equal(
                                    customerRoot.get("password"),password)));
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (NoResultException exception){
            return null;
        }
    }
}
