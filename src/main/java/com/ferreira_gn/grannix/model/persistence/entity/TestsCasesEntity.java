package com.ferreira_gn.grannix.model.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Builder
@Entity
@Table(name = "tests_cases_table")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestsCasesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "problem_id", nullable = false)
    private ProblemsEntity problem;

    private String input;

    @Column(name = "expected_output", nullable = false)
    private String  expectedOutput;

    @Builder.Default
    @Column(name = "is_hidden", nullable = false)
    private Boolean isHidden = false;

    @Column(name = "test_case_example", nullable = false)
    private String testCaseExemple;

    public void update(TestsCasesEntity infoToUpdate) {
        if (infoToUpdate.getInput() != null) this.input = infoToUpdate.getInput();
        if (infoToUpdate.getExpectedOutput() != null) this.expectedOutput = infoToUpdate.getExpectedOutput();
        if (infoToUpdate.getIsHidden() != null) this.isHidden = infoToUpdate.getIsHidden();
        if (infoToUpdate.getTestCaseExemple() != null) this.testCaseExemple = infoToUpdate.getTestCaseExemple();
    }
}
