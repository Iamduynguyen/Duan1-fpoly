<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  <link   href= "<c:url value="/assets/style.css"/>" rel="stylesheet" /> 
    <title>Bước 1</title>
    
  </head>
<style type="text/css">
/* Button */
button {
  padding: 10px;
	
}

/* Inline radio button */
#radio label {
  float: right;
  display: inline;
}
#radio input {
  width: auto;
  margin-left: 3em;
}
.check {
  padding: 10px;
}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  margin-top: 10px;
}

/* Style the buttons that are used to open the tab content */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

.tabcontent {
  animation: fadeEffect 1s; /* Fading effect takes 1 second */
}

/* Go from zero to full opacity */
@keyframes fadeEffect {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

table,
th,
td {
  border: 1px solid black;
  border-collapse: collapse;
}

td {
  text-align: center;
}

.exportbtn {
  float: right;
  margin-top: 10px;
}
</style>
  <body>

    <!-- Import button -->
      <form method="post" action="UploadServlet" enctype="multipart/form-data">
            Nhập File Điểm: <input type="file" name="uploadFile" />
            <br/><br/>
            
            <input type="submit" value="Upload" />
        </form> 
 <form method="post" action="UploadServlet" enctype="multipart/form-data">
            
            Nhập File Điểm Danh: <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form> 
    <!-- Check radio button -->
    <div class="check">
      <label for="none">
        <input
          type="radio"
          id="none"
          name="check"
          value="none"
          checked="checked"
        />
        Không check
      </label>
      <label for="bho">
        <input type="radio" id="bho" name="check" value="bho7.5" />
        Điểm BH Online >= 7.5
      </label>
      <label for="quiz">
        <input type="radio" id="quiz" name="check" value="quiz10" />
        Điểm tất cả Quiz = 10</label
      >
      
    </div>

    <!-- Tab links -->
    <div class="tab">
      <button
        class="tablinks"
        onclick="openTab(event, 'Diem')"
        id="defaultOpen">
        Danh sách điểm sinh viên
      </button>
      <button class="tablinks" onclick="openTab(event, 'Diem danh')">
        Danh sách điểm danh
      </button>
    </div>
    

    <!-- Tab content -->
    <div id="Diem" class="tabcontent">
      <h3>Điểm sinh viên</h3>
      <table style="width: 100%">
        
      </table>
    </div>
<div id="defaultOpen" class="tablinks">
<table style="width: 100%">
        <tr>
         
        </tr>

</div>
    <div id="Diem danh" class="tabcontent">
      <h3>Điểm danh</h3>
      <table style="width: 100%">
        <tr>
          <th>STT</th>
          <th>MSSV</th>
          <th>Tên SV</th>
          <th>Số buổi vắng</th>
          <th>Trạng thái</th>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>

        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
          <td>Đạt</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
          <td>Đạt</td>
        </tr>
      </table>
    </div>

    <!-- Export button -->
    <div class="export">
      <button class="exportbtn" onclick="exportExcel(event)">
        Xuất danh sách đủ điều kiện
      </button>
    </div>
  </body>
  <script>
    // Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
    function openTab(evt, tabName) {
      var i, tabcontent, tablinks;
      tabcontent = document.getElementsByClassName("tabcontent");
      for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
      }
      tablinks = document.getElementsByClassName("tablinks");
      for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
      }
      document.getElementById(tabName).style.display = "block";
      evt.currentTarget.className += " active";
    }
  </script>
</html>
