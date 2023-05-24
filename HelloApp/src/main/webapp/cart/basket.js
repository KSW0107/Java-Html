export let basket = {
	totalCount: 0,
	totalPrice: 0,
	delCheckedItem: function() {
		console.log($('input[type="checkbox"]:checked'))
		$('input[type="checkbox"]:checked').parent().parent().parent().remove();
	},
	delAllItem: function() {
		console.log($('.row.data'))
		$('.row.data').remove();
		$('#sum_p_num').text('상품갯수: 0개')
		$('#sum_p_price').text('합계급액: 0원')
	},
	reCalc: function() {
		console.log('reCalc');
		this.totalCount = 0;
		this.totalPrice = 0;
	},
	updateUI: function() {
		console.log('updateUI');
		document.querySelector('#sum_p_num').textContent = '상품개수: ' + this.totalCount.formatNumber() + '개'
		document.querySelector('#sum_p_price').textContent = '합계금액: ' + this.totalPrice.formatNumber() + '원'
	},
	changePNumUp: function(pos, idx) {
		$(pos).parent().prev().val(Number($(pos).parent().prev().val()) + 1);
		let count = $(pos).parent().prev().val();
		let onePrice = $($(pos).parentsUntil('.row.data')[3].children[0].children[0]).val();
		onePrice = onePrice.replace(',', '')
		onePrice = onePrice.replace('원', '')
		$(pos).parent().parent().parent().next().text((onePrice * count).formatNumber() + "원");
		console.log(idx)
		$('#p_num' + idx).val
	},
	changePNumDown: function(pos, idx) {
		if ($(pos).parent().prev().prev().val() > 0) {
			$(pos).parent().prev().prev().val(Number($(pos).parent().prev().prev().val()) - 1);
			let count = $(pos).parent().prev().prev().val();
			let onePrice = $($(pos).parentsUntil('.row.data')[3].children[0].children[0]).val();
			onePrice = onePrice.replace(',', '')
			onePrice = onePrice.replace('원', '')
			$(pos).parent().parent().parent().next().text((onePrice * count).formatNumber() + "원");
		}
	},
	changePNumInput: function(pos, idx) {
		if ($(pos).val() <= 0) {
			alert('불가')
			$(pos).val(1)
		} else {
			let count = $(pos).val();
			let onePrice = $(pos).parent().parent().prev().children().first().val()
			$(pos).parent().parent().next().text((onePrice * count).formatNumber() + "원")
		}

	},
	delItem: function(e) {
		console.log($(e.target).parent().parent().parent());
		$(e.target).parent().parent().parent().remove();
	},
	cartList: function() {
		cartItems.forEach((item, idx) => {
			let template = document.querySelector('#template>div.row.data').cloneNode(true);
			template.querySelector('.img>img').setAttribute('src', '../img/' + item.image)
			template.querySelector('.pname>span').textContent = item.productNm
			template.querySelector('.basketprice>input').value = item.price
			template.querySelector('.basketprice').childNodes[2].textContent = item.price.formatNumber() + "원"
			template.querySelector('.updown>input').value = item.qty
			template.querySelector('.updown>input').setAttribute('value', item.qty)
			template.querySelector('.updown>input').setAttribute('id', 'p_num' + (idx + 1));
			template.querySelector('.sum').textContent = (item.price * item.qty).formatNumber() + "원"

			document.querySelector('#basket').append(template)
		})
	},
	totalCheck: function() {
		//장바구니 상품 수량
		let totalCount = 0;
		$('.p_num').each(function(index, item) {
			totalCount += Number($(item).val());
		})
		$('#sum_p_num').text('상품갯수: ' + totalCount)

		let allSum = 0;
		$('.sum').each(function(index, item) {
			let price = $(item).text().replace(',', '')
			price = price.replace('원', '')
			allSum += Number(price);
		})
		$('#sum_p_price').text('합계금액: ' + allSum.formatNumber() + "원")

	}
}

var cartItems = [{
	no: 1,
	productNm: '이것이 민트다.',
	qty: 2,
	price: 12000,
	image: 'item1.PNG'
},
{
	no: 2,
	productNm: '와 아이스크림.',
	qty: 1,
	price: 22000,
	image: 'item2.PNG'
},
{
	no: 3,
	productNm: '모나카 케익.',
	qty: 1,
	price: 13600,
	image: 'item3.PNG'
}
]

// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function() {
	if (this == 0) return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	return nstr;
};

