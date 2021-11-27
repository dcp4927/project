package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Department;
import edu.scau.attendance.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lin
 * @since 2021-11-27
 */
@RestController
@RequestMapping("/attendance/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @GetMapping("/get/{id}")
    public RespBean getDepartmentById(@PathVariable("id") Integer id) {
        Department department = departmentService.getById(id);
        if (Objects.nonNull(department)) {
            return RespBean.ok("查询成功", department);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addDepartment(Department department) {
        boolean bool = departmentService.save(department);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateDepartment(Department department) {
        boolean bool = departmentService.saveOrUpdate(department);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteDepartment(@PathVariable Integer id) {
        boolean bool = departmentService.removeById(id);
        if (bool) {
            return RespBean.ok("删除学院成功");
        } else {
            return RespBean.error("删除学院失败");
        }
    }

    @GetMapping("/list")
    public RespBean listDepartment() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        List<Department> list = departmentService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询学院成功", list);
        } else {
            return RespBean.error("批量查询学院失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listDepartmentByIds(List<Integer> ids) {
        Collection<Department> departments = departmentService.listByIds(ids);
        if (Objects.nonNull(departments) && !departments.isEmpty()) {
            return RespBean.ok("批量查询学院成功", departments);
        } else {
            return RespBean.error("批量查询学院失败");
        }
    }
}

