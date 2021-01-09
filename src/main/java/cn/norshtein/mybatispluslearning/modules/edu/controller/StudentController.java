package cn.norshtein.mybatispluslearning.modules.edu.controller;


import cn.norshtein.mybatispluslearning.modules.edu.model.StudentModel;
import cn.norshtein.mybatispluslearning.modules.edu.service.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author norshtein
 * @since 2021-01-09
 */
@RestController
@RequestMapping("/edu/student-model")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/saveOrUpdate/{id}")
    public void saveOrUpdateBatch(@PathVariable Long id){
        final StudentModel model = studentService.getById(id);
        model.setName("norshtein").setAge(27);
        studentService.saveOrUpdateBatch(Arrays.asList(model));
    }
}
