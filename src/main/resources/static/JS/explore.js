document.addEventListener('DOMContentLoaded', function() {
    // Event listener for search
    const searchInput = document.getElementById("searchInput");
    const searchResults = document.getElementById("searchResults");

    searchInput.addEventListener("input", function() {
        const query = this.value;
        if (!query.length) {
            searchResults.innerHTML = '';
            return;
        }
        fetch(`/searchUsers?query=${query}`)
            .then(response => response.json())
            .then(data => {
                let html = '';
                data.forEach(user => {
                    html += `
                    <div class="pt-3 d-flex justify-content-start">
                        <button id="btn-message" class="button-message">
                            <div class="content-avatar">
                                <div class="status-user"></div>
                                <div class="avatar">
                                    <img class="user-img" src="${user.currentBadge}">
                                </div>
                            </div>
                            <div class="notice-content">
                                <a href="/profile/${user.id}" class="search-item d-flex username a-text">
                                    <div class="user-id">
                                        ${user.username}
                                    </div>
                                </a>
                                <div class="lable-message">${user.username}</div>
                            </div>
                        </button>
                    </div>
                    `;
                });
                searchResults.innerHTML = html;
            });
    });

    // Event listener for the comments toggle button
    document.addEventListener('click', function(e) {
        const target = e.target;

        if (target && target.hasAttribute('data-comments-toggle')) {
            const commentsSection = target.closest('.card-body').querySelector('.comments-section');
            const counterSpan = target.querySelector('span');

            if (commentsSection.style.display === 'none') {
                commentsSection.style.display = 'block';
                target.innerHTML = `Hide Comments (<span>${counterSpan.textContent}</span>)`;
            } else {
                commentsSection.style.display = 'none';
                target.innerHTML = `Show Comments (<span>${counterSpan.textContent}</span>)`;
            }
        }

        if (target && target.textContent.startsWith('Post Comment')) {
            const commentInput = target.previousElementSibling;
            const commentText = commentInput.value.trim();

            if (commentText) {
                const newComment = document.createElement('div');
                newComment.className = 'comment';
                newComment.innerHTML = `<strong>YourUsername:</strong> ${commentText}`;
                target.closest('.comments-section').insertBefore(newComment, target.closest('.add-comment'));
                commentInput.value = '';

                const counterSpan = target.closest('.card-body').querySelector('[data-comments-toggle] span');
                let currentCount = parseInt(counterSpan.textContent, 10);
                counterSpan.textContent = currentCount + 1;
            } else {
                alert('Please enter a comment.');
            }
        }
    });
});
