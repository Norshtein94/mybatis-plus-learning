package cn.norshtein.mybatispluslearning;

import cn.norshtein.mybatispluslearning.modules.edu.model.StudentModel;
import cn.norshtein.mybatispluslearning.modules.edu.service.iface.StudentService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class ServiceTests {
    // 继承了BaseMapper，所有的方法都来自己父类
    // 我们也可以编写自己的扩展方法！
    @Autowired
    private StudentService studentService;

    @Test
    public void testGetOne() {
        StudentModel one = studentService.getOne(
                Wrappers.<StudentModel>lambdaQuery()
                        .eq(StudentModel::getAge, 18)
                // , true);
                ,false);
        System.out.println(one);
    }

    @Test
    public void testSaveOrUpdateBatch(){
        // 无法更新逻辑删除的记录
        final StudentModel s1 = new StudentModel();
        s1.setId(5L);
        s1.setAge(15);
        final StudentModel s2 = new StudentModel();
        s2.setId(6L);
        s2.setAge(20);
        studentService.saveOrUpdateBatch(Arrays.asList(s1, s2));
    }

    /**
     * lambda查询
     */
    @Test
    public void testLambdaQuery(){
        List<StudentModel> list = studentService.lambdaQuery().ge(StudentModel::getAge, 18).list();
        list.forEach(System.out::println);
    }

    /**
     * lambda修改
     */
    @Test
    public void testLambdaUpdate(){
        boolean update = studentService.lambdaUpdate().gt(StudentModel::getAge, 18).set(StudentModel::getAge, 31).update();
        System.out.println(update);
    }

    /**
     * lambda删除
     */
    @Test
    public void testLambdaRemove(){
        boolean remove = studentService.lambdaUpdate().eq(StudentModel::getAge, 18).remove();
        System.out.println(remove);
    }
}
