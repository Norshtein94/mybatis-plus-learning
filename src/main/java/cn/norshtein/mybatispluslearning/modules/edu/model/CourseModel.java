package cn.norshtein.mybatispluslearning.modules.edu.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author norshtein
 * @since 2021-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_course")
public class CourseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "F_id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程编号
     */
    @TableField("F_no")
    private String no;

    /**
     * 课程名
     */
    @TableField("F_name")
    private String name;

    /**
     * 教师
     */
    @TableField("F_teacher")
    private String teacher;

    /**
     * 创建时间
     */
    @TableField(value = "F_gmt_create", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "F_gmt_update", fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;

    /**
     * 逻辑删除标识
     */
    @TableField("F_deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 版本号
     */
    @TableField("F_version")
    @Version
    private Integer version;


}
