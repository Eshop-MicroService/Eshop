package com.eshop.order.service.impl;

import com.eshop.order.mapper.TaskHisMapper;
import com.eshop.order.pojo.TaskHis;
import com.eshop.order.service.TaskHisService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:TaskHis业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class TaskHisServiceImpl implements TaskHisService {

    @Autowired
    private TaskHisMapper taskHisMapper;


    /**
     * TaskHis条件+分页查询
     * @param taskHis 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<TaskHis> findPage(TaskHis taskHis, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(taskHis);
        //执行搜索
        return new PageInfo<TaskHis>(taskHisMapper.selectByExample(example));
    }

    /**
     * TaskHis分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<TaskHis> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<TaskHis>(taskHisMapper.selectAll());
    }

    /**
     * TaskHis条件查询
     * @param taskHis
     * @return
     */
    @Override
    public List<TaskHis> findList(TaskHis taskHis){
        //构建查询条件
        Example example = createExample(taskHis);
        //根据构建的条件查询数据
        return taskHisMapper.selectByExample(example);
    }


    /**
     * TaskHis构建查询对象
     * @param taskHis
     * @return
     */
    public Example createExample(TaskHis taskHis){
        Example example=new Example(TaskHis.class);
        Example.Criteria criteria = example.createCriteria();
        if(taskHis!=null){
            // 任务id
            if(!StringUtils.isEmpty(taskHis.getId())){
                    criteria.andEqualTo("id",taskHis.getId());
            }
            // 
            if(!StringUtils.isEmpty(taskHis.getCreateTime())){
                    criteria.andEqualTo("createTime",taskHis.getCreateTime());
            }
            // 
            if(!StringUtils.isEmpty(taskHis.getUpdateTime())){
                    criteria.andEqualTo("updateTime",taskHis.getUpdateTime());
            }
            // 
            if(!StringUtils.isEmpty(taskHis.getDeleteTime())){
                    criteria.andEqualTo("deleteTime",taskHis.getDeleteTime());
            }
            // 任务类型
            if(!StringUtils.isEmpty(taskHis.getTaskType())){
                    criteria.andEqualTo("taskType",taskHis.getTaskType());
            }
            // 交换机名称
            if(!StringUtils.isEmpty(taskHis.getMqExchange())){
                    criteria.andEqualTo("mqExchange",taskHis.getMqExchange());
            }
            // routingkey
            if(!StringUtils.isEmpty(taskHis.getMqRoutingkey())){
                    criteria.andEqualTo("mqRoutingkey",taskHis.getMqRoutingkey());
            }
            // 任务请求的内容
            if(!StringUtils.isEmpty(taskHis.getRequestBody())){
                    criteria.andEqualTo("requestBody",taskHis.getRequestBody());
            }
            // 任务状态
            if(!StringUtils.isEmpty(taskHis.getStatus())){
                    criteria.andEqualTo("status",taskHis.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(taskHis.getErrormsg())){
                    criteria.andEqualTo("errormsg",taskHis.getErrormsg());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        taskHisMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改TaskHis
     * @param taskHis
     */
    @Override
    public void update(TaskHis taskHis){
        taskHisMapper.updateByPrimaryKey(taskHis);
    }

    /**
     * 增加TaskHis
     * @param taskHis
     */
    @Override
    public void add(TaskHis taskHis){
        taskHisMapper.insert(taskHis);
    }

    /**
     * 根据ID查询TaskHis
     * @param id
     * @return
     */
    @Override
    public TaskHis findById(Long id){
        return  taskHisMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询TaskHis全部数据
     * @return
     */
    @Override
    public List<TaskHis> findAll() {
        return taskHisMapper.selectAll();
    }
}
