<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8' />
	<link href='fullcalendar/main.css' rel='stylesheet' />
	<script src='fullcalendar/main.js'></script>
	<script>
		document.addEventListener('DOMContentLoaded', function() {
		  var calendarEl = document.getElementById('calendar');
		  var calendar = new FullCalendar.Calendar(calendarEl, {
		    initialView: 'dayGridMonth'
		  });
		  calendar.render();
		});
	</script>
</head>
<body>
	안뇽
	<div id='calendar'></div>
</body>
</html>