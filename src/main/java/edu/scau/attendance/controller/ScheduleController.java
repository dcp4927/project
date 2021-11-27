package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Schedule;
import edu.scau.attendance.service.impl.ScheduleServiceImpl;
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
@RequestMapping("/attendance/schedule")
public class ScheduleController {
    @Autowired
    ScheduleServiceImpl scheduleService;

    @GetMapping("/get/{id}")
    public RespBean getScheduleById(@PathVariable("id") Integer id) {
        Schedule schedule = scheduleService.getById(id);
        if (Objects.nonNull(schedule)) {
            return RespBean.ok("查询成功", schedule);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addSchedule(Schedule schedule) {
        boolean bool = scheduleService.save(schedule);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateSchedule(Schedule schedule) {
        boolean bool = scheduleService.saveOrUpdate(schedule);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteSchedule(@PathVariable Integer id) {
        boolean bool = scheduleService.removeById(id);
        if (bool) {
            return RespBean.ok("删除课程安排成功");
        } else {
            return RespBean.error("删除课程安排失败");
        }
    }

    @GetMapping("/list")
    public RespBean listSchedule() {
        QueryWrapper<Schedule> queryWrapper = new QueryWrapper<>();
        List<Schedule> list = scheduleService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询课程安排成功", list);
        } else {
            return RespBean.error("批量查询课程安排失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listScheduleByIds(List<Integer> ids) {
        Collection<Schedule> schedules = scheduleService.listByIds(ids);
        if (Objects.nonNull(schedules) && !schedules.isEmpty()) {
            return RespBean.ok("批量查询课程安排成功", schedules);
        } else {
            return RespBean.error("批量查询课程安排失败");
        }
    }
}

