package service.impl;

import base.service.BaseServiceImpl;
import domain.Admin;
import repository.AdminRepository;
import service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin,Long, AdminRepository> implements AdminService {
    public AdminServiceImpl(AdminRepository repository) {
        super(repository);
    }

    @Override
    public Admin getAdmin(String username, String password) {
        return repository.findAdminByUserNameAndPassword(username,password);
    }
}
