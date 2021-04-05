
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset = "utf-8"/>
    <title>form</title>
    <base href = "${pageContext.servletContext.contextPath}/">
</head>
<body>
    <div class="box">
    <h2>Sinh viên poly</h2>

    <form action = "student.htm" method = "post" >
        <div>Họ và tên</div>
        <input name="name" />
        <div>Điểm trung bình</div>
        <input name="mark" />
        <div>Chuyên ngành</div>
        <label> <input name="major" type="radio" value="UDPM" /> Ứng
            dụng phần mềm
        </label> <label> <input name="major" type="radio" value="WEB" />
        Thiết kế trang web
    </label><hr>
        <button class="btn btn-primary">Lưu</button>
    </form>
</div>
</body>
</html>
