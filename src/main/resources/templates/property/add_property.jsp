<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 基本表单</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="favicon.ico">
<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

<!-- 引入文件上传组件 webuploader 的样式 -->
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/plugins/webuploader/webuploader.css">

<!-- 全局js -->
<script src="${ctx}/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${ctx}/js/content.js?v=1.0.0"></script>

<!-- iCheck -->
<script src="${ctx}/js/plugins/iCheck/icheck.min.js"></script>

<!-- 引入日历插件js文件 -->
<script src="${ctx}/js/plugins/layer/laydate/laydate.js"></script>

<!-- 引入弹框插件 layer  -->
<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

<!-- 引入 文件上传组件 webuploader 的js -->
<script src="${ctx}/js/plugins/webuploader/webuploader.js"></script>

<!-- 引入 Jquery.validate.js 表单验证框架 -->
<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/messages_zh.min.js"></script>


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
														layer.alert(data.msg,
																		{
																			skin : 'layui-layer-molv' //样式类名
																		},
																		function(index) {
																			layer.close(index);
																			window.location.href = "${ctx}/propertyFee.gzsxt?cmd=addProperity";
																		});
													} else {layer.alert(data.msg,
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
		console.log(obj.value)
		$.get("${ctx}/propertyFee.gzsxt", {
			cmd : "getBuild",
			communityId : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, build) {
				options += "<option value='"+build.id+"'>" + build.name
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
			buildId : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, floor) {
				options += "<option value='"+floor.id+"'>" + floor.name
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
			floorId : obj.value
		}, function(data) {
			//console.log(data);
			//拼接<option>标签
			var options = "<option value='-1'>请选择</option>";
			$.each(data, function(index, room) {
				//console.log(room.id)
				options += "<option data-id='"+room.id+"' value='"+room.id+"'>"
						+ room.name + "<option>";
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
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>生成物业费</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a> <a class="dropdown-toggle" data-toggle="dropdown"
								href="form_basic.html#"> <i class="fa fa-wrench"></i>
							</a>
							<ul class="dropdown-menu dropdown-user">
								<li><a href="form_basic.html#">选项1</a></li>
								<li><a href="form_basic.html#">选项2</a></li>
							</ul>
							<a class="close-link"> <i class="fa fa-times"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<form class="form-horizontal" action="" method="post" id="regForm">
							<div class="form-group draggable ui-draggable">
								<label class="col-sm-3 control-label">小区：</label>
								<div class="col-sm-7">
									<select id="community" onchange="getBuildId(this)"
										class="form-control">
										<option value="-1">请选择</option>
									</select>&nbsp; <input type="hidden" id="community1" name="community"
										class="form-control">
								</div>
							</div>
							<div class="form-group draggable ui-draggable">
								<label class="col-sm-3 control-label">楼宇：</label>
								<div class="col-sm-7">
									<select id="build" onchange="getFloorId(this)"
										class="form-control">
										<option value="-1">请选择</option>
									</select>&nbsp; <input type="hidden" id="build1" name="build"
										class="form-control">
								</div>
							</div>
							<div class="form-group draggable ui-draggable">
								<label class="col-sm-3 control-label">楼层：</label>
								<div class="col-sm-7">
									<select id="floor" onchange="getRoomId(this)"
										class="form-control">
										<option value="-1">请选择</option>
									</select>&nbsp; <input type="hidden" id="floor1" name="floor"
										class="form-control">
								</div>
							</div>
							<div class="form-group draggable ui-draggable">
								<label class="col-sm-3 control-label">房间：</label>
								<div class="col-sm-7">
									<select id="room" onchange="getRoomName(this)"
										class="form-control">
										<option value="-1">请选择</option>
									</select>&nbsp; <input type="hidden" id="room1" name="room"
										class="form-control">
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
									<input id="price" type="text" name="price" class="form-control"
										placeholder="请输入单位价格"> <span
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

											<button id="ctlBtn1" type="button" class="btn btn-default">开始上传</button>
										</div>
									</div>

									<!-- 收据照片隐藏域表单,value是图片上传成功以后的 地址 -->
									<input type="hidden" id="receipt" name="receipt" />
								</div>
							</div>
							 <input type="hidden" id="feeStatus" name="feeStatus"
								value="1" class="form-control"> 
							<input type="hidden" id="roomID" name="room_id" value="" class="form-control">

							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8">
									<button class="btn btn-sm btn-primary" type="submit">生产物业费</button>
									<button class="btn btn-sm " type="reset">重置</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			//收据照片
			jQuery(function() {
				var $ = jQuery, $list = $('#thelist1'), // thelist节点中添加文本  身份证正面  div添加  
				$btn = $('#ctlBtn1'), // 文件上传按钮   身份证正面 文件上传按钮
				state = 'pending', uploader;

				//初始化
				uploader = WebUploader.create({
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
				uploader.on('fileQueued', function(file) {
					$list.append('<div id="' + file.id + '" class="item">'
							+ '<h4 class="info">' + file.name + '</h4>'
							+ '<p class="state">等待上传...</p>' + '</div>');
				});

				// 文件上传过程中创建进度条实时显示。
				uploader
						.on(
								'uploadProgress',
								function(file, percentage) {
									var $li = $('#' + file.id), $percent = $li
											.find('.progress .progress-bar');

									// 避免重复创建
									if (!$percent.length) {
										$percent = $(
												'<div class="progress progress-striped active">'
														+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
														+ '</div>' + '</div>')
												.appendTo($li).find(
														'.progress-bar');
									}

									$li.find('p.state').text('上传中');

									$percent.css('width', percentage * 100
											+ '%');
								});

				//文件上传成功后  触发的事件  触发一个回调函数
				uploader
						.on(
								'uploadSuccess',
								function(file, response) {
									console.log("---" + response.code
											+ "-------reData:" + response.msg
											+ "---");

									// 上传的图片保存的相对位置
									var idcard_url = response.msg;
									console.log(idcard_url)
									$("#idcard_id1")
											.append(
													"<br><img  src='images/"+idcard_url
																+"' style='width: 150px;height: 150px' />");

									//将url 添加到  form表单的隐藏域中
									$("#receipt").val(idcard_url);

									$('#' + file.id).find('p.state')
											.text('已上传');
								});

				uploader.on('uploadError', function(file) {
					//TODO
					$('#' + file.id).find('p.state').text('上传出错');
				});

				uploader.on('uploadComplete', function(file) {
					$('#' + file.id).find('.progress').fadeOut();
				});

				uploader.on('all', function(type) {
					if (type === 'startUpload') {
						state = 'uploading';
					} else if (type === 'stopUpload') {
						state = 'paused';
					} else if (type === 'uploadFinished') {
						state = 'done';
					}

					if (state === 'uploading') {
						$btn.text('暂停上传');
					} else {
						$btn.text('开始上传');
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
		</script>

	</div>


</body>

</html>
