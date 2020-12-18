package com.eshop.order.service;

import com.eshop.order.pojo.Task;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Task业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface TaskService {

    /***
     * Task多条件分页查询
     * @param task
     * @param page
     * @param size
     * @return
     */
    PageInfo<Task> findPage(Task task, int page, int size);

    /***
     * Task分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Task> findPage(int page, int size);

    /***
     * Task多条件搜索方法
     * @param task
     * @return
     */
    List<Task> findList(Task task);

    /***
     * 删除Task
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Task数据
     * @param task
     */
    void update(Task task);

    /***
     * 新增Task
     * @param task
     */
    void add(Task task);

    /**
     * 根据ID查询Task
     * @param id
     * @return
     */
     Task findById(Long id);

    /***
     * 查询所有Task
     * @return
     */
    List<Task> findAll();
}
