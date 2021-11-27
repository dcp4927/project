package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Teacher;
import edu.scau.attendance.service.impl.TeacherServiceImpl;
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
@RequestMapping("/attendance/teacher")
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;

    @GetMapping("/get/{id}")
    public RespBean getTeacherById(@PathVariable("id") Integer id) {
        Teacher teacher = teacherService.getById(id);
        if (Objects.nonNull(teacher)) {
            return RespBean.ok("查询成功", teacher);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addTeacher(Teacher teacher) {
        boolean bool = teacherService.save(teacher);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateTeacher(Teacher teacher) {
        boolean bool = teacherService.saveOrUpdate(teacher);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteTeacher(@PathVariable Integer id) {
        boolean bool = teacherService.removeById(id);
        if (bool) {
            return RespBean.ok("删除教师成功");
        } else {
            return RespBean.error("删除教师失败");
        }
    }

    @GetMapping("/list")
    public RespBean listTeacher() {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        List<Teacher> list = teacherService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询教师成功", list);
        } else {
            return RespBean.error("批量查询教师失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listTeacherByIds(List<Integer> ids) {
        Collection<Teacher> teachers = teacherService.listByIds(ids);
        if (Objects.nonNull(teachers) && !teachers.isEmpty()) {
            return RespBean.ok("批量查询教师成功", teachers);
        } else {
            return RespBean.error("批量查询教师失败");
        }
    }
}

