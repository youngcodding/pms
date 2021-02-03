<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<link rel="shortcut icon" href="${ctx}/favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

<!-- Data Tables -->
<link href="${ctx}/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">
<!-- 引入文件上传组件 webuploader 的样式 -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/plugins/webuploader/webuploader.css">

<!-- 全局js -->
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 引入分页插件  -->
<script src="${ctx}/js/bootstrap-paginator.js"></script>



<script src="${ctx}/js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="${ctx}/js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 引入日历插件js文件 -->
<script src="${ctx}/js/plugins/layer/laydate/laydate.js"></script>

<!-- iCheck -->
<script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

<!-- 引入弹框插件 layer  -->
<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

<!-- 引入 文件上传组件 webuploader 的js -->
<script src="${ctx}/js/plugins/webuploader/webuploader.js"></script>

<!-- 引入 Jquery.validate.js 表单验证框架 -->
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/messages_zh.min.js"></script>

<!-- 自定义js -->
<script src="${ctx}/js/content.js?v=1.0.0"></script>


<style type="text/css">
.msgErrorStyle {
	background: red;
	font-size: 20px;
}
</style>

<script type="text/javascript">
	$(function() {

		/* 		//外部js调用,日期控件获取光标时候触发事件调用出日历
		 laydate({
		 elem : '#deadline', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		 event : 'focus' //响应事件。如果没有传入event，则按照默认的click
		 }); */
		//日期范围限制
		var start = {
			elem : "#start",
			format : 'YYYY/MM/DD hh:mm:ss',
			min : laydate.now(), //设定最小日期为当前日期
			max : '2099-06-16 23:59:59', //最大日期
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};
		var end = {
			elem : "#end",
			format : 'YYYY/MM/DD hh:mm:ss',
			min : laydate.now(),
			max : '2099-06-16 23:59:59',
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，重置开始日的最大日期
			}
		};
		var deadLine = {
			elem : "#deadLine",
			format : 'YYYY/MM/DD hh:mm:ss',
			min : laydate.now(),
			max : '2099-06-16 23:59:59',
			istime : true,
			istoday : false,
			choose : function(datas) {
				deadLine.max = datas; //结束日选好后，重置开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
		laydate(deadLine);
		//初始化获取小区信息
		getCommunity();
		
		//显示已缴/未缴的物业费
		$("#isPropertyFee").change(function(){
			//console.log(this.value)
			if(this.value==1){
				window.location.href="${ctx}/propertyFee.gzsxt?cmd=properity_list&feeStatus=1";
			}else{
				window.location.href="${ctx}/propertyFee.gzsxt?cmd=properity_list&feeStatus=0";
			}
		})
		
		
		$("#regForm")
				.validate(
						{
							rules : {

							},
							messages : {

							},
							submitHandler : function() {
								var formData = $("#regForm").serialize();
								console.log(formData);
								$
										.post(
												"${ctx}/propertyFee.gzsxt?cmd=addPropertyFee",
												formData,
												function(data) {
													if (data.code == 1) {
														//使用layer插件进行弹框提示
														//墨绿深蓝风
														layer
																.alert(
																		data.msg,
																		{
																			skin : 'layui-layer-molv' //样式类名
																		},
																		function(
																				index) {
																			layer
																					.close(index);
																			window.location.href = "${ctx}/propertyFee.gzsxt?cmd=addProperity";
																		});
													} else {
														layer
																.alert(
																		data.msg,
																		{
																			skin : 'layui-layer-molv' //样式类名
																		});
													}

												});
							}
						});

	});
	function getCommunity() {
		$.get("${ctx}/propertyFee.gzsxt", {
			cmd : "getCommunity"
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, community) {
				options += "<option value='"+community.id+"'>"
						+ community.residentialName + "<option>";

			});
			$("#community").html(options);
		});
	}
	function getBuildId(obj) {
		//console.log($("#community1"));
		var options = $(obj).children();
		$.each(options, function(index, option) {
			if (option.selected) {
				//console.log(option.text);
				$("#community1")[0].value = option.text;
			}
		});

		$.get("${ctx}/propertyFee.gzsxt", {
			cmd : "getBuild",
			communityNum : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, build) {
				options += "<option value='"+build.id+"'>" + build.buildName
						+ "<option>";
			});
			$("#build").html(options);
		});
	}
	function getFloorId(obj) {
		var options = $(obj).children();
		$.each(options, function(index, option) {
			if (option.selected) {
				//console.log(option.text);
				$("#build1")[0].value = option.text;
			}
		});

		$.get("${ctx}/propertyFee.gzsxt", {
			cmd : "getFloor",
			buildNum : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, floor) {
				options += "<option value='"+floor.id+"'>" + floor.floorName
						+ "<option>";
			});
			$("#floor").html(options);
		});
	}
	function getRoomId(obj) {
		var options = $(obj).children();
		$.each(options, function(index, option) {
			if (option.selected) {
				//console.log(option.text);
				$("#floor1")[0].value = option.text; //设置floor表单隐藏域的值
			}
		});

		$.get("${ctx}/propertyFee.gzsxt", {
			cmd : "getRoom",
			floorNum : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, room) {
				//console.log(room.id)
				options += "<option data-id='"+room.id+"' value='"+room.id+"'>"
						+ room.roomName + "<option>";
			});
			$("#room").html(options);
		});
	};
	//对房间下拉框监听事件，用于设置表单房间的值和roomID的值
	function getRoomName(obj) {
		//console.log(obj)
		var options = $(obj).children();
		$.each(options, function(index, option) {
			if (option.selected) {
				//console.log($(option).data("id"));
				$("#room1")[0].value = option.text; //将房间的文本值（房间名字）赋给room表单
				$("#roomID")[0].value = option.value; //将房间的value值（房间号）赋给roomid表单

			}
		});
	}
</script>



</head>

<body class="gray-bg">

	<div class="col-sm-12">

		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>
					基本 <small>分类，查找</small>
				</h5>
				<div class="ibox-tools">
					<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
					</a> <a class="dropdown-toggle" data-toggle="dropdown"
						href="table_data_tables.html#"> <i class="fa fa-wrench"></i>
					</a> <a class="close-link"> <i class="fa fa-times"></i>
					</a>
				</div>
			</div>

			<div class="ibox-content">
				<div id="DataTables_Table_0_wrapper"
					class="dataTables_wrapper form-inline" role="grid">
					<div class="row">
						<div class="col-sm-2">
							<div class="dataTables_length" id="DataTables_Table_0_length">
								<label>每页 <select id="pageSize"
									class="form-control input-sm">
										<option value="10" ${pageResult.pageSize eq 10 ?'selected':''}>10</option>
										<option value="25" ${pageResult.pageSize eq 25 ?'selected':''}>25</option>
										<option value="50" ${pageResult.pageSize eq 50 ?'selected':''}>50</option>
										<option value="100"
											${pageResult.pageSize eq 100 ?'selected':''}>100</option>
								</select> 条记录
								</label>
							</div>
						</div>
						
						<div class="col-sm-6">
							<div class="btn-group">
								 <select id="isPropertyFee"
									class="form-control input-sm">
										<option  style="font:10px;" value="1" ${feeStatus eq 1 ? 'selected':''}>
										未缴的物业费信息
										</option>
										<option  style="font:10px;" value="0" ${feeStatus eq 0 ? 'selected':''}>
										已缴的物业费信息
										</option>
								</select>
							</div>
	<%-- <a data-toggle="modal" href="${ctx}/WebRoot/sysuser/add_user.html" data-target="#modal">请点击我</a> --%>
						</div>
						<div class="col-sm-4">
							<div id="DataTables_Table_0_filter" class="dataTables_filter">
								<label>查找：<input class="form-control input-sm"
									placeholder="请输入关键字" id="search" type="search"
									value="${keyword}"></label>
							</div>
						</div>


						<table
							class="table table-striped table-bordered table-hover dataTables-example dataTable"
							id="DataTables_Table_0"
							aria-describedby="DataTables_Table_0_info">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0">房产</th>
									<th class="sorting_asc" tabindex="0">业主</th>
									<th class="sorting_asc" tabindex="0">计费单位</th>
									<th class="sorting_asc" tabindex="0">单位价格</th>
									<th class="sorting_asc" tabindex="0">应交费用</th>
									<th class="sorting_asc" tabindex="0">本次费用起期</th>
									<th class="sorting_asc" tabindex="0">本次费用止期</th>
									<!-- <th class="sorting_asc" tabindex="0" >状态</th> -->
									<th class="sorting_asc" tabindex="0">本次缴费期限</th>
									<th class="sorting_asc" tabindex="0">纸质版收据照片</th>
									<th class="sorting_asc" tabindex="0">操作</th>
								</tr>
							</thead>
							<tbody>

								<!-- 使用标签库 c:forEach 循环 集合${pageResult.dataList} -->
								<c:forEach items="${pageResult.dataList}" var="propertyFee"
									varStatus="vs1">
									<tr id="tr_${propertyFee.id}" class="gradeA odd">
										<td class="">${propertyFee.houseName}</td>
										<td class="">${propertyFee.proprietorName}</td>
										<td class="">${propertyFee.chargeUnit}</td>
										<td class="">${propertyFee.price}</td>
										<td class="">${propertyFee.fee}</td>
										<td class="">${propertyFee.startDate}</td>
										<td class="">${propertyFee.endDate}</td>
										<td class="">${propertyFee.deadLine}</td>
										<td class=""><img style="width:100px;height:80px;"
											src="images/${propertyFee.receipt}"></td>
										<td class="">
											<!-- 使用onclick 触发删除函数 -->
											<button onclick="delPropertyFee(this,${propertyFee.id})"
												class="btn btn-danger">删除</button> 
												
												<!-- 使用超链接 点击 让其弹出一个模态窗口 -->
											<a onclick="updateProperty(this);" class="btn btn-info"
											data-toggle="modal" href="#modal-form"
											data-id="${propertyFee.id}" 
											data-houseName="${propertyFee.houseName}"
											data-price="${propertyFee.price}"
											data-chargeUnit="${propertyFee.chargeUnit}"
											data-fee="${propertyFee.fee}"
											data-startDate="${propertyFee.startDate}"
											data-endDate="${propertyFee.endDate}"
											data-deadLine="${propertyFee.deadLine}"
											data-room_id="${propertyFee.room_id}"
											data-proprietorName="${propertyFee.proprietorName}"
											>修改</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_info">
									第${pageResult.currentPage} 页 共<span id="totalPage">${pageResult.totalPage}</span>页,总供
									<span id="totalCount">${pageResult.totalCount}</span>条数据
								</div>
							</div>
							<div class="col-sm-6">
								<div class="dataTables_paginate paging_simple_numbers"
									id="DataTables_Table_0_paginate">
									<ul id="pagination"></ul>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!-- 模态对话框 -->
		<div id="modal-form" class="modal fade ">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<div class="row">
							<div class="col-sm-12">
								<h3 class="m-t-none m-b">修改用户</h3>

								<form class="form-horizontal" action="" method="post"
									id="form">
									
									<div class="form-group draggable ui-draggable">
										<label class="col-sm-3 control-label">房产：</label>
										<div class="col-sm-7">
											<input id="houseName" type="text" name="houseName"
												class="form-control" readonly="readonly">
											 <span class="help-block m-b-none" id="houseNameMsg"></span>
										</div>
									</div>
									<div class="form-group draggable ui-draggable">
										<label class="col-sm-3 control-label">业主：</label>
										<div class="col-sm-7">
											<input id="proprietorName" type="text" name="proprietorName"
												class="form-control" readonly="readonly">
											 <span class="help-block m-b-none" id="proprietorNameMsg"></span>
										</div>
									</div>
									<div class="form-group" id="unameForm">
										<label class="col-sm-3 control-label">计费单位：</label>
										<div class="col-sm-7">
											<input id="chargeUnit" type="text" name="chargeUnit"
												class="form-control" placeholder="请输入计费单位"> <span
												class="help-block m-b-none" id="chargeUnitMsg"></span>
										</div>
									</div>
									<div class="form-group" id="unameForm">
										<label class="col-sm-3 control-label">单位价格：</label>
										<div class="col-sm-7">
											<input id="price" type="text" name="price"
												class="form-control" placeholder="请输入单位价格"> <span
												class="help-block m-b-none" id="priceMsg"></span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">本次费用日期：</label>
										<div class="col-sm-7">
											<input name="startDate" placeholder="开始日期"
												class="form-control layer-date" id="start"> <span
												class="help-block m-b-none" id="startDateMsg"></span> <input
												placeholder="结束日期" name="endDate"
												class="form-control layer-date" id="end"> <span
												class="help-block m-b-none" id="endDateMsg"></span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">本次费用期限：</label>
										<div class="col-sm-7">

											<input id="deadLine" name="deadLine"
												class="laydate-icon form-control layer-date"> <span
												class="help-block m-b-none" id="endDateMsg"></span>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">纸质版收据：</label>
										<div class="col-sm-7">
											<div id="uploader" class="wu-example">
												<!--用来存放文件信息-->
												<div id="thelist1" class="uploader-list"></div>
												<div class="btns" id="idcard_id1">
													<div id="picker1">选择文件</div>
													<!-- button如果不指定   type 为button 默认是submit -->

													<button id="filectlBtn" type="button"
														class="btn btn-default">开始上传</button>
												</div>
											</div>

											<!-- 收据照片隐藏域表单,value是图片上传成功以后的 地址 -->
											<input type="hidden" id="receipt" name="receipt" />
										</div>
									</div>
	
									<input type="hidden" id="roomID" name="room_id" value=""
										class="form-control">
									<input type="hidden" id="id" name="id" value=""
										class="form-control">

									<div class="form-group">
										<div class="col-sm-offset-3 col-sm-8">
											<button class="btn btn-sm btn-primary" type="submit">生产物业费</button>
											<button class="btn btn-sm " type="reset">重置</button>
										</div>
									</div>
								</form>

								<script type="text/javascript">
									//收据照片
									jQuery(function() {
										var uploader=null;
										$("#modal-form").on("shown.bs.modal",function(){
										var $ = jQuery, $list = $("#thelist1"), // thelist节点中添加文本  身份证正面  div添加  
										$btn = $("#filectlBtn"), // 文件上传按钮   身份证正面 文件上传按钮
										state = 'pending', uploader;

										//初始化
										uploader = WebUploader
												.create({
													// 不压缩image
													resize : false,

													// 文件接收服务端。
													server : "${ctx}/fileUpload.gzsxt",

													// 选择文件的按钮。可选。
													// 内部根据当前运行是创建，可能是input元素，也可能是flash.
													//开始上传 按钮的id 
													pick : "#picker1",

													// 只允许选择图片文件。
													accept : {
														title : 'Images',
														extensions : 'jpg,jpeg,bmp,png',
														mimeTypes : 'image/*'
													},
													//允许上传的文件个数
													fileNumLimit : 1,
													//单个文件最大的上传限制 1M
													fileSingleSizeLimit : 1024 * 1024
												// 1M
												});

										// 当有文件添加进来的时候
										uploader
												.on(
														'fileQueued',
														function(file) {
															$list
																	.append('<div id="' + file.id + '" class="item">'
																			+ '<h4 class="info">'
																			+ file.name
																			+ '</h4>'
																			+ '<p class="state">等待上传...</p>'
																			+ '</div>');
														});

										// 文件上传过程中创建进度条实时显示。
										uploader
												.on(
														'uploadProgress',
														function(file,
																percentage) {
															var $li = $('#'
																	+ file.id), $percent = $li
																	.find('.progress .progress-bar');

															// 避免重复创建
															if (!$percent.length) {
																$percent = $(
																		'<div class="progress progress-striped active">'
																				+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
																				+ '</div>'
																				+ '</div>')
																		.appendTo(
																				$li)
																		.find(
																				'.progress-bar');
															}

															$li
																	.find(
																			'p.state')
																	.text('上传中');

															$percent
																	.css(
																			'width',
																			percentage
																					* 100
																					+ '%');
														});

										//文件上传成功后  触发的事件  触发一个回调函数
										uploader
												.on(
														'uploadSuccess',
														function(file, response) {
															console
																	.log("---"
																			+ response.code
																			+ "-------reData:"
																			+ response.msg
																			+ "---");

															// 上传的图片保存的相对位置
															var idcard_url = response.msg;
															$("#idcard_id1")
																	.append(
																			"<br><img  src='images/"+idcard_url+"' style='width: 150px;height: 150px' />");

															//将url 添加到  form表单的隐藏域中
															$("#receipt").val(
																	idcard_url);

															$('#' + file.id)
																	.find(
																			'p.state')
																	.text('已上传');
														});

										uploader.on('uploadError', function(
												file) {
											//TODO
											$('#' + file.id).find('p.state')
													.text('上传出错');
										});

										uploader.on('uploadComplete', function(
												file) {
											$('#' + file.id).find('.progress')
													.fadeOut();
										});

										uploader
												.on(
														'all',
														function(type) {
															if (type === 'startUpload') {
																state = 'uploading';
															} else if (type === 'stopUpload') {
																state = 'paused';
															} else if (type === 'uploadFinished') {
																state = 'done';
															}

															if (state === 'uploading') {
																$btn
																		.text('暂停上传');
															} else {
																$btn
																		.text('开始上传');
															}
														});

										//出错以后回调的函数
										uploader.on("error", function(type) {
											alert(type);
											if (type == "F_EXCEED_SIZE") {
												layer.alert('最大只能上传1M文件', {
													skin : 'layui-layer-molv' //样式类名
												});
											}
										});

										$btn.on('click', function() {
											if (state === 'uploading') {
												uploader.stop();
											} else {
												uploader.upload();
											}
										});
										});
										//关闭模态框销毁WebUploader，解决再次打开模态框时按钮越变越大问题
										$("#modal-form").on('hide.bs.modal', function () {
										   $("#filectlBtn").text("");
										  // uploader.destroy();
										});
									});
								</script>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			/**
			 *@param obj dom对象本身
			 */
			function updateProperty(obj) {
					console.log(obj);
					//获取当前超链接上面的所有data-xx属性 (H5的新特性，自定义属性，data-xxx,后面显示的页面会自动变成小写)
					var id = $(obj).data("id");
					var houseName = $(obj).data("housename");
					var price = $(obj).data("price");
					var chargeUnit = $(obj).data("chargeunit");
					var startDate = $(obj).data("startdate");
					var endDate = $(obj).data("enddate");
					var deadLine = $(obj).data("deadline");
					var feeStatus = $(obj).data("feestatus");
					var receipt = $(obj).data("receipt");
					var room_id = $(obj).data("room_id");
					var proprietorName = $(obj).data("proprietorname");
					
					
					//获取form表单
					var regForm = $("#form")[0];
					console.log(houseName)
					//将获取的数组赋值给表单元素对应的value值
					regForm.id.value = id;
					regForm.houseName.value = houseName;
					regForm.proprietorName.value =proprietorName;
					regForm.price.value = price;
					regForm.chargeUnit.value = chargeUnit;
					regForm.startDate.value = startDate;
					regForm.endDate.value = endDate;
					regForm.deadLine.value = deadLine;
					regForm.receipt.value = receipt;
					regForm.room_id.value = room_id;  
			}
			$(function(){
				//为修改表单绑定 jquery.validate表单校验框架
				$("#form").validate({
					rules:{
			
					},
					messages:{
						
					},
					/* 校验完毕触发的事件 */
					submitHandler : function() {
						//序列化表单
						var formData = $("#form").serialize();
						console.log(formData)
						//发送ajax请求去后台修改数据
						$.post("${ctx}/propertyFee.gzsxt?cmd=updatePropertyFee",formData,function(data){
							
							if(data.code == 1){//修改成功
								layer.alert(data.msg,
										{
											skin : 'layui-layer-molv' //样式类名
										},
										function(index) {
											layer.close(index);
							//将修改的数据设置当前用对应的行中
							//获取form表单
								var form = $("#form")[0];
							//获取当前修改数据对应的 的行 
								var tr = $("#tr_"+form.id.value);
								console.log(tr);
								//获取当前行的所有td
								var tds = tr.children();
								console.log(tds);
								//将表单的昵称设置给第三列数据
								$(tds).eq(2).text(form.chargeUnit.value)
								//将表单的电话设置给第四列数据
								$(tds).eq(3).text(form.price.value)
								//将表单的邮箱设置给第五列数据
								$(tds).eq(4).text(form.price.value*form.chargeUnit.value)
								//将表单的qq设置给第六列数据
								$(tds).eq(5).text(form.startDate.value)
								//将表单的注册日期设置给第七列数据
								$(tds).eq(6).text(form.endDate.value) 
								$(tds).eq(7).text(form.deadLine.value) 
								$(tds).eq(8).html("<img style='width:100px;height:80px;'"+
													"src='images/"+form.receipt.value+"'>")
								//隐藏模态窗口
								$('#modal-form').modal('hide');
										});
							}else {layer.alert(data.msg,
									{
								skin : 'layui-layer-molv' //样式类名
							});
		}
							
							
						})
			}
});
			});
			

			$(function() {
				//每页条数
				var pageSize = ${pageResult.pageSize};
				//关键字	
				
				//显示未缴/已缴物业费
				var feeStatus=${feeStatus};

				$("#pagination")
						.bootstrapPaginator(
								{
									currentPage : ${pageResult.currentPage},//当前页
									totalPages : ${pageResult.totalPage},//总页数
									size : "normal",
									bootstrapMajorVersion : 3,
									alignment : "right",
									numberOfPages : 7,
									itemTexts : function(type, page, current) {
										switch (type) {
										case "first":
											return "首页";
										case "prev":
											return "上一页";
										case "next":
											return "下一页";
										case "last":
											return "尾页";
										case "page":
											return page;
										}
									},
									onPageClicked : function(event,
											originalEvent, type, page) {
										//TODO具体页面操作
										//跳转到后台用户列表,传递当前页以及每页条数的参数
										window.location.href = "${ctx}/propertyFee.gzsxt?cmd=properity_list&currentPage="
												+ page
												+ "&pageSize="
												+ pageSize
												+ "&keyword=${keyword}&feeStatus=${feeStatus}";
									}
								});

				//为每页多少条的下拉框绑定一个change事件
				$("#pageSize")
						.change(
								function() {
									window.location.href = "${ctx}/propertyFee.gzsxt?cmd=properity_list&currentPage=1&pageSize="
											+ this.value
											+ "&keyword=${keyword}&feeStatus=${feeStatus}";
								});

				//监听搜搜框的键盘按下事件:如果用户按的是回车键,就触发向后台发送请求的操作
				$("#search").keyup(function(event) {
									//event是js事件编程种的一个内置对象,可以获取当前用户按下键盘任意键的所有信息
									//键盘的每一个数字都是对应的ASCII码,13是Enter 键盘
									if (event.keyCode == 13) {
										window.location.href = "${ctx}/propertyFee.gzsxt?cmd=properity_list&keyword="
												+ $(this).val()+"&feeStatus="+${feeStatus};
									}
								});

			});

			/**
			 *@param obj dom对象本身
			 *@param id 需要删除的用户id 
			 */
			function delPropertyFee(obj, id) {
				layer.confirm('亲,确定要删除此用户么,删除后不可恢复!!!', {
					icon : 3,
					title : '温馨提示'
				}, function(index) {

					//获取data-id自定义属性的值
					console.log(id);

					//使用ajax向后台发送删除操作的请求,并带上 删除的id
					$.get("${ctx}/propertyFee.gzsxt?cmd=delPropertyFee", {
						propertyFeeId : id
					}, function(data) {

						if (data.code == 1) {//删除成功

							//使用js删除当前行tr
							//思路:点击的是当前按钮,获取父元素 td,再获取td的父元素 tr,删除tr即可
							var tr = $(obj).parent().parent();
							tr.remove();

							//获取总数 -1 
							var totalCount = $("#totalCount").text();
							$("#totalCount").text(parseInt(totalCount) - 1);
							//如果删除以后恰好总条数能够整除当前页面/总页数应该减1
							if (parseInt(totalPage) % ${pageResult.pageSize}) {
								var totalPage = $("#totalPage").text();
								$("#totalPage").text(parseInt(totalPage) - 1);
							}
							//思考任务:考虑当前页数据删除完毕以后应该怎么处理
						} else {//删除失败
							layer.alert(data.msg, {
								skin : 'layui-layer-molv' //样式类名
							});
						}
						layer.close(index);//关闭当前窗口
					});
				});
			}
		</script>
</body>

</html>