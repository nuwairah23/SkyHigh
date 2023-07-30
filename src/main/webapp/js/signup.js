/**
 * 
 */
 
 const open = document.getElementById('open');
 const close = document.getElementById('close');
 const modal_container = document.getElementById('modal_container');
 
 open.addEventListener('click', function () {
	modal_container.classList.add('show');
	console.log("added");
});
 
 close.addEventListener('click', function () {
	modal_container.classList.remove('show');
	console.log("removed");
});
 