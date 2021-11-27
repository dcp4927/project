package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Course;
import edu.scau.attendance.service.impl.CourseServiceImpl;
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
@RequestMapping("/attendance/course")
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @GetMapping("/get/{id}")
    public RespBean getCourseById(@PathVariable("id") Integer id) {
        Course course = courseService.getById(id);
        if (Objects.nonNull(course)) {
            return RespBean.ok("查询成功", course);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addCourse(Course course) {
        boolean bool = courseService.save(course);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateCourse(Course course) {
        boolean bool = courseService.saveOrUpdate(course);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteCourse(@PathVariable Integer id) {
        boolean bool = courseService.removeById(id);
        if (bool) {
            return RespBean.ok("删除课程成功");
        } else {
            return RespBean.error("删除课程失败");
        }
    }

    @GetMapping("/list")
    public RespBean listCourse() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        List<Course> list = courseService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询课程成功", list);
        } else {
            return RespBean.error("批量查询课程失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listCourseByIds(List<Integer> ids) {
        Collection<Course> courses = courseService.listByIds(ids);
        if (Objects.nonNull(courses) && !courses.isEmpty()) {
            return RespBean.ok("批量查询课程成功", courses);
        } else {
            return RespBean.error("批量查询课程失败");
        }
    }
}

