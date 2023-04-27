<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>

	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="small mb-1" id="proId"></div>
					<h1 class="display-5 fw-bolder" id="proName"></h1>
					<div class="fs-5 mb-5">
						<span class="text-decoration-line-through" id="proPrice"></span> <span
							id="proSale"></span>
					</div>
					<p class="lead" id='proText'></p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity"
							type="num" value="1" style="max-width: 3rem" />
						<button class="btn btn-outline-dark flex-shrink-0" type="button">
							<i class="bi-cart-fill me-1"></i> Add to cart
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="fw-bolder mb-4">Related products(추천순위)</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder" id="proName1"></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through"
									id='proPrice1'></span> <span id="proSale1"></span>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder" id="proName2"></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through"
									id='proPrice2'></span> <span id="proSale2"></span>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder" id="proName3"></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through"
									id='proPrice3'></span> <span id="proSale3"></span>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder" id="proName4"></h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through"
									id='proPrice4'></span> <span id="proSale4"></span>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script>
        let urlParams = new URL(location.href).searchParams;

        let proId1 = urlParams.get('proId');
        console.log(proId1)



        fetch('getProduct.do?proId=' + proId1)
            .then(resolve => resolve.json())
            .then(result => {
                pro = result
                console.log(pro[0])

                let image = document.getElementsByClassName('card-img-top')
                image[0].src = pro[0].proImage

                let name = document.createTextNode(pro[0].proName)
                let proName = document.querySelector('#proName')
                proName.appendChild(name);

                let price = document.createTextNode(pro[0].proPrice + '원')
                let proPrice = document.querySelector('#proPrice')
                proPrice.appendChild(price);

                let Sale = document.createTextNode(pro[0].proSale + '원')
                let proSale = document.querySelector('#proSale')
                proSale.appendChild(Sale);


                let Text = document.createTextNode(pro[0].proText)
                let proText = document.querySelector('#proText')
                proText.appendChild(Text);

                let Id = document.createTextNode('상품ID: ' + pro[0].proId)
                let proId = document.querySelector('#proId')
                proId.appendChild(Id);

            })

        fetch('getWithPoint.do')
            .then(resolve => resolve.json())
            .then(result => {
                allPro = result

                console.log(allPro);

                for (let i = 0; i < 4; i++) {
                    let name = document.createTextNode(allPro[i].proName)
                    let proName = document.querySelector('#proName' + (i + 1))
                    proName.appendChild(name);

                    let price = document.createTextNode(allPro[i].proPrice)
                    let proPrice = document.querySelector('#proPrice' + (i + 1))
                    proPrice.appendChild(price);

                    let sale = document.createTextNode(allPro[i].proSale)
                    let proSale = document.querySelector('#proSale' + (i + 1))
                    proSale.appendChild(sale);

                    let image = document.getElementsByClassName('card-img-top')
                    console.log(allPro[i].proImage)
                    image[i + 1].src = allPro[i].proImage

                    let point = allPro[i].proPoint
                    let proPoint = document.getElementsByClassName('d-flex justify-content-center small text-warning mb-2')
                    for (let j=point; j<5 ; j++){
                        proPoint[i].firstElementChild.remove();
                    }




                    // let pro = document.getElementsByClassName("col mb-5")
                    // pro[i].addEventListener('click', function (e) {
                    //     location.href = 'ProductForm.do?proId='+allPro[i].proId
                    // })
                }
            })
    </script>

</body>
