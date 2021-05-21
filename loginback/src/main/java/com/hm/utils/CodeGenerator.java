package com.hm.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : HM
 * @date : 2021-05-19 15:45
 * @description  代码生成器
 **/
public class CodeGenerator {
        public static void create() throws FileNotFoundException {
            String projectPath = System.getProperty("user.dir");
            // 1、声明代码生成器
            AutoGenerator generator = new AutoGenerator();
            // 2、全局信息配置
            GlobalConfig globalConfig = new GlobalConfig();
            globalConfig
                    // 输出目录
                    .setOutputDir(projectPath + "/src/main/java")
                    // 是否覆盖原有文件 默认false
                    .setFileOverride(true)
                    // 是否打开输出目录 默认true
                    .setOpen(false)
                    // 作者
                    .setAuthor("HM")
                    // 设置实体类名称
                    .setEntityName("%s")
                    // 设置mapper 命名方式
                    .setMapperName("%sDao")
                    // Mapper xml 命名方式
                    .setXmlName("%sDao")
                    //service 命名方式
                    .setServiceName("%sService")
                    //service impl 命名方式
                    .setServiceImplName("%sServiceImpl")
                    //controller 命名方式
                    .setControllerName("%sController")
                    // Mapper xml 生成基础 查询列 可以不设置
                    .setBaseColumnList(true)
                    //Mapper xml 生成基础返回map 可以不设置
                    .setBaseResultMap(true);
            // 3、数据源配置
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            // 设置数据库类型和数据源
            dataSourceConfig.setDbType(DbType.MYSQL)
                    .setDriverName("com.mysql.cj.jdbc.Driver")
                    .setUrl("jdbc:mysql://localhost:3306/login?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=GMT%2B8")
                    .setUsername("root")
                    .setPassword("123456");
            // 4、策略配置
            StrategyConfig strategyConfig = new StrategyConfig();
            strategyConfig
                    // 数据库表映射实体 下划线转大写，驼峰命名方式
                    .setNaming(NamingStrategy.underline_to_camel)
                    // 数据库字段映射实体属性 下划线转大写，驼峰命名方式
                    .setColumnNaming(NamingStrategy.underline_to_camel)
                    // 生成 @RestController 控制器
                    .setRestControllerStyle(true)
                    // 设置controller继承的父类
//                    .setSuperControllerClass(BaseController.class)
                    // entity继承的父类
//                    .setSuperEntityClass(BaseEntity.class)
                    // entity继承类的字段
                    .setSuperEntityColumns("id", "create_by", "create_time", "update_by", "update_time")
                    // 是否生成lombok模式
                    .setEntityLombokModel(true)
                    //要生成的表名
                    .setInclude("user");
            // 设置表前缀，生成的实体名称不包含前缀
            //        if (StrUtil.isNotEmpty() {
            //            strategyConfig.setTablePrefix();
            //        }
            // 5、生成代码包信息配置
            PackageConfig packageConfig = new PackageConfig();
            packageConfig
                    // 设置生成的包名的父类名称
                    .setParent("com.hm")
                    .setController("controller")
                    .setEntity("entity")
                    .setMapper("dao")
                    .setService("service")
                    .setServiceImpl("service.impl");
            //xml 自定义输出到java 文件夹下，所以下面自定义输出路径
            //                .setXml(mapper");
            // 6、自定义要注入到模板的属性
            InjectionConfig injectionConfig = new InjectionConfig() {
                // 必须实现的方法, 内容可以放空
                @Override
                public void initMap() {
                    //                Map<String, Object> map = new HashMap<>(4);
                    //                map.put("moduleName", "");
                    //                map.put("description", "");
                    //                this.setMap(map);
                }
            };
            List<FileOutConfig> fileOutConfigList = new ArrayList<>();
            FileOutConfig fileOutConfig = new FileOutConfig("/templates/mapper.xml.vm") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;
                }
            };
            fileOutConfigList.add(fileOutConfig);
            injectionConfig.setFileOutConfigList(fileOutConfigList);
            // 7 自定义模板~~~~
            TemplateConfig templateConfig = new TemplateConfig();
            // xml自定义输出路径，所以设置为null
            templateConfig.setXml(null);
            // 8、整合配置
            generator.setGlobalConfig(globalConfig)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(packageConfig)
                    .setTemplate(templateConfig)
                    .setCfg(injectionConfig);
            //9、执行
            generator.execute();
        }
        public static void main(String[] args) throws FileNotFoundException {
            create();
        }
    
}
