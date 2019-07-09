package com.example.kproject.repository;

import com.example.kproject.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> getScheduleByGroup (Long id);

    List<Schedule> getScheduleByTime(String time);

    List<Schedule> getScheduleByTeacher(Long id);

    List<Schedule> getScheduleByLessonId(Long id);

}
