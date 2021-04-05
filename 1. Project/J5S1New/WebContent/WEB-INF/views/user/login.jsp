<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Bước 2</title>
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <!-- Tab links -->
    <div class="tab">
      <button
        class="tablinks"
        onclick="openTab(event, 'DDKT')"
        id="defaultOpen"
      >
        Danh sách đủ điều kiện thi
      </button>
      <button class="tablinks" onclick="openTab(event, 'CT')">
        Danh sách cấm thi
      </button>
    </div>

    <!-- Tab content -->
    <div id="DDKT" class="tabcontent">
      <h3>Danh sách đủ điều kiện thi</h3>
      <table style="width: 100%">
        <tr>
          <th>STT</th>
          <th>MSSV</th>
          <th>Tên SV</th>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
        </tr>
      </table>
    </div>

    <div id="CT" class="tabcontent">
      <h3>Danh sách cấm thi</h3>
      <table style="width: 100%">
        <tr>
          <th>STT</th>
          <th>MSSV</th>
          <th>Tên SV</th>
        </tr>
        <tr>
          <td>1</td>
          <td>PH11111</td>
          <td>Hồ Viết Thành</td>
        </tr>
        <tr>
          <td>2</td>
          <td>PH11112</td>
          <td>ABC</td>
        </tr>
      </table>
    </div>

    <!-- Export button -->
    <div class="export">
      <button class="exportbtn" onclick="exportExcel(event)">
        Chia buổi thi
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
