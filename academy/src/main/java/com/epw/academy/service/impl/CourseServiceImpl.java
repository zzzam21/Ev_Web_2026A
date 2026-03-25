package com.epw.academy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epw.academy.dto.CourseResponse;
import com.epw.academy.dto.CreateCourseRequest;
import com.epw.academy.dto.UpdateCourseRequest;
import com.epw.academy.entity.course;
import com.epw.academy.exception.ResourceNotFoundException;
import com.epw.academy.repository.CourseRepository;
import com.epw.academy.service.CourseService;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    
    private final CourseRepository repository;
    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseResponse create(CreateCourseRequest request) {
        course c = new course();
        c.setName(request.getName());
        c.setDescription(request.getDescription());
        course saved = repository.save(c);
        return toResponse(saved);
    }


    @Override
    @Transactional(readOnly = true)
    public List<CourseResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponse getById(Long id) {
        course c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course " + id + " not found"));
        return toResponse(c);
    }

    @Override
    public CourseResponse update(Long id, UpdateCourseRequest request) {
        course c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course " + id + " not found"));

        c.setName(request.getName());

        if (request.getDescription() != null)
            c.setDescription(request.getDescription());
        
        course saved = repository.save(c);

        return toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Course " + id + " not found");
        }
        repository.deleteById(id);
    }

    private CourseResponse toResponse(course a) 
    {
        CourseResponse r = new CourseResponse();
        r.setId(a.getId());
        r.setName(a.getName());
        r.setDescription(a.getDescription());
        r.setCreatedAt(a.getCreatedAt());
        return r;
    }
}
