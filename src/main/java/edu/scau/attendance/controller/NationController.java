package edu.scau.attendance.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.scau.attendance.model.RespBean;
import edu.scau.attendance.model.Nation;
import edu.scau.attendance.service.impl.NationServiceImpl;
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
@RequestMapping("/attendance/nation")
public class NationController {
    @Autowired
    NationServiceImpl nationService;

    @GetMapping("/get/{id}")
    public RespBean getNationById(@PathVariable("id") Integer id) {
        Nation nation = nationService.getById(id);
        if (Objects.nonNull(nation)) {
            return RespBean.ok("查询成功", nation);
        } else {
            return RespBean.error("查询失败");
        }
    }

    @PostMapping("/add")
    public RespBean addNation(Nation nation) {
        boolean bool = nationService.save(nation);
        if (bool) {
            return RespBean.ok("记录插入成功");
        } else {
            return RespBean.error("记录插入失败");
        }
    }

    @PutMapping("/update")
    public RespBean updateNation(Nation nation) {
        boolean bool = nationService.saveOrUpdate(nation);
        if (bool) {
            return RespBean.ok("记录更新成功");
        } else {
            return RespBean.error("记录更新失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public RespBean deleteNation(@PathVariable Integer id) {
        boolean bool = nationService.removeById(id);
        if (bool) {
            return RespBean.ok("删除课程成功");
        } else {
            return RespBean.error("删除课程失败");
        }
    }

    @GetMapping("/list")
    public RespBean listNation() {
        QueryWrapper<Nation> queryWrapper = new QueryWrapper<>();
        List<Nation> list = nationService.list(queryWrapper);
        if (Objects.nonNull(list)) {
            return RespBean.ok("批量查询课程成功", list);
        } else {
            return RespBean.error("批量查询课程失败");
        }
    }

    @GetMapping("/listByIds")
    public RespBean listNationByIds(List<Integer> ids) {
        Collection<Nation> nations = nationService.listByIds(ids);
        if (Objects.nonNull(nations) && !nations.isEmpty()) {
            return RespBean.ok("批量查询课程成功", nations);
        } else {
            return RespBean.error("批量查询课程失败");
        }
    }
}

