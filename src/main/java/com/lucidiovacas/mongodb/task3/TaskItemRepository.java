package com.lucidiovacas.mongodb.task3;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskItemRepository extends CassandraRepository<TaskItem, String> {

    TaskItem findByName(String name);

    @Query("SELECT * FROM task WHERE deadline < ?0")
    List<TaskItem> findAllOverdueTasks(LocalDate today);

    public long count();
}
