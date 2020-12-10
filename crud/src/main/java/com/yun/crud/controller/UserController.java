package com.yun.crud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yun.crud.entity.User;
import com.yun.crud.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Yun
 * @since 2020-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController extends ApiController {

    @Resource
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("selectAll")
    public R selectAllUser(){
        return success(this.userService.list());
    }

    /**
     * 查询单个
     * @param user
     * @return
     */
    @GetMapping("getOne")
    public R<User> getOne(User user){
       QueryWrapper<User> queryWrapper=new QueryWrapper<>(user);
       return success(this.userService.getOne(queryWrapper));
    }

    /**
     *增加
     * @param user
     * @return
     */
    @PostMapping("{id}")
    public R insertUser(@RequestBody User user){
        return success(this.userService.save(user));
    }


    /**
     * 修改
     * @param user
     * @return
     */
    @PutMapping
    public R updateUser(@RequestBody User user){
        return success(this.userService.updateById(user));
    }

    /**
     * 逻辑删除
     * @param idList
     * @return
     */
    @DeleteMapping
    public R deleteUser(@RequestParam("idList") List<Long> idList){
        return success(this.userService.removeByIds(idList));
    }

    /**
     * 分页查询
     * @param current
     * @param size
     * @return
     */
    @GetMapping
    public R selectUserByPage(Integer current, Integer size){
        return success(this.userService.page(new Page<>(current,size),new QueryWrapper<>()));
    }
}

