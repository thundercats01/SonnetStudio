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
