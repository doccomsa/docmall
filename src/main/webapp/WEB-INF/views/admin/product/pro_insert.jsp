<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Starter</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <%@include file="/WEB-INF/views/admin/include/plugin1.jsp" %>
  
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <%@ include file="/WEB-INF/views/admin/include/header.jsp" %>
  <!-- Left side column. contains the logo and sidebar -->
  <%@ include file="/WEB-INF/views/admin/include/nav.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Page Header
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content container-fluid">

      <div class="row">
    		<div class="col-md-12">
    			<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title mt-5">Product</h3>
					</div>
					<!-- 절대경로 /board/register -->
					<form role="form" method="post" action="상품등록매핑uri">
						<div class="box-body">
						<div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">카테고리</label>
			              <div class="col-sm-3">
			                <select class="form-control" id="exampleFormControlSelect1">
			                  <option>1차카테고리 선택</option>
			                </select>
			              </div>
			              <div class="col-sm-3">
			                <select class="form-control" id="cg_code" name="cg_code">
			                  <option>2차카테고리 선택</option>
			                </select>
			              </div>
						</div>
						<div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">상품명</label>
			              <div class="col-sm-4">
			                <input type="text" class="form-control" name="pro_name" id="pro_name" placeholder="상품명 입력...">
			              </div>
			              <label for="title" class="col-sm-2 col-form-label">상품가격</label>
			              <div class="col-sm-4">
			                <input type="text" class="form-control" name="pro_price" id="pro_price" placeholder="상품가격 입력...">
			              </div>
						</div>
						<div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">할인율</label>
			              <div class="col-sm-4">
			                <input type="text" class="form-control" name="pro_discount" id="pro_discount" placeholder="할인율 입력...">
			              </div>
			              <label for="title" class="col-sm-2 col-form-label">제조사</label>
			              <div class="col-sm-4">
			                <input type="text" class="form-control" name="pro_publisher" id="pro_publisher" placeholder="제조사 입력...">
			              </div>
						</div>
						<div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">상품이미지</label>
			              <div class="col-sm-4">
			                <input type="file" class="form-control" name="" id="" placeholder="작성자 입력...">
			              </div>
			              <label for="title" class="col-sm-2 col-form-label">미리보기 이미지</label>
			              <div class="col-sm-4">
			               	<img id="" style="width:200px;height:200px;">
			              </div>
						</div>
						<div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">상품설명</label>
			              <div class="col-sm-10">
			                <textarea class="form-control" name="pro_content" id="pro_content" rows="3"></textarea>
			              </div>
			            </div>
			            <div class="form-group row">
						  <label for="title" class="col-sm-2 col-form-label">수량</label>
			              <div class="col-sm-4">
			                <input type="file" class="form-control" name="pro_amount" id="pro_amount" placeholder="수량 입력...">
			              </div>
			              <label for="title" class="col-sm-2 col-form-label">판매여부</label>
			              <div class="col-sm-4">
			               	<select class="form-control" id="pro_buy" name="pro_buy">
			                  <option>판매가능</option>
			                  <option>판매불가능</option>
			                </select>
			              </div>
						</div>
					
						
					  </div>
					  <div class="box-footer">
							<div class="form-group">
								<ul class="uploadedList"></ul>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">상품등록</button>
								<button type="reset" class="btn btn-primary">취소</button>
							</div>
					 </div>
					</form>
				</div>
    		</div>
    	</div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <%@include file="/WEB-INF/views/admin/include/footer.jsp" %>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane active" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:;">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->
      <!-- Stats tab content -->
      <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
      <!-- /.tab-pane -->
      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->
<%@include file="/WEB-INF/views/admin/include/plugin2.jsp" %>
<script src="/bower_components/ckeditor/ckeditor.js"></script>
<script>
  $(document).ready(function() {

    // ckeditor 환경설정. 자바스크립트 Ojbect문법
    var ckeditor_config = {
			resize_enabled : false,
			enterMode : CKEDITOR.ENTER_BR,
			shiftEnterMode : CKEDITOR.ENTER_P,
			toolbarCanCollapse : true,
			removePlugins : "elementspath", 
			//업로드 탭기능추가 속성. CKEditor에서 파일업로드해서 서버로 전송클릭하면 , 이 주소가 동작된다.
			filebrowserUploadUrl: '/admin/product/imageUpload' 
    }

    CKEDITOR.replace("pro_content", ckeditor_config);

    console.log("ckediotr 버전: ", CKEDITOR.version);
  });
</script>
</body>
</html>