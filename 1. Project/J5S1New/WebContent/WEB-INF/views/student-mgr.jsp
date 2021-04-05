<?xml version="1.0" encoding="UTF-8"?>
<h1>STUDENT MANAGER</h1>
<form action="student-mgr.htm" method="post">

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