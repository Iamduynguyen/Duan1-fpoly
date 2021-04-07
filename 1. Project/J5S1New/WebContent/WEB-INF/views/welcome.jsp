<%@ page pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Bước 2</title>
   
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
