# Spring Boot

 <div align="center">
  <img src="https://github.com/user-attachments/assets/0a1a95ed-aea5-493a-883b-b56a7fe82c6e" alt="Spring Boot Logo" width="600">
</div>

## Bước 1
Vào website [này](https://start.spring.io) để tạo project cho Spring Boot. Ở đây
* `Group`: Là nhóm sản phẩm. Ở đây ta đặt **com.homanhquan**.
* `Artifact`: Là tên sản phẩm. Ở đây ta đặt **springboot**.

Thành ra, ta có 1 sản phẩm có tên **com.homanhquan.springboot**.

Tiếp đến ta tải các thư viện đi kèm sau:
* `Spring Web`
* `MySQL Driver`
* `Spring Data JPA`
* `Lombok`

Sau đó, click `Generate` để tải về project.

## Bước 2
Mở `application.properties` trong `src/main/resources`, điền:
```
spring.application.name=springboot
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=root
spring.datasource.password=62891920

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Ta tạo 6 thư mục trong **com.homanhquan.springboot**: `controller`, `dto`, `entity`, `exception`, `mapper`, `respiratory`, `service`.

## Bước 3
Để tạo 1 **table**, ta tạo file với tên Table tùy ý trong thư mục `entity` rồi chép code theo mẫu. Chỉ cần ấn **build** thì table sẽ được tạo trong database.
