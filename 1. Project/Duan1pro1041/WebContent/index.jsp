<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html>

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("form").submit(function(event) {
			event.preventDefault();
			var formData = new FormData(this);
			$.ajax({
				url : "upload",
				type : "POST",
				data : formData,
				success : function(data) {
					var row = data;
					for (i = 0; i < row.length; i++) {
						var column = row[i];
						var eachrow = "<tr>";
						for (j = 0; j < column.length; j ++) {
							eachrow = eachrow + "<td>" + column[j] + "</td>";

						}
						eachrow = eachrow + "</td>";
						$('#tbody').append(eachrow);
					}
				},
				cache : false,
				contentType : false,
				processData : false
			});

		});

	});
</script>

</head>
<body>
<form enctype="multipart/form-data" method="post">
<input type="file" name="file">
<input type="Submit" value="Upload">
</form>
<table border="3" style="width: 100%" >
		<tbody id="tbody"></tbody>
		
		
</table>
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

</body>
</html>