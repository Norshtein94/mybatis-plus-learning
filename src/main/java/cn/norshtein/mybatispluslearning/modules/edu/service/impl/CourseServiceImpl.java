package cn.norshtein.mybatispluslearning.modules.edu.service.impl;

import cn.norshtein.mybatispluslearning.modules.edu.model.CourseModel;
import cn.norshtein.mybatispluslearning.modules.edu.mapper.CourseMapper;
import cn.norshtein.mybatispluslearning.modules.edu.service.iface.CourseService;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, CourseModel> implements CourseService {

}
