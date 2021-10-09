package service;

import base.service.BaseService;
import domain.Admin;

public interface AdminService extends BaseService<Admin,Long> {
    Admin getAdmin(String username, String password);
}
