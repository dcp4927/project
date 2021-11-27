package edu.scau.attendance.service.impl;

import edu.scau.attendance.model.Department;
import edu.scau.attendance.mapper.DepartmentMapper;
import edu.scau.attendance.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
