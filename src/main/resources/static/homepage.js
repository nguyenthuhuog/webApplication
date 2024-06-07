document.addEventListener('DOMContentLoaded', () => {
    const categories = [
        { id: 1, name: 'Computer & Laptop', link: 'electronics.html' },
        { id: 2, name: 'Keyboards', link: 'clothing.html' },
        { id: 3, name: 'Mouses', link: 'home-kitchen.html' }
    ];

    const sidebar = document.getElementById('sidebar');
    const hamburger = document.getElementById('hamburger');

    categories.forEach(category => {
        const button = document.createElement('button');
        button.className = 'category';
        button.textContent = category.name;
        button.onclick = () => {
            window.location.href = category.link;
        };
        sidebar.appendChild(button);
    });
    
    // Inject CSS for font size
    const style = document.createElement('style');
    style.innerHTML = `
        .category {
            font-size: 10px;
        }
    `;
    document.head.appendChild(style);

    // Hamburger button logic to toggle sidebar visibility
    hamburger.addEventListener('click', () => {
        if (sidebar.style.display === 'none' || sidebar.style.display === '') {
            sidebar.style.display = 'block';
        } else {
            sidebar.style.display = 'none';
        }
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
});
