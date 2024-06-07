const categories = [
    { id: 1, name: 'Computer & Laptop', link: 'electronics.html' },
    { id: 2, name: 'Keyboards', link: 'clothing.html' },
    { id: 3, name: 'Mouses', link: 'home-kitchen.html' }
];
const sidebar = document.getElementById('sidebar');
categories.forEach(category => {
    const button = document.createElement('button');
    button.className = 'category';
    button.textContent = category.name;
    button.onclick = () => {
        window.location.href = category.link;
    };
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
