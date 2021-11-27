package edu.scau.attendance.service.impl;

import edu.scau.attendance.model.Student;
import edu.scau.attendance.mapper.StudentMapper;
import edu.scau.attendance.service.StudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
