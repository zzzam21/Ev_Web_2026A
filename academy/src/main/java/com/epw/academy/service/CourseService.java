package com.epw.academy.service;

import java.util.List;

import com.epw.academy.dto.CourseResponse;
import com.epw.academy.dto.CreateCourseRequest;
import com.epw.academy.dto.UpdateCourseRequest;

public interface CourseService {
    CourseResponse create(CreateCourseRequest request);
    List<CourseResponse> list();
    CourseResponse getById(Long id);
    CourseResponse update(Long id, UpdateCourseRequest request);
    void delete(Long id);

    
}
