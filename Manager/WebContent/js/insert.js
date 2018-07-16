/**
 * 
 */
$(function(){
	$.ajax({
		url:"dept/queryAll",
		type:"post",
		dataType:"json",
		success:function(json){
			var item;
			$.each(json,function(i,result){
				item =json[i]['deptName'];
				$("#dept_id").append("<option value='"+item+"'>"+item+"</option>");
			})
		}
	})
	$("#dept_id").on("change",function(){
		var sel_var = $(this).find("option:selected").val();
		$("#student_id").empty();
		$.ajax({
			url:"employee/findemployeeName",
			dataType:"json",
			type:"post",
			data:{"selectVar":sel_var},
			success:function(data){
				var html;
				$.each(data,function(index,result){
					html =data[index]['lastName'];
					$("#student_id").append("<option value='"+html+"'>"+html+"</option>");
				})
			}
		})
	})
})
	