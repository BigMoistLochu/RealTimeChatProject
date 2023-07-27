let cards = document.querySelectorAll('.card');
let container = document.querySelector('.tinder-container');
let isDragging = false;
let dragCard, startPosX, startPosY;

function initCards() {
    cards.forEach((card) => {
        card.addEventListener('mousedown', handleDragStart);
        card.addEventListener('touchstart', handleDragStart);
        card.addEventListener('mousemove', handleDrag);
        card.addEventListener('touchmove', handleDrag);
        card.addEventListener('mouseup', handleDragEnd);
        card.addEventListener('touchend', handleDragEnd);
    });
}

function handleDragStart(e) {
    e.preventDefault();
    isDragging = true;
    e.target.classList.add('dragging');
    dragCard = e.target;
    startPosX = getPositionX(e);
    startPosY = getPositionY(e);
}

function handleDrag(e) {
    if (!isDragging) return;
    e.preventDefault();
    const currentPosX = getPositionX(e);
    const currentPosY = getPositionY(e);
    const deltaX = currentPosX - startPosX;
    const deltaY = currentPosY - startPosY;

    dragCard.style.transform = `translate(${deltaX}px, ${deltaY}px)`;
}

function handleDragEnd() {
    if (!isDragging) return;
    isDragging = false;
    dragCard.classList.remove('dragging');
    dragCard.style.transform = '';

    const deltaX = getPositionX(event) - startPosX;
    const threshold = 100;

    if (deltaX > threshold) {
        container.classList.add('swipe-right');
        setTimeout(() => {
            dragCard.remove();
            container.classList.remove('swipe-right');
        }, 300);
    } else if (deltaX < -threshold) {
        container.classList.add('swipe-left');
        setTimeout(() => {
            dragCard.remove();
            container.classList.remove('swipe-left');
        }, 300);
    }
}

function getPositionX(e) {
    return e.type.includes('mouse') ? e.clientX : e.touches[0].clientX;
}

function getPositionY(e) {
    return e.type.includes('mouse') ? e.clientY : e.touches[0].clientY;
}

initCards();
