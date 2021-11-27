package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Mentor;
import edu.scau.attendance.service.impl.MentorServiceImpl;
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
@RequestMapping("/attendance/mentor")
public class MentorController {
    @Autowired
    MentorServiceImpl mentorService;

    @GetMapping("/get/{id}")
    public RespBean getMentorById(@PathVariable("id") Integer id) {
        Mentor mentor = mentorService.getById(id);
        if (Objects.nonNull(mentor)) {
            return RespBean.ok("查询成功", mentor);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addMentor(Mentor mentor) {
        boolean bool = mentorService.save(mentor);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateMentor(Mentor mentor) {
        boolean bool = mentorService.saveOrUpdate(mentor);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteMentor(@PathVariable Integer id) {
        boolean bool = mentorService.removeById(id);
        if (bool) {
            return RespBean.ok("删除辅导员成功");
        } else {
            return RespBean.error("删除辅导员失败");
        }
    }

    @GetMapping("/list")
    public RespBean listMentor() {
        QueryWrapper<Mentor> queryWrapper = new QueryWrapper<>();
        List<Mentor> list = mentorService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询辅导员成功", list);
        } else {
            return RespBean.error("批量查询辅导员失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listMentorByIds(List<Integer> ids) {
        Collection<Mentor> mentors = mentorService.listByIds(ids);
        if (Objects.nonNull(mentors) && !mentors.isEmpty()) {
            return RespBean.ok("批量查询辅导员成功", mentors);
        } else {
            return RespBean.error("批量查询辅导员失败");
        }
    }
}

