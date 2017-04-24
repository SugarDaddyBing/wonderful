//jqgrid表格统一设置
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = "Bootstrap";
$.extend($.jgrid.defaults, {
	datatype : "json",
	shrinkToFit : true,
	viewrecords : true,
	//height : getHeight(),
	rowNum : 20,
	rowList : [ 20, 30, 50 ],
	rownumbers : true,
	rownumWidth : 25,
	autowidth : true,
	multiselect : true,
	pager : "#jqGridPager",
	jsonReader : {
		root : "page.list",// 返回的数组集合
		page : "page.currPage",// 当前页数
		total : "page.totalPage",// 总页数
		records : "page.totalCount"// 总行数
	},
	prmNames : {
		page : "page",// 表示请求页码的参数名称
		rows : "limit",// 表示请求行数的参数名称
		order : "order",// 表示采用的排序方式的参数名称
		sort : "sort"// 表示用于排序的列名的参数名称
	},
	gridComplete : function() {
		// 隐藏grid底部滚动条
		$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
			"overflow-x" : "hidden"
		});

		// $("#jqGrid").closest(".ui-pg-input").css({
		// "overflow-x": "hidden"
		// });
	}
});
$(window).bind("resize", function() {
	var width = $(".jqGrid_wrapper").width();
	$("#jqGrid").setGridWidth(width);
	//$("#jqGrid").setGridHeight(getHeight());
})