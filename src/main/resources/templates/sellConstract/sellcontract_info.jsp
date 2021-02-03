<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base  href="/SxtPms/">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>H+ 后台主题UI框架 - 基本表单</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
  <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script src="js/plugins/layer2.4/layer.js"></script>
 <!-- 引入文件上传组件 webuploader 的样式 -->
    <link rel="stylesheet" type="text/css" href="js/plugins/webuploader/webuploader.css">
    
<!-- 引入 文件上传组件 webuploader 的js -->
    <script src="js/plugins/webuploader/webuploader.js"></script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							房产销售合同信息</small>
						</h5>
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
						<div class="row">
							<form role="form" class="form-horizontal" action="sellContract/add">
								<p>----------------------合同信息----------------------</p>
								<div class="col-sm-6 b-r">
									<div class="form-group">
										<label class="col-sm-3 control-label">业主姓名：</label>
										<div class="col-sm-7">
										        <input class="form-control"  value="${contract.proprietorName}"   name="properietor_name" type="text"> 
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">业主性别：</label>
										<div class="col-sm-9">
										    <label class="radio-inline">
										        <input    name="sex" value="1" ${contract.gender} type="radio">男</label>
										    <label class="radio-inline">
										        <input   name="sex"  value="0" type="radio">女</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">联系手机：</label>
										<div class="col-sm-7">
											<input type="text"  name="phone"  
												class="form-control"  value="${contract.phone}" placeholder="">
												<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">业主地址：</label>
										<div class="col-sm-7">
											<input type="text" value="${contract.address}"  name="address" placeholder=""
												class="form-control" placeholder="">
												<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">身份证号：</label>
										<div class="col-sm-7">
											<input type="text"  value="${contract.IDNum}" name="identitycard_num"  
												class="form-control"  >
												<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
								</div>
								<!-- 
								分页
								 -->
								<div class="col-sm-6">
									<div class="form-group">
										<label class="col-sm-3 control-label">房产信息：</label>
										<div class="col-sm-7">
											<input type="text" value="${contract.residence_info}"  name="residence_info"  
												  class="form-control">
											<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">房间编号：</label>
										<div class="col-sm-7">
										        <input class="form-control"  value="${contract.room_id}" id="room_id" name="room_id" type="text">
										</div>
									 </div>
									<div class="form-group">
										<label class="col-sm-3 control-label">合同金额：</label>
										<div class="col-sm-7">
											<input type="text" value="${contract.contract_value}"  name="contract_value" 
												class="form-control">
												<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">付款方式：</label>
										<div class="col-sm-7">
											<input type="text" value="${contract.payment_method}"  name="payment_method" 
												class="form-control" placeholder="">
												<span	class="help-block m-b-none" id=""></span>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">合同日期：</label>
										<div class="col-sm-7">
											<input type="text" value="${contract.signtime}"  name="signtime"  
												class="form-control"  >
												<span	class="help-block m-b-none"  ></span>
										</div>
									</div>
								</div>
								<br>
							<!-- 
							分页
							 -->
								<div class="form-group">
                          		<!-- div id; inp ty -------->
	      					  		<label class="col-sm-2 control-label">身份证正面</label>
	      					 		<div class="col-sm-10">
										<div id="uploader" class="wu-example">
										    <!--用来存放文件信息-->
										    <div id="thelist1" class="uploader-list"></div>
										    <div class="btns" id="idcard_id1">
										        <div id="picker1">选择文件</div>
										        <!-- button如果不指定   type 为button 默认是submit -->
										        <button id="ctlBtn1" type="button" class="btn btn-default">开始上传</button>
										    </div>
										</div>
									   <!-- 身份证正面隐藏域表单,value是图片上传成功以后的 地址 -->
										<input type="hidden" id="identitypositive"  name="identitypositive" />
									</div>
   							 </div>
							 <div class="form-group">
                                <div class="col-sm-offset-5">
                                    <button class="btn btn-primary" type="submit">保存内容</button>
                                    <button class="btn btn-white" type="submit">取消</button>
                                </div>
                            </div>	
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>
<script type="text/javascript">
	jQuery(function() {
	    var $ = jQuery,
	        $list = $('#thelist1'), // thelist节点中添加文本  身份证正面  div添加  
	        $btn = $('#ctlBtn1'), // 文件上传按钮   身份证正面 文件上传按钮
	        state = 'pending',
	        uploader;
	    //初始化
	    uploader = WebUploader.create({
	        // 不压缩image
	        resize: false,
	        // 文件接收服务端。
	        server: "tenant/fileUpload",
	        // 选择文件的按钮。可选。
	        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	        	//开始上传 按钮的id 
	        pick: '#picker1' ,
	     // 只允许选择图片文件。
	        accept: {
	            title: 'Images',
	            extensions: 'jpg,jpeg,bmp,png',
	            mimeTypes: 'image/*'
	        },
	        //允许上传的文件个数
	        fileNumLimit:1,
	        //单个文件最大的上传限制 1M
	        fileSingleSizeLimit : 1024 * 1024 // 1M
	    });

	    // 当有文件添加进来的时候
	    uploader.on( 'fileQueued', function( file ) {
	        $list.append( '<div id="' + file.id + '" class="item">' +
	            '<h4 class="info">' + file.name + '</h4>' +
	            '<p class="state">等待上传...</p>' +
	        '</div>' );
	    });

	    // 文件上传过程中创建进度条实时显示。
	    uploader.on( 'uploadProgress', function( file, percentage ) {
	        var $li = $( '#'+file.id ),
	            $percent = $li.find('.progress .progress-bar');

	        // 避免重复创建
	        if ( !$percent.length ) {
	            $percent = $('<div class="progress progress-striped active">' +
	              '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	              '</div>' +
	            '</div>').appendTo( $li ).find('.progress-bar');
	        }

	        $li.find('p.state').text('上传中');

	        $percent.css( 'width', percentage * 100 + '%' );
	    });

	    //文件上传成功后  触发的事件  触发一个回调函数
	    uploader.on( 'uploadSuccess', function( file,response) {
	    	console.log("---"+response.code+"-------reData:"+response.msg+ "---" );
	      
	    	// 上传的图片保存的相对位置
	    	var idcard_url = response.msg;
	    	 $("#idcard_id1").append("<br><img  src='${ctx}"+idcard_url+"' style='width: 150px;height: 150px' />");
	    	 
	    	 //将url 添加到  form表单的隐藏域中
	    	 $("#identitypositive").val(idcard_url);
	    	 
	    	$( '#'+file.id ).find('p.state').text('已上传');
	    });

	    uploader.on( 'uploadError', function( file ) {
	    	//TODO
	        $( '#'+file.id ).find('p.state').text('上传出错');
	    });

	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').fadeOut();
	    });

	    uploader.on( 'all', function( type ) {
	        if ( type === 'startUpload' ) {
	            state = 'uploading';
	        } else if ( type === 'stopUpload' ) {
	            state = 'paused';
	        } else if ( type === 'uploadFinished' ) {
	            state = 'done';
	        }

	        if ( state === 'uploading' ) {
	            $btn.text('暂停上传');
	        } else {
	            $btn.text('开始上传');
	        }
	    });
	    
	    //出错以后回调的函数
	    uploader.on("error",function(type){
	    	alert(type);
	    	if(type == "F_EXCEED_SIZE"){
	    		layer.alert('最大只能上传1M文件', {
	    			  skin: 'layui-layer-molv' //样式类名
	    		});
	    	}
	    });
	    $btn.on( 'click', function() {
	        if ( state === 'uploading' ) {
	            uploader.stop();
	        } else {
	            uploader.upload();
	        }
	    });
	});
    </script>
</body>

</html>
