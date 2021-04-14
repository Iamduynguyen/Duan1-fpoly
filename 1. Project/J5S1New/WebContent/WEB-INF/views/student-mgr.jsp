<?xml version="1.0" encoding="UTF-8"?>
<h1>STUDENT MANAGER</h1>
<form action="student-mgr.htm" method="post">
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
	${message}
	<div>Ho va ten</div>
	<input name="name"s />
	<div>Diem trung binh</div>
	<input name="mark" />
	<div>Chuyen nganh</div>
	<label> <input name="major" type="radio" value="APP" /> Ung
		dung phan mem
	</label> <label> <input name="major" type="radio" value="WEB" /> Thiet
		ke trang web
	</label>
	<hr>
	<button name="btnInsert" >Them</button>
	<button name="btnUpdate">Cap nhat</button>
	<button name="btnDelete">Xoa</button>
	<button name="btnReset">Nhap lai</button>
</form>
<hr>
<table border="1" style="width: 100%">
	<tr>
		<th>Ho va ten</th>
		<th>Diem TB</th>
		<th>Chuyen nganh</th>
		<th></th>
	</tr>
	<tr>
		<td>Le Pham Tuan Kit</td>
		<td>8.5</td>
		<td>CNTT</td>
		<td><a href="student-mgr.htm?lnkEdit">Sua</a></td>
	</tr>
	<tr>
		<td>Bui Minh Nhat</td>
		<td>7.5</td>
		<td>MUL</td>
		<td><a href="student-mgr.htm?lnkEdit">Sua</a></td>
	</tr>
</table>

</table>