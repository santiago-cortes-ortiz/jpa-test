package sos.sho.jpatest.program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Program")
@Table(name = "programs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Program {
    @Id
    @SequenceGenerator(
            name = "programs_seq",
            sequenceName = "programs_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="programs_seq"
    )
    @Column(name = "id")
    private Short id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_programs_faculties_id"),
            nullable = false
    )
    private Faculty faculty;
}
