package com.yun.crud.config;//package com.yun.crud.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Auther: Yun
 * @Date: 2020/12/10 14:27
 * @Description: 代码生成类
 * @ClassName: MyBatisPlusGenerator
 */
public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        //创建generator对象
        AutoGenerator autoGenerator = new AutoGenerator();

        //数据源的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&rewriteBatchedStatements=TRUE&useSSL=false&serverTimezone=CTT");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        autoGenerator.setDataSource(dataSourceConfig);

        //全局配置
        GlobalConfig globalConfig =new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("Yun");
        globalConfig.setOpen(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setActiveRecord(true);
        globalConfig.setSwagger2(true);
        globalConfig.setIdType(IdType.ASSIGN_ID);
        globalConfig.setDateType(DateType.TIME_PACK);
        autoGenerator.setGlobalConfig(globalConfig);

        //包信息配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.yun.crud");
        packageConfig.setEntity("entity");
        packageConfig.setController("controller");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        autoGenerator.setPackageInfo(packageConfig);

        //配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("user");
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);//使用RestController风格
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//数据库表名称下划线转驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表列名下划线转驼峰命名
//        strategyConfig.setControllerMappingHyphenStyle(true);//controller请求多字段连接,实现下划线连接
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();

    }
}
