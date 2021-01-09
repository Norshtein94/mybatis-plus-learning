package cn.norshtein.mybatispluslearning.common.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

// 代码自动生成器
public class CodeGenerator {
   public static void main(String[] args) {
    // 需要构建一个 代码自动生成器 对象
    AutoGenerator mpg = new AutoGenerator();
    // 配置策略
    // 1、全局配置
    GlobalConfig gc = new GlobalConfig();
    String projectPath = System.getProperty("user.dir");
    gc.setOutputDir(projectPath+"/src/main/java");
    gc.setAuthor("norshtein");//作者名称
    gc.setOpen(false);
    gc.setFileOverride(false); // 是否覆盖
    gc.setIdType(IdType.ID_WORKER);
    gc.setDateType(DateType.ONLY_DATE);

    // 自定义文件命名，注意 %s 会自动填充表实体属性！
    gc.setServiceName("%sService"); 
    gc.setControllerName("%sController");
    gc.setServiceName("%sService");
    gc.setServiceImplName("%sServiceImpl");
    gc.setMapperName("%sMapper");
    gc.setXmlName("%sMapper");
    gc.setEntityName("%sModel");
    mpg.setGlobalConfig(gc);

    //2、设置数据源
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setUrl("jdbc:mysql://127.0.0.1:3306/edu?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&connectTimeout=50000&socketTimeout=50000");
    dsc.setDriverName("com.mysql.cj.jdbc.Driver");
    // dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
    dsc.setUsername("root");
    dsc.setPassword("root");
    dsc.setDbType(DbType.MYSQL);
    mpg.setDataSource(dsc);
    //3、包的配置
    PackageConfig pc = new PackageConfig();
    pc.setParent("cn.norshtein.mybatispluslearning.modules"); //包名
    pc.setModuleName("edu"); //模块名
    pc.setEntity("model");
    pc.setMapper("mapper");
    pc.setService("service.iface");
    pc.setServiceImpl("service.impl");
    pc.setController("controller");
    mpg.setPackageInfo(pc);

   // 自定义配置
   InjectionConfig cfg = new InjectionConfig() {
       @Override
       public void initMap() {
           // to do nothing
       }
   };

   // 如果模板引擎是 freemarker
   String mapperXmlTemplate = "/templates/mapper.xml.ftl";

   // 自定义输出配置
   List<FileOutConfig> focList = new ArrayList<>();
   // 自定义配置会被优先输出
   focList.add(new FileOutConfig(mapperXmlTemplate) {
       @Override
       public String outputFile(TableInfo tableInfo) {
           // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
           return projectPath + "/src/main/resources/mapper/" + "edu"
                   + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
       }
   });
//    cfg.setFileCreate(new IFileCreate() {
//        @Override
//        public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//            // 判断自定义文件夹是否需要创建
// //                checkDir("调用默认方法创建的目录，自定义目录用");
// //                if (fileType == FileType.ENTITY) {
// //                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
// //                    return true;
// //                }
//            // 允许生成模板文件
//            return true;
//        }
//    });

   cfg.setFileOutConfigList(focList);
   mpg.setCfg(cfg);

    //4、策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setInclude("t_course","t_student"); // 设置要映射的表名
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true); // 自动lombok；
    strategy.setLogicDeleteFieldName("F_deleted");
    // 自动填充配置
    TableFill gmtCreate = new TableFill("F_gmt_create", FieldFill.INSERT);
    TableFill gmtModified = new TableFill("F_gmt_update",FieldFill.INSERT_UPDATE);
    ArrayList<TableFill> tableFills = new ArrayList<>();
    tableFills.add(gmtCreate);
    tableFills.add(gmtModified);
    strategy.setTableFillList(tableFills);
    // 乐观锁
    strategy.setVersionFieldName("F_version");
    //根据你的表名来建对应的类名，如果你的表名没有下划线，比如test，那么你就可以取消这一步
    strategy.setTablePrefix("t_");
    strategy.setFieldPrefix("F_");
    strategy.setRestControllerStyle(true); //rest请求
    //自动转下划线，比如localhost:8080/hello_id_2
    strategy.setControllerMappingHyphenStyle(true);
    mpg.setStrategy(strategy);
    TemplateConfig tc = new TemplateConfig();
    // tc.setController("/templates/controller.java");
    // tc.setService("/templates/service.java");
    // tc.setServiceImpl("/templates/serviceImpl.java");
    // tc.setEntity("/templates/entity.java");
    // tc.setMapper("/freemarker/mapper.java");
    // tc.setXml("/templates/mapper.xml");
    mpg.setTemplate(tc);
    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute(); //执行
 }
}