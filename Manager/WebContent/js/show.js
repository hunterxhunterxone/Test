/**
 * 
 */
$(function(){
	$("#delete").click(function(){
		var child = $(this).parent().parent().children();
		var id = child[0].innerHTML;
		var flag = confirm("您要删除编号为"+id+"的员工?");
		if(flag){
			return true;
		}else{
			return false;
		}
	})
})