var x = document.getElementById('anchor-x');
var y = document.getElementById('anchor-y');
var outputx = document.getElementById('output-x');
var outputy = document.getElementById('output-y');
var mover = document.querySelector('.mover');

x.addEventListener('input', function (e) {
    let x = `${e.currentTarget.value}%`;
    mover.style.setProperty('--anchorX', x);
    outputx.textContent = x;
});
y.addEventListener('input', function (e) {
    let y = `${e.currentTarget.value}%`;
    mover.style.setProperty('--anchorY', y);
    outputy.textContent = y;
});