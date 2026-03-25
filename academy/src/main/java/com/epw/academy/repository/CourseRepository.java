package com.epw.academy.repository;

import com.epw.academy.entity.course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<course, Long>{
    
}
