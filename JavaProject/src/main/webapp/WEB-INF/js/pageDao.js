
/**
 * 获取url的参数的值
 * 
 * @param name
 *            参数名
 * @returns 参数的值
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

/**
 * 获取url的参数的值
 * 
 * @param name
 *            参数名
 * @returns 参数的值
 */
function getQueryString1(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(2).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}






/**
 * 分页页码封装
 * @param pageCount 总页数
 * @param pageNum 当前页
 * @param pageSize 每页显示数据条数
 * @param num 需要显示的页码个数
 * @param pageContent 分页所放的ul的ID的值
 * @param path 页面路径
 */
function pageDao(pageCount,pageNum,sum,page_size,num,pageContent,path){

	//alert(page_size);
	$("#"+pageContent).append('<font size="5" color="#D2691E">共<font size=7 color=green face="楷体">'+sum+'</font>条记录</font>');
	$("#"+pageContent).append('<li><select id="pageSize" onchange=aaa("'+path+'","'+pageNum+'");><option id="3" value="3">3</option><option id="3" value="5">5</option><option id="3" value="10">10</option></select></li>');
	
	//var page_size = $("#pageSize").val(); 
	
	
	$("#"+pageContent).append('<font size="5" color="#D2691E"> 第<font size=7 color=green face="楷体">'+pageNum+'</font>页&nbsp;&nbsp; 共<font size=7 color=green face="楷体">'+pageCount+'</font>页  </font>');
	$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="1"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="首页" style="height:40px;"/></font></form></li>&nbsp'); 
	var up = pageNum-1;
	if (up >= 1) { 
		$("#"+pageContent).append('<li><form action="'+path+'" method="get"><input type="hidden" name="pageNum" value="'+up+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="上一页" style="height:40px;"/></font></form></li>&nbsp');
	}else {//已经是第一页面就不让点了
	}
	
	//循环出中间的页码数
	//当前总页数<=需要显示的页码个数时, 需要显示的页码数为5个,但共3页  那么只能显示1,2,3 页  没有4,5页
	if (pageCount <= num) {
		for (var i = 1;i<=pageCount;i++) {
			$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="'+i+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="'+i+'" style="height:40px;"/></font></form></li>&nbsp');
		}
	}else {
		//当前页数+需要显示的页码个数 >= 总页数时    共10页  当前8页, 需要显示页码个数 是3, 则8 9 10
		if ((pageNum+num) > pageCount) {
			for (var i = (pageCount-num);i<=pageCount;i++) {
				$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="'+i+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="'+i+'" style="height:40px;"/></font></form></li>&nbsp');
			}
		}else { //正常情况  从当前页的下一页开始显示需要显示的页码个数 即可
			for (var i = pageNum;i<=pageNum+num;i++) {
				$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="'+i+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="'+i+'" style="height:40px;"/></font></form></li>&nbsp');
			}
		}
	}
	
	var next = pageNum+1;
	console.log(next,pageCount);
	if (next <= pageCount) {
		$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="'+next+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="下一页" style="height:40px;"/></font></form></li>&nbsp');
	}else {//已经是第后页面就不让点了 
	}
	
	$("#"+pageContent).append('<li><form action="'+path+'"><input type="hidden" name="pageNum" value="'+pageCount+'"/><input type="hidden" name="pageSize" value="'+page_size+'"/><input type="hidden" name="pageSizes" value="'+$("select#pageSize").find("option:selected").val()+'"/><input type="hidden" name="id" value="'+$("select").find("option:selected").attr("id")+'"/><input type="hidden" name="arrangeCode" value="'+$("#arrangeCode").val()+'"/><input type="hidden" name="code" value="'+encodeURI($("#code").val())+'"/><font color="blue"><input type="submit" value="尾页" style="height:40px;"/></font></form></li>&nbsp'); 
	
	//$(".selector").find("option[text='pxx']").attr("selected",true);
	//alert(pageSize);
	
	
	//alert($("#"+pageContent).html());
	$("#pageSize").val(page_size);
	//alert($("#pageSize").find("option[text='"+pageSize+"']").val()+"==");
}

function aaa(path,pageNum)
{
	var pageSize = $("#pageSize").val();
	var sizeBiao="true";
	var code=encodeURI($("#code").val());
	code=encodeURI(code);
	var arrangeCode=$("#arrangeCode").val();
	var id=$("select").find("option:selected").attr("id");
	window.location.href=path+'?pageNum=' +pageNum+"&pageSize="+pageSize+"&sizeBiao="+sizeBiao+"&code="+code+"&arrangeCode="+arrangeCode+"&id="+id;
}
