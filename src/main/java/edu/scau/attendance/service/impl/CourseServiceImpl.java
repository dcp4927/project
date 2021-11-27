package edu.scau.attendance.service.impl;

import edu.scau.attendance.model.Course;
import edu.scau.attendance.mapper.CourseMapper;
import edu.scau.attendance.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lin
 * @since 2021-11-27
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
