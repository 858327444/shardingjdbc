package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.entity.Dict;
import com.atguigu.shardingjdbcdemo.entity.User;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.atguigu.shardingjdbcdemo.mapper.DictMapper;
import com.atguigu.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ShardingjdbcdemoApplicationTests {

    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DictMapper dictMapper;


    /**
     * 测试水平分表
     */
    @Test
    void test1() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCname("Java");
            course.setUserId(100L);
            course.setCstatus("Normal");
            courseMapper.insert(course);
        }

    }

    @Test
    void test2() {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Course::getCid, List.of(709194247571505153L, 709195371204575232L));
        System.out.println(courseMapper.selectList(queryWrapper));

    }


    // 测试水平分库
    @Test
    void test3() {
        Course course = new Course();
        course.setCname("Java");
        course.setUserId(111L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

    // 测试水平分库 水平分表查询
    @Test
    void test4() {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Course::getCid, 709353202847318017L);
        queryWrapper.in(Course::getUserId, 111L);
        System.out.println(courseMapper.selectList(queryWrapper));
    }



    // 测试垂直分库
    @Test
    void test5() {
        User user = new User();
        user.setUserId(100L);
        user.setUsername("Zhangsan");
        user.setUstatus("Normal");
        userMapper.insert(user);
    }

    // 测试水平分库 水平分表查询
    @Test
    void test6() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(User::getUserId, 111L);
        System.out.println(userMapper.selectList(queryWrapper));
    }


    // 测试公共表
    @Test
    void test7() {
        Dict dict = new Dict();
        dict.setUstatus("a");
        dict.setUvalue("Normal");
        dictMapper.insert(dict);
    }

    // 测试公共表
    @Test
    void test8() {
        // LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();
        // queryWrapper.in(Dict::getDictid, 709401832941682689L);
        // System.out.println(dictMapper.delete(queryWrapper));


        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dict::getDictid,709401988726521857L);
        System.out.println(dictMapper.selectList(queryWrapper));
    }


}
