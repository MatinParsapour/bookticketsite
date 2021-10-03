package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{
    private static final String EMPLOYEE_CODE = "employee_code";
    private static final String IS_EMPLOYEE = "is_employee";
    private static final String COMPANY = "company";

    private long employeeCode;

    @JoinColumn(name = IS_EMPLOYEE)
    private Boolean isEmployee;

    @ManyToOne
    @JoinColumn(name = COMPANY)
    private Company company;

    public Employee(String firstName, String lastName, String email, long phoneNumber, long nationalCode, Date birthDate, int employeeCode, boolean isEmployee) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.employeeCode = employeeCode;
        this.isEmployee = isEmployee;
    }
}
