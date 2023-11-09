// <script>태그는 제외한다.
$(document).ready(function() {

	// 1차카테고리 오버
	$("div#category_menu li a").on("mouseover", function(e) {
		e.preventDefault(); // a태그의 링크기능을 제거
		// console.log("1차카테고리 오버");
		let sel_first_category = $(this);
		let cg_code = $(this).data("cg_code");

		// console.log("1차카테고리코드: ", cg_code);

		// return;

		let url = '/category/secondCategory/' + cg_code;
		$.getJSON(url, function(category) {

			// console.log(category);
			let str = '<ul class="nav justify-content-center"  id="second_category">';
			for(let i=0; i<category.length; i++) {
				str += '<li class="nav-item">';
				str += '<a class="nav-link active" href="#" data-cg_code="' + category[i].cg_code  + '">' + category[i].cg_name + '</a>';
				str += '</li>';
			}

			str += '</ul>';

			// console.log(str);
			sel_first_category.parent().parent().next().remove();
			sel_first_category.parent().parent().after(str);

		});
		
	});

	//2차카테고리 선택.  
	//[중요] 동적으로 생성된 태그를 jquery에서 직접 선택자로 접근 불가능 함.
	/*
	$("정적태그 참조선택자").on("이벤트명", "동적태그 참조선택자", function() {

	});
	*/
	$("div#category_menu").on("click", "ul#second_category", function() {
		console.log("2차카테고리 작업");
	});
});

