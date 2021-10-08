package domain;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon extends BaseEntity<Long> {
    private String code;
    private LocalDate beginDate;
    private LocalDate finishDate;
    private int percent;
}
