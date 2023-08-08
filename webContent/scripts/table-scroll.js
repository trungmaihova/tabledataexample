
function hasVerticalScroll(element) {
	return element.scrollHeight > element.clientHeight;
}

function hasHorizontalScroll(element) {
	return element.scrollWidth > element.clientWidth;
}

function getTableHeader(tableStypeClass) {
	var tables = document.getElementsByClassName(tableStypeClass)
	if (tables.length > 0) {
		return tables[0].getElementsByClassName('ui-datatable-scrollable-header-box')[0];
	}
	return undefined
}

function getTableBody(tableStypeClass) {
	var tables = document.getElementsByClassName(tableStypeClass)
	if (tables.length > 0) {
		return tables[0].getElementsByClassName('ui-datatable-scrollable-body')[0];
	}
	return undefined
}

function getStyleMarginRight(element) {
	let value = element.style.marginRight
	if (value !== undefined && value === "0px") {
		return undefined
	}
	return value
}

function fixTableHeaderMarginRight(tableStypeClass) {
	var tableHeader = getTableHeader(tableStypeClass)
	var tableBody = getTableBody(tableStypeClass)
	
	console.log("Vertical scroll on table body", hasVerticalScroll(tableBody))
	console.log("Margin right on table header ", tableHeader.style.marginRight)	
	
	console.log("Table header client width", tableHeader.clientWidth)
	console.log("Table body client width", tableBody.clientWidth)
	
	console.log("Table body scroll height", tableBody.scrollHeight)
	console.log("Table body client height", tableBody.clientHeight)
	

	//When has vertical bar but header's width' greater than body's width' => Should margin right the header
	if (hasVerticalScroll(tableBody) && tableHeader.clientWidth > tableBody.clientWidth) {		
		let marginRight = (tableHeader.clientWidth - tableBody.clientWidth) + "px"
		console.log("Set table header margin right ", marginRight)
		tableHeader.style.marginRight = marginRight
		return
	}

	//When has not vertical bar but header's width' less than body's width' and have margin > 0 => Should margin right  = 0 for header
	if (!hasVerticalScroll(tableBody) && tableHeader.clientWidth < tableBody.clientWidth) {
		let marginRight = getStyleMarginRight(tableHeader)
		if (marginRight != undefined) {
			console.log("Set table header margin right 0px")
			tableHeader.style.marginRight = "0px"
		}
		return
	}
	
	//Another case here
}


window.onload = function findedPageLoading() {
	console.log("On finished loading page")
	fixTableHeaderMarginRight('table-scroll-handle')
}

window.addEventListener('resize', function() {
	console.log("On resize")
	fixTableHeaderMarginRight('table-scroll-handle')
}, true);

