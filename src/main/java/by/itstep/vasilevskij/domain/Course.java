package by.itstep.vasilevskij.domain;

import by.itstep.vasilevskij.domain.AbstractClasses.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
public class Course extends AbstractEntity {

    @NotBlank(message = "Заполни поле")
    private String courseName;

    @NotBlank(message = "Заполни поле")
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
}
