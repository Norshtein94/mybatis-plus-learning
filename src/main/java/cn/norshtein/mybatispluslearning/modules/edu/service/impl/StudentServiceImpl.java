package cn.norshtein.mybatispluslearning.modules.edu.service.impl;

import cn.norshtein.mybatispluslearning.modules.edu.model.StudentModel;
import cn.norshtein.mybatispluslearning.modules.edu.mapper.StudentMapper;
import cn.norshtein.mybatispluslearning.modules.edu.service.iface.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author norshtein
 * @since 2021-01-09
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, StudentModel> implements StudentService {

}
