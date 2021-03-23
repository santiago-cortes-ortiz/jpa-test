package sos.sho.jpatest.program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Faculty")
@Table(name = "faculties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @SequenceGenerator(
            name = "faculties_seq",
            sequenceName = "faculties_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="faculties_seq"
    )
    @Column(name = "id")
    private Short id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "varchar(100)"
    )
    private String name;
    @OneToMany(
            cascade = CascadeType.ALL,mappedBy = "faculty"
    )
    private Set<Program> programs;

    /*@ManyToMany
    @JoinTable(
        name = "faculties_programs",
        joinColumns = @JoinColumn(name="faculty_id"),
        inverseJoinColumns = @JoinColumn(name="program_id")
        private Set<Program> programs;
    )*/


}
