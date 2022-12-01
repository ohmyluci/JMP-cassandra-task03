package com.lucidiovacas.mongodb.task3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Table("task")
@AllArgsConstructor
@NoArgsConstructor
public class TaskItem implements Serializable {

    @PrimaryKey
    private UUID id;
    private String name;
    private String description;
    private LocalDate dateOfCreation;
    private Category category;
    @Indexed
    private LocalDate deadline;

    public TaskItem(String name, String description, LocalDate dateOfCreation, Category category, LocalDate deadLine) {
        this.name = name;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.category = category;
        this.deadline = deadLine;
    }
}