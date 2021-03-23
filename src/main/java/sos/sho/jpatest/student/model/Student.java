package sos.sho.jpatest.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sos.sho.jpatest.program.Program;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Student")
@Table(
        name = "students",
        uniqueConstraints ={
                @UniqueConstraint(name = "uk_students_email",columnNames = "email")
        }
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "students_seq",
            sequenceName = "students_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="students_seq"
    )
    @Column(name = "id")
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "varchar(40)"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            length = 100
    )
    private String email;
    /*@OneToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_studentes_programs_program_id"),
            nullable = false
    )
    private Program program;*/

}
