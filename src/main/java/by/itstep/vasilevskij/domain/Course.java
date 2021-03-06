package by.itstep.vasilevskij.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 5)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Заполни поле")
    private String courseName;

    @NotBlank(message = "Заполни поле")
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean isActive = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private User teacherId;
}
