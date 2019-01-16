>> 自定义Filter两个步骤：
    1.实现Filter接口，实现Filter方法
        com.tgram.sboot.filter.MyFilter

    2.添加@Configuration 注解，将自定义Filter加入过滤链
        com.tgram.sboot.config.WebConfiguration

>> 自定义properties配置
    1.在application.properties添加属性配置
        user.name=Tom
        user.age=20
        user.address=XiangYang

    2.实体类获取配置的属性值
        @Value("${user.names}")
        private String userName; //名称

        @Value("${user.age}")
        private Integer userAge; //年龄

        @Value("${user.address}")
        private String userAddress; //地址

>> Log配置
    logging.path=E:/Log/
    logging.level.com.favorites=DEBUG
    logging.level.org.springframework.web=INFO
    logging.level.org.hibernate=ERROR

>> 数据库操作步骤：
    1、添加相jar包
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

    2、添加配置文件(注意字符编码)
    spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase?&characterEncoding=utf-8
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver

    spring.jpa.properties.hibernate.hbm2ddl.auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
    spring.jpa.show-sql= true

    其实这个hibernate.hbm2ddl.auto参数的作用主要用于：自动创建|更新|验证数据库表结构,有四个值：
        create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，
                哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
        create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
        update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），
                以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。
                要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
        validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。

    dialect 主要是指定生成表名的存储引擎为InneoDB
    show-sql 是否打印出自动生产的SQL，方便调试的时候查看

    3、添加实体类和Dao

>> 使用Thymeleaf模版引擎
    1.maven中直接引入依赖
          <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
          </dependency>

    2.配置视图解析器
      spring-boot很多配置都有默认配置,比如默认页面映射路径为
      classpath:/templates/*.html
      同样静态文件路径为：classpath:/static/

      在application.properties中可以配置thymeleaf模板解析器属性.就像使用springMVC的JSP解析器配置一样：
          #thymeleaf start
          spring.thymeleaf.mode=HTML5
          spring.thymeleaf.encoding=UTF-8
          spring.thymeleaf.content-type=text/html
          #开发时关闭缓存,不然没法看到实时页面
          spring.thymeleaf.cache=false
          #thymeleaf end

      具体可以配置的参数可以查看
      org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties这个类,上面的配置实际上就是注入到该类中的属性值.

    3.创建controler层跳转到该页面
        @Controller
        public class ThymeleafController {

            private final String SUCCESS = "success";

            @Autowired
            private EmployeeService employeeService;

            /**
             * 访问success.html页面，路径：classpath:templates/xxx.html
             */
            @RequestMapping(value = "/page")
            public String successPage(Model model)
            {
                model.addAttribute("allEmps",employeeService.findAll());
                return SUCCESS;
            }

            /**
             * 分页查询数据
             */
            @RequestMapping(value = "/page/{page}/{size}")
            public String queryEmpsPage(@PathVariable(value = "page",required = false) Integer page,
                                        @PathVariable(value = "size",required = false) Integer size,
                                        Model model)
            {
                Pageable pageable = PageRequest.of(page,size);
                Page<Employee> all = employeeService.findAll(pageable);
                model.addAttribute("allEmps",all.getContent());
                return SUCCESS;
            }
        }

    4.在templates目录下创建html文件，注意html开始标签添加"xmlns:th="http://www.thymeleaf.org"
        <!DOCTYPE html>
        <html xmlns:th="http://www.thymeleaf.org" lang="en">
        <head>
            <meta charset="UTF-8">
            <title>SuccessPage</title>
        </head>
        <body>
        <h3 align="center">雇员信息列表</h3>
        <!-- 添加表格 -->
        <table align="center" border="0" cellpadding="15" cellspacing="0">
            <tr align="center" bgcolor="#7fffd4">
                <td>EmpId</td>
                <td>EmpName</td>
                <td>EmpAge</td>
                <td>EmpBirth</td>
            </tr>
            <!-- emp:${allEmps} : emp是临时变量，${allEmps}通过变量获取数据 -->
            <tr th:each="emp:${allEmps}" align="center">
                <td th:text="${emp.getEmpId()}">id</td>
                <td th:text="${emp.getEmpName()}">name</td>
                <td th:text="${emp.getEmpAge()}">age</td>
                <td th:text="${emp.getEmpBirth()}">birth</td>
            </tr>
        </table>
        </body>
        </html>