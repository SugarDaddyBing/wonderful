//jqgrid表格统一设置
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = "Bootstrap";
$.extend($.jgrid.defaults, {
	// 从服务器端返回的数据类型
	datatype: "json",
	// 此属性用来说明当初始化列宽度时候的计算类型，如果为ture，则按比例初始化列宽度。如果为false，则列宽度使用colModel指定的宽度
	shrinkToFit: true,
	// 定义是否要显示总记录数
	viewrecords: true,
	height: ($(window).height() - 200),
	// 在grid上显示记录条数，这个参数是要被传递到后台
	rowNum: 10,
	rowList: [10, 20, 30],
	rownumbers: true,
	rownumWidth: 25,
	autowidth: true,
	multiselect: true,
	// 定义翻页用的导航栏，必须是有效的html元素。翻页工具栏可以放置在html页面任意位置
	pager: "#jqGridPager",
	jsonReader: {
		root: "page.list", // 返回的数组集合
		page: "page.currPage", // 当前页数
		total: "page.totalPage", // 总页数
		records: "page.totalCount" // 总行数
	},
	prmNames: {
		page: "page", // 表示请求页码的参数名称
		rows: "limit", // 表示请求行数的参数名称
		order: "order", // 表示采用的排序方式的参数名称
		sort: "sort" // 表示用于排序的列名的参数名称
	},
	// 当表格所有数据都加载完成而且其他的处理也都完成时触发此事件，排序，翻页同样也会触发此事件
	gridComplete: function() {
		// 隐藏grid底部滚动条
		$("#jqGrid").closest(".ui-jqgrid-bdiv").css({
			"overflow-x": "hidden"
		});

	}
});
// 当调整浏览器窗口的大小时，发生 resize 事件
$(window).bind("resize", function() {
	var width = $("#jqGrid_wrapper").width();
	$("#jqGrid").setGridWidth(width);
})

// 选择一条记录
function getSelectedRowData() {
	var grid = $("#jqGrid");
	var rowKey = grid.getGridParam("selrow");
	if(!rowKey) {
		alert("请选择一条记录");
		return;
	}
	var selectedIDs = grid.getGridParam("selarrrow");
	if(selectedIDs.length > 1) {
		alert("只能选择一条记录");
		return;
	}
	return grid.getRowData(rowKey);
}