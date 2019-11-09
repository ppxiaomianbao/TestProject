package com.example.mybatisspringboot.service.impl;

import com.example.mybatisspringboot.pojo.Course;
import com.example.mybatisspringboot.mapper.CourseMapper;
import com.example.mybatisspringboot.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limx
 * @since 2019-11-09
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
