package util;

import repository.*;
import repository.impl.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {

    private static final CEORepository cEORepository;
    private static final CompanyRepository companyRepository;
    private static final CreditCardRepository creditCardRepository;
    private static final CustomerRepository customerRepository;
    private static final EmployeeRepository employeeRepository;
    private static final TicketRepository ticketRepository;
    private static final UserRepository userRepository;
    private static final HistoryRepository historyRepository;
    private static final AdminRepository adminRepository;
    private static final CouponRepository couponRepository;

    private static final CEOServiceImpl cEOService;
    private static final CompanyServiceImpl companyServiceImpl;
    private static final CreditCardServiceImpl creditCardService;
    private static final CustomerServiceImpl customerService;
    private static final EmployeeServiceImpl employeeService;
    private static final TicketServiceImpl ticketServiceImpl;
    private static final UserServiceImpl userService;
    private static final HistoryServiceImpl historyServiceImpl;
    private static final AdminServiceImpl adminServiceImpl;
    private static final CouponServiceImpl couponServiceImpl;

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        cEORepository = new CEORepositoryImpl(entityManager);
        companyRepository = new CompanyRepositoryImpl(entityManager);
        creditCardRepository = new CreditCardRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        employeeRepository = new EmployeeRepositoryImpl(entityManager);
        ticketRepository = new TicketRepositoryImpl(entityManager);
        userRepository = new UserRepositoryImpl(entityManager);
        historyRepository = new HistoryRepositoryImpl(entityManager);
        adminRepository = new AdminRepositoryImpl(entityManager);
        couponRepository = new CouponRepositoryImpl(entityManager);

        cEOService = new CEOServiceImpl(cEORepository);
        companyServiceImpl = new CompanyServiceImpl(companyRepository);
        creditCardService = new CreditCardServiceImpl(creditCardRepository);
        customerService = new CustomerServiceImpl(customerRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        ticketServiceImpl = new TicketServiceImpl(ticketRepository);
        userService = new UserServiceImpl(userRepository);
        historyServiceImpl = new HistoryServiceImpl(historyRepository);
        adminServiceImpl = new AdminServiceImpl(adminRepository);
        couponServiceImpl = new CouponServiceImpl(couponRepository);

    }

    public static CEOServiceImpl getCEOService(){return cEOService;}
    public static CompanyServiceImpl getCompanyServiceImpl(){return companyServiceImpl;}
    public static CreditCardServiceImpl getCreditCardService(){return creditCardService;}
    public static UserServiceImpl getUserService(){return userService;}
    public static CustomerServiceImpl getCustomerService(){return customerService;}
    public static TicketServiceImpl getTicketServiceImpl(){return ticketServiceImpl;}
    public static EmployeeServiceImpl getEmployeeService(){return employeeService;}
    public static HistoryServiceImpl getHistoryServiceImpl(){return historyServiceImpl;}
    public static AdminServiceImpl getAdminServiceImpl(){return adminServiceImpl;}
    public static CouponServiceImpl getCouponServiceImpl(){return couponServiceImpl;}
}
