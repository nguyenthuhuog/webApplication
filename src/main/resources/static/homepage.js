const categories = [
    { id: 1, name: 'Electronics' },
    { id: 2, name: 'Clothing' },
    { id: 3, name: 'Home & Kitchen' },
    { id: 4, name: 'Sports' },
    { id: 5, name: 'Toys & Games' }
];
const sidebar = document.getElementById('sidebar');
categories.forEach(category => {
    const button = document.createElement('button');
    button.className = 'category';
    button.textContent = category.name;
    sidebar.appendChild(button);
});
// Banner slideshow logic
let bannerIndex = 0;
const banners = document.querySelectorAll('.banner img');
setInterval(() => {
    banners[bannerIndex].classList.add('hidden');
    bannerIndex = (bannerIndex + 1) % banners.length;
    banners[bannerIndex].classList.remove('hidden');
}, 2000);

function openModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}