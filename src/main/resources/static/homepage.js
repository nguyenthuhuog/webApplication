const categories = [
    { id: 1, name: 'Electronics', link: 'electronics.html' },
    { id: 2, name: 'Clothing', link: 'clothing.html' },
    { id: 3, name: 'Home & Kitchen', link: 'home-kitchen.html' },
    { id: 4, name: 'Contact', link: 'contact.html' },
    { id: 5, name: 'Toys & Games', link: 'toys-games.html' }
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
