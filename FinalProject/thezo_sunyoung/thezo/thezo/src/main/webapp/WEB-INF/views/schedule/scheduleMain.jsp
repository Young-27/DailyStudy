<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
  	<title>Insert title here</title>
    <meta charset='utf-8' />
    <!-- 풀캘린더 부트스트랩 -->
    <link href='https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.css' rel='stylesheet' />
	<link href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.13.1/css/all.css' rel='stylesheet'>
	
	<!-- 풀캘린더 -->
    <link href='${pageContext.request.contextPath}/resources/fullcalendar-5.8.0/lib/main.css' rel='stylesheet' />
    <script src='${pageContext.request.contextPath}/resources/fullcalendar-5.8.0/lib/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
    	  var calendarEl = document.getElementById('calendar');

    	  var calendar = new FullCalendar.Calendar(calendarEl, {
    	    initialView: 'dayGridMonth',
    	    initialDate: '2021-06-07',
    	    headerToolbar: {
    	      left: 'prev,next today',
    	      center: 'title',
    	      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    	    },
    	    events: [
    	      {
    	        title: 'All Day Event',
    	        start: '2021-06-01'
    	      },
    	      {
    	        title: 'Long Event',
    	        start: '2021-06-07',
    	        end: '2021-06-10'
    	      },
    	      {
    	        groupId: '999',
    	        title: 'Repeating Event',
    	        start: '2021-06-09T16:00:00'
    	      },
    	      {
    	        groupId: '999',
    	        title: 'Repeating Event',
    	        start: '2021-06-16T16:00:00'
    	      },
    	      {
    	        title: 'Conference',
    	        start: '2021-06-11',
    	        end: '2021-06-13'
    	      },
    	      {
    	        title: 'Meeting',
    	        start: '2021-06-12T10:30:00',
    	        end: '2021-06-12T12:30:00'
    	      },
    	      {
    	        title: 'Lunch',
    	        start: '2021-06-12T12:00:00'
    	      },
    	      {
    	        title: 'Meeting',
    	        start: '2021-06-12T14:30:00'
    	      },
    	      {
    	        title: 'Birthday Party',
    	        start: '2021-06-13T07:00:00'
    	      },
    	      {
    	        title: 'Click for Google',
    	        url: 'http://google.com/',
    	        start: '2021-06-28'
    	      }
    	    ]
    	  });

    	  calendar.render();
    	});
      });
      
      


    </script>
    <style>
    	#calendar{
		   width:60%;
		   margin:20px auto;
		}
    </style>
  </head>
  <body>
    <div id='calendar'></div>
  </body>
<body>
	
</body>
</html>