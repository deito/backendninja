package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		List<Course> courses = courseJpaRepository.findAll();
		List<CourseModel> coursesModel = new ArrayList<CourseModel>();
		for (Course course : courses) {
			coursesModel.add(courseConverter.entity2model(course));
		}
		return coursesModel;
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		Course course = courseConverter.model2entity(courseModel);
		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {
		return courseJpaRepository.save(course);
	}

}
