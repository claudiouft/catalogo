<header id="top-section" class="fullbg">
<div class="jumbotron">
	<div id="carousel_intro" class="carousel slide fadeing">
		<ol class="carousel-indicators">
			<c:forEach items="${pessoasd}" var="painel" varStatus="status">
				<li data-target="#carousel_intro" data-slide-to="${status.index}"></li>
			</c:forEach>
		</ol>
		<div class="carousel-inner">
		
		<c:forEach items="${pessoasd}" var="painel" varStatus="status">			 		
	 		 <c:if test="${status.index == 1}">
		      	<div class="active item"  id="slide_1">
					
					
					<!-- 
					<div class="active item" >
					<div class="carousel-content">					
						<div class="animated fadeInDownBig">
							 <h1>Julia Palhares.</h1>
						</div>						
						<br/>
						<a href="#" class="buttonyellow animated fadeInLeftBig"><i class="fa fa-shopping-cart"></i>&nbsp; Get Theme</a>
						<a href="#" class="buttoncolor animated fadeInRightBig"><i class="fa fa-link"></i>&nbsp; Start Tour</a>
					
					</div>
					 -->
				</div>
		     </c:if>				     			     						 
		</c:forEach>
		
		
		
		<!-- 
		<div class="active item" id="slide_1">
				<div class="carousel-content">					
					<div class="animated fadeInDownBig">
						 <h1>Julia Palhares.</h1>
					</div>
					<br/>
					<a href="#" class="buttonyellow animated fadeInLeftBig"><i class="fa fa-shopping-cart"></i>&nbsp; Get Theme</a>
					<a href="#" class="buttoncolor animated fadeInRightBig"><i class="fa fa-link"></i>&nbsp; Start Tour</a>
					
				</div>
			</div>
			<div class="item" id="slide_2">
				<div class="carousel-content">					
					<div class="animated fadeInDownBig">
						 <h1>Marisa Ortiz.</h1>
					</div>
					<br/>
					<a href="#" class="buttoncolor animated fadeInRightBig"><i class="fa fa-link"></i>&nbsp; Learn More</a>
					
				</div>
			</div>
			<div class="item" id="slide_3">
				<div class="carousel-content">					
					<div class="animated fadeInDownBig">
						 <h1>Nina Mercedez.</h1>					
					</div>
						<br/>
						<a href="#" class="buttonyellow animated fadeInLeftBig"><i class="fa fa-download"></i>&nbsp; Download Now</a>
				</div>
			</div>
		
		 -->
		</div>
	</div>
	<button class="left carousel-control" href="#carousel_intro" data-slide="prev" data-start="opacity: 0.6; left: 0%;" data-250="opacity:0; left: 5%;"><i class="fa fa-chevron-left"></i></button>
	<button class="right carousel-control" href="#carousel_intro" data-slide="next" data-start="opacity: 0.6; right: 0%;" data-250="opacity:0; right: 5%;"><i class="fa fa-chevron-right"></i></button>
</div>
<div class="inner-top-bg"></div>
</header>