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

// ------------- Delete ------------
function showConfirmationDialog() {
    $('#confirmationDialog').modal('show');
}

function deleteItem() {
    // Submit the form when user confirms deletion
    $('#deleteForm').submit();
    // Close the modal
    $('#confirmationDialog').modal('hide');
}

// Follow/following
const followersCollapse = document.getElementById('followersCollapse');
const followingCollapse = document.getElementById('followingCollapse');

followersCollapse.addEventListener('show.bs.collapse', function () {
    // Hide following section if it's open
    if (followingCollapse.classList.contains('show')) {
        followingCollapse.classList.remove('show');
    }
});

followingCollapse.addEventListener('show.bs.collapse', function () {
    // Hide followers section if it's open
    if (followersCollapse.classList.contains('show')) {
        followersCollapse.classList.remove('show');
    }
});

// something
const collapseButtons = document.querySelectorAll('.btn-collapse');

collapseButtons.forEach(button => {
    button.addEventListener('click', function() {
        // Remove 'active' class from all buttons
        collapseButtons.forEach(btn => {
            btn.classList.remove('active');
        });

        // Add 'active' class to the clicked button
        button.classList.add('active');
    });
});