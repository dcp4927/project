package edu.scau.attendance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Student;
import edu.scau.attendance.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lin
 * @since 2021-11-27
 */
@RestController
@RequestMapping("/attendance/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/get/{id}")
    public RespBean getStudentById(@PathVariable("id") Integer id) {
        Student student = studentService.getById(id);
        if (Objects.nonNull(student)) {
            return RespBean.ok("查询成功", student);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addStudent(Student stu) {
        boolean bool = studentService.save(stu);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateStudent(Student stu) {
        boolean bool = studentService.saveOrUpdate(stu);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteStudent(@PathVariable Integer id) {
        boolean bool = studentService.removeById(id);
        if (bool) {
            return RespBean.ok("删除学生成功");
        } else {
            return RespBean.error("删除学生失败");
        }
    }

    @GetMapping("/list")
    public RespBean listStudent() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        List<Student> list = studentService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询学生成功", list);
        } else {
            return RespBean.error("批量查询学生失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listStudentByIds(List<Integer> ids) {
        Collection<Student> students = studentService.listByIds(ids);
        if (Objects.nonNull(students) && !students.isEmpty()) {
            return RespBean.ok("批量查询学生成功", students);
        } else {
            return RespBean.error("批量查询学生失败");
        }
    }
}

