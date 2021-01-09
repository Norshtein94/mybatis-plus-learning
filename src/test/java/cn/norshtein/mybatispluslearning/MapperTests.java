package cn.norshtein.mybatispluslearning;

import cn.norshtein.mybatispluslearning.modules.edu.mapper.StudentMapper;
import cn.norshtein.mybatispluslearning.modules.edu.model.StudentModel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MapperTests {
    // 继承了BaseMapper，所有的方法都来自己父类
    // 我们也可以编写自己的扩展方法！
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void testSelectList() {
        // 参数是一个 Wrapper ，条件构造器，这里我们先设置条件为空，查询所有。
        List<StudentModel> users = studentMapper.selectList(null);
        users.forEach(System.out::println);
    }

    // 测试插入
    @Test
    public void testInsert(){
        StudentModel user = new StudentModel();
        user.setName("Helen");
        user.setAge(18);
        user.setEmail("310697723@qq.com");

        int result = studentMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 看到id会自动填充。
    }

    @Test
    public void testUpdate(){
        StudentModel user = new StudentModel();
        // 通过条件自动拼接动态sql
        user.setId(1L);
        user.setName("Alice");
        user.setAge(21);
        // 注意：updateById 但是参数是一个对象！
        int i = studentMapper.updateById(user);
        System.out.println(i);
    }

    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker(){
        // 1、查询用户信息
        StudentModel user = studentMapper.selectById(1L);
        // 2、修改用户信息
        user.setName("kwhua");
        user.setEmail("123456@qq.com");
        // 3、执行更新操作
        studentMapper.updateById(user);
    }

    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2(){

        // 线程 1
        StudentModel user = studentMapper.selectById(1L);
        user.setName("kwhua111");
        user.setEmail("123456@qq.com");

        // 模拟另外一个线程执行了插队操作
        StudentModel user2 = studentMapper.selectById(1L);
        user2.setName("kwhua222");
        user2.setEmail("123456@qq.com");
        studentMapper.updateById(user2);

        // 自旋锁来多次尝试提交！
        studentMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }

    // 测试查询
    @Test
    public void testSelectById(){
        StudentModel user = studentMapper.selectById(1L);
        System.out.println(user);
    }

    // 测试批量查询！
    @Test
    public void testSelectByBatchId(){
        List<StudentModel> users = studentMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 按条件查询之一使用map操作
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("F_name","Bob");
        map.put("F_age",15);

        List<StudentModel> users = studentMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage(){
        // 参数一：当前页
        // 参数二：页面大小
        Page<StudentModel> page = new Page<>(2,5);
        studentMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    // 测试删除
    @Test
    public void testDeleteById(){
        studentMapper.deleteById(4L);
    }

    // 通过id批量删除
    @Test
    public void testDeleteBatchId(){
        studentMapper.deleteBatchIds(Arrays.asList(2L,3L));
    }

    // 通过map删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("F_name","Billie");
        studentMapper.deleteByMap(map);
    }

    // QueryWrapper
    @Test
    public void testQueryWrapper() {
        // 查询name不为空的用户，并且邮箱不为空的用户，年龄大于等于12
        QueryWrapper<StudentModel> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("F_name") //不为空
                .isNotNull("F_email")
                .ge("F_age",18);
        studentMapper.selectList(wrapper).forEach(System.out::println); // 和我们刚才学习的map对比一下
    }

    // Wrappers.query
    @Test
    public void testWrappersQuery(){
        final StudentModel user = studentMapper.selectOne(
                Wrappers.<StudentModel>query()
                        .eq("F_name", "Cindy")
                        .orderByAsc("F_id")
                        .last(" limit 1")
                        .select("F_id", "F_name", "F_email", "F_age")
        );
        System.out.println(user);
    }

    // Wrappers.lambdaQuery
    @Test
    public void testWrappersLambdaQuery(){
        final StudentModel user = studentMapper.selectOne(
                Wrappers.<StudentModel>lambdaQuery()
                        .eq(StudentModel::getName, "Bob")
                        .orderByAsc(StudentModel::getId)
                        .last(" limit 1")
                        .select(StudentModel::getId, StudentModel::getName, StudentModel::getEmail, StudentModel::getAge)
        );
        System.out.println(user);
    }

}
