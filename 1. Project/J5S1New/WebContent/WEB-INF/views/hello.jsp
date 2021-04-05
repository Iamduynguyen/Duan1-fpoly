<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Bước 1</title>
    <link  rel="stylesheet"  href= "assets/style.css"></link> 
  </head>
  
  <body>
    <!-- Import button -->
    <form sty>
      <label for="myfile">Nhập File điểm:</label>
      <input type="file" id="myfile" name="myfile">
      <label for="myfile">Nhập File điểm danh:</label>
      <input type="file" id="myfile" name="myfile">
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
        id="defaultOpen"
      >
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
        <tr>
          <th>STT</th>
          <th>MSSV</th>
          <th>Tên SV</th>
          <th>Điểm</th>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
          <td>1</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
          <td>4</td>
        </tr>
      </table>
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
