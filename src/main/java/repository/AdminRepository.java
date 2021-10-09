package repository;

import base.repository.BaseRepository;
import domain.Admin;
import domain.Customer;

public interface AdminRepository extends BaseRepository<Admin,Long> {
    Admin findAdminByUserNameAndPassword(String userName, String password);
}
