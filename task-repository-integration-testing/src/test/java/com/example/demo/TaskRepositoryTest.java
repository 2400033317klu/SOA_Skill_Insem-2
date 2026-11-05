package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldSaveAndRetrieveTask() {
        // Arrange
        Task task = new Task(
                "Complete repository testing",
                "Verify Task persistence using an embedded H2 database",
                false
        );

        // Act
        Task savedTask = taskRepository.save(task);
        Task retrievedTask = taskRepository.findById(savedTask.getId()).orElseThrow();

        // Assert
        assertThat(savedTask.getId()).isNotNull();
        assertThat(retrievedTask.getId()).isEqualTo(savedTask.getId());
        assertThat(retrievedTask.getTitle()).isEqualTo("Complete repository testing");
        assertThat(retrievedTask.getDescription())
                .isEqualTo("Verify Task persistence using an embedded H2 database");
        assertThat(retrievedTask.isCompleted()).isFalse();
    }
}
