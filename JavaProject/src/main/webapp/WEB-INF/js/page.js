/**
 * 获取url的参数的值,解决了中文乱码
 * 
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return decodeURI(r[2]);
	return null;
}

/**
 * 分页页码封装
 * 
 * @param pageCount
 *            总页数
 * @param pageNum
 *            当前页
 * @param pageSize
 *            每页显示数据条数
 * @param num
 *            需要显示的页码个数
 * @param pageContent
 *            分页所放的ul的ID的值
 * @param path
 *            页面路径 多了一个功能——可以改变页数,其余和上面一样的,还多了一个参数num——需要显示的页码数
 */
function pageSign(pageCount, pageNum, sum, page_size, num, pageContent,
		totalCount) {
	// 添加一个标签,功能在于显示多少条数据
	$("#" + pageContent).append('<font style="padding-left: 500px;" size="5">共[' + sum + ']条记录</font>');
	if (pageNum > pageCount) {// 如果当前页数大于总页数则当前页数等于总页数
		// 这里加上这个判断如果出现这个条件中的情况，则显示到页面的第几页,共几页的字能显示正确
		pageNum = pageCount;
	}
	// 添加一个下拉框,当下拉框的值改变时就触发事件,调用函数changePageSize,将页面路径和当前页数传进,下拉框的值有3,5,10(可以添加和修改)
	$("#" + pageContent).append('<li style="margin-right:5px;" class="disabled"><select style="width:50px;height:30px;" id="pageSize" onchange=changePageSize("'+ totalCount+ '","'+ pageNum+ '");><option value="3">3</option><option value="5">5</option><option value="10">10</option></select></li>');
	$("#" + pageContent).append('<li><a onclick=pageSubmit(' + 1 + ',' + page_size+ ')>首页</a></li>');
	var up = pageNum - 1;
	if (up >= 1) {
		// $("#"+pageContent).append('<li><a
		// href="'+path+'?pageNum='+up+'&pageSize='+page_size+'">上一页</a></li>');
		$("#" + pageContent).append('<li><a onclick=pageSubmit(' + up + ',' + page_size+ ')>上一页</a></li>');
	} else {// 已经是第一页面就不让点了
		$("#" + pageContent).append('<li><a>上一页</font></li>');
	}

	// 循环出中间的页码数
	// 当前总页数<=需要显示的页码个数时, 需要显示的页码数为5个,但共3页 那么只能显示1,2,3 页 没有4,5页
	if (pageCount <= num) {
		for (var i = 1; i <= pageCount; i++) {
			$("#" + pageContent).append('<li><a onclick=pageSubmit(' + i + ',' + page_size + ')>'+ i + '</a></li>');
		}
	} else {
		// 当前页数+需要显示的页码个数 >= 总页数时 共10页 当前8页, 需要显示页码个数 是3, 则8 9 10
		if ((pageNum + num) > pageCount) {
			for (var i = (pageCount - num + 1); i <= pageCount; i++) {
				$("#" + pageContent).append('<li><a onclick=pageSubmit(' + i + ',' + page_size+ ')>' + i + '</a></li>');
			}
		} else { // 正常情况 从当前页的下一页开始显示需要显示的页码个数 即可
			for (var i = pageNum + 1; i <= pageNum + num; i++) {
				$("#" + pageContent).append('<li><a onclick=pageSubmit(' + i + ',' + page_size+ ')>' + i + '</a></li>');
			}
		}
	}

	var next = pageNum + 1;
	console.log(next, pageCount);
	if (next <= pageCount) {
		$("#" + pageContent).append('<li><a onclick=pageSubmit(' + next + ',' + page_size+ ')>下一页</a></li>');
	} else {// 已经是第后页面就不让点了
		$("#" + pageContent).append('<li><a>下一页</a></li>');
	}
	
	$("#" + pageContent).append('<li><a onclick=pageSubmit(' + pageCount + ',' + page_size+ ')>尾页</a></li>');
	$("#" + pageContent).append('<font size="5">&nbsp;&nbsp;第' + pageNum + '页&nbsp;&nbsp; 共'+ pageCount + '页  </font>');
	$("#pageSize").val(page_size);// 捕捉到pageSize的id将当前页面的值设进去
}

function pageSubmit(pageNum, pageSize) {// 点击后提交的函数
	$("#pageNumStr").val(pageNum);
	$("#pageSizeStr").val(pageSize);
	$("#formId").submit();
}

function changePageSize(totalCount, pageNum) {// 更改条数的函数
	var pageSize = $("#pageSize").val(); // 获取到下拉框的值赋给pageSize变量
	var modulo = totalCount % pageSize;// 取模
	if (modulo == 0) {// 当取模为1满足条件
		var pageNumber = totalCount / pageSize;// 正常运算获得总页数
		if (pageNum > pageNumber) {// 如果当前页数大于最大的页数，则当前页数等于最大的页数
			pageNum = pageNumber;
		}
	} else {// 表示有小数
		pageNumber = Math.ceil(totalCount / pageSize);// 向上取整数
		if (pageNum > pageNumber) {// 如果当前页数大于最大的页数，则当前页数等于最大的页数
			pageNum = pageNumber;
		}
	}
	$("#pageNumStr").val(pageNum);// 将当前页面的值设入到id为pageNum中
	$("#pageSizeStr").val(pageSize);// 将当前条数的值设入id为pageSize中
	window.location.reload();// 刷新
	// window.location.href=path+'?pageNum='
	// +pageNum+"&pageSize="+pageSize;//然后将当前页面的条数更改后再次进入就达到更改页面条数的效果
}
