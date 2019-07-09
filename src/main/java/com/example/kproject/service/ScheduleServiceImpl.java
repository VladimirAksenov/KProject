package com.example.kproject.service;

import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundToDelete;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Schedule;
import com.example.kproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getAllById() {
        List<Schedule> schedule = scheduleRepository.findAll();
        if (schedule == null || schedule.isEmpty()) {
            throw new NoRecordFoundException("No Schedule Have Been Created Yet");
        } else {
            return schedule;
        }
    }

    @Override
    public void create(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void update(Schedule schedule) {
        Optional<Schedule> founded = scheduleRepository.findById(schedule.getId());
        if (founded.isPresent()) {
            scheduleRepository.save(schedule);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Schedule With Id = " + schedule.getId());
        }
    }

    @Override
    public void delete(Long scheduleId) {
        Optional founded = scheduleRepository.findById(scheduleId);
        if (founded.isPresent()) {
            scheduleRepository.deleteById(scheduleId);
        } else {
            throw new NoRecordFoundToDelete("There Is No Schedule With Id = " + scheduleId);
        }
    }

    @Override
    public Schedule getScheduleById(Long id) {
        Optional optional = scheduleRepository.findById(id);
        if (optional.isPresent()) {
            return (Schedule) optional.get();
        } else {
            throw new NoRecordFoundException("There Is No Schedule With Id = " + id);
        }
    }

    @Override
    public List<Schedule> getScheduleByGroup(Long id) {
        List<Schedule> schedule = scheduleRepository.getScheduleByGroup(id);
        if (schedule == null || schedule.isEmpty()) {
            throw new NoRecordFoundException(("There Is No Schedule For Group Id = ") + id);
        } else {
            return schedule;
        }
    }

    @Override
    public List<Schedule> getScheduleByTime(String time) {
        List<Schedule> schedule = scheduleRepository.getScheduleByTime(time);
        if (schedule == null || schedule.isEmpty()) {
            throw new NoRecordFoundException("There Is No Schedule At Time:");
        } else {
            return schedule;
        }
    }

    @Override
    public List<Schedule> getScheduleByTeacher(Long teacherId) {
        List<Schedule> schedule = scheduleRepository.getScheduleByTeacher(teacherId);
        if (schedule == null || schedule.isEmpty()) {
            throw new NoRecordFoundException("There Is No Schedule For Teacher: " + teacherId);
        } else {
            return schedule;
        }
    }

    @Override
    public List<Schedule> getScheduleByLessonId(Long lessonId) {
        List<Schedule> schedule = scheduleRepository.getScheduleByLessonId(lessonId);
        if (schedule == null || schedule.isEmpty()) {
            throw new NoRecordFoundException("There Is No Schedule For Lesson Id = " + lessonId);
        } else {
            return schedule;
        }
    }
}
