Mục đích của ví dụ này:
+ TÌm hiểu về spring MVC & kiến trúc chuẩn của nó 
+ Thêm log framework 
+ Thêm Hibernate 


http://o7planning.org/web/fe/default/en/document/8108/spring-mvc-tutorial-for-beginners#a252302
http://o7planning.org/web/fe/default/en/document/425414/configuring-static-resource-and-resource-bundle-in-spring-mvc-tutorial

Kiến trúc:
+ File cấu hình web.xml
+ File cấu hình chuyên cho dispatcher: bên trong webapp/WEB-INF/spring/appServlet 
+ File cấu hình context: root-context 
+ Khu vục dành cho views: webapp/WEB-INF/views 
Chú ý là phải có khai báo viewResolver 
+ Khu vực dành cho controller: package controller
Chú ý là phải có context:component-scan được khai báo 
và phải có khai báo annotation-driven 
+ Khu vực dành cho resources:main/webapp/resources
Chú ý là phải có khai báo:	<resources mapping="/styles/**" location="/resources/css/" />

Log file:
http://www.mkyong.com/spring-mvc/spring-mvc-logback-slf4j-example/
+ Sử dụng sl4j(logback) vì khá ưu việt(so với log4j)
+ Chú ý file logback.xml là file cấu hình, file này sẽ output log ra file với trường hợp error hoặc info, output ra console với trường hợp debug  

Hibernate:
http://o7planning.org/web/fe/default/en/document/138855/spring-mvc-and-hibernate-transaction-tutorial#a141398
Kết hợp thêm CRUD:http://www.journaldev.com/3524/spring-hibernate-integration-example-tutorial