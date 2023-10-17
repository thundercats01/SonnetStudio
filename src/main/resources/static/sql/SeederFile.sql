-- Users
INSERT INTO users (username, email, password, bio, current_badge)
VALUES
    ('PoetryLover123', 'poetrylover@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Passionate about expressing through words.', '/capstone_IMGs/badges/badge-default.png'),
    ('CreativeSoul89', 'creative@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Exploring the depths of creativity.', '/capstone_IMGs/badges/badge-apple.jpeg'),
    ('InspiredWriter55', 'writer@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Seeking inspiration in every word.', '/capstone_IMGs/badges/badge-einstein.jpeg'),
    ('GracefulGazer', 'graceful@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Admiring the world through verse.', '/capstone_IMGs/badges/badge-joan.jpeg'),
    ('SereneScribe', 'serene@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Finding tranquility in writing.', '/capstone_IMGs/badges/badge-pearl.avif'),
    ('DreamWeaver123', 'dreamweaver@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Weaving dreams with words.', '/capstone_IMGs/badges/badge-joan.jpeg'),
    ('SoulfulSinger', 'soulful@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Singing through verses.', '/capstone_IMGs/badges/badge-pearl.avif'),
    ('MagicMonkey', 'magicmonkey@example.com', '$2a$10$kMgLEcRRVC8TOATD4rWIR.PQVEoRHsH9BiuSktwyRNTq2rrKVPzmi', 'Every seen the movie Jungle Book?', '/capstone_IMGs/badges/badge-developer.png');

-- Verses
INSERT INTO verses (user_id, Content, genre)
VALUES
    (4, 'In the quiet moments before dawn, the world holds its breath, awaiting the first light of day. It is in this hushed stillness that my thoughts find their voice, and my heart speaks its truth. The world awakens, and so do I, with pen in hand and soul laid bare.', 'Reflective'),
    (5, 'Beneath the ancient oak tree, where whispers of the past linger in the breeze, I find solace. Each rustling leaf, a page in nature''s book, tells a story of time gone by. Here, I pen my own tales, a tribute to the tales that came before.', 'Nostalgic'),
    (1, 'Beneath the starry night, I find my solace.', 'Romantic'),
    (2, 'In the hustle and bustle, silence speaks.', 'Reflective'),
    (3, 'A dance of colors in the morning sky.', 'Nature'),
    (4, 'Whispers of the wind carry secrets untold. In their gentle embrace, I find sanctuary, a place where my words can roam free.', 'Mysterious'),
    (5, 'Lost in a world of ink and paper, I dance upon the blank canvas, letting my thoughts flow like a river, winding and weaving through the pages.', 'Creative'),
    (6, 'Footprints in the sand, memories left behind. Each step a story, each grain of sand a witness to the journey.', 'Nostalgic'),
    (7, 'Eternal love, a flame that never fades. It burns bright in the darkest night, a beacon of hope for weary hearts.', 'Romantic'),
    (5, 'Echoes of laughter in the autumn breeze, a symphony of joy that resonates through the golden leaves. In this moment, I find pure bliss.', 'Joyful'),
    (3, 'Silent tears, stories only the heart knows. They speak of battles fought and victories won, of strength and resilience in the face of adversity.', 'Reflective'),
    (7, 'Underneath the city lights, dreams take flight. In the midst of chaos, I find my sanctuary, where imagination knows no bounds.', 'Inspiring');

-- Badges
INSERT INTO badges (name, description, path)
VALUES
    ('Default', 'Default badge', '/capstone_IMGs/badges/badge-default.png'),
    ('Apple', 'Apple badge', '/capstone_IMGs/badges/badge-apple.jpeg'),
    ('Einstein', 'Einstein badge', '/capstone_IMGs/badges/badge-einstein.jpeg'),
    ('Pearl', 'Pearl badge', '/capstone_IMGs/badges/badge-pearl.avif'),
    ('Joan', 'Joan badge', '/capstone_IMGs/badges/badge-joan.jpeg'),
    ('Developer', 'Developer badge', '/capstone_IMGs/badges/badge-developer.png');

-- Comments
INSERT INTO comments (Content, user_id, verse_id)
VALUES
    ('This is wonderful!', 1, 1),
    ('Amazing!', 2, 2),
    ('I resonate with this.', 3, 12),
    ('Well written!', 1, 2),
    ('I love the imagery.', 2, 3),
    ('Keep up the good work!', 3, 1),
    ('Incredible!', 1, 11),
    ('This speaks to my soul.', 2, 12),
    ('Beautifully expressed.', 3, 2),
    ('I can feel the emotion.', 1, 3),
    ('Your words paint a vivid picture.', 4, 4),
    ('I feel the nostalgia in every line.', 5, 5),
    ('This is pure artistry.', 6, 6),
    ('Your creativity knows no bounds.', 7, 7),
    ('A beautiful expression of eternal love.', 3, 8),
    ('I can almost hear the laughter in your words.', 4, 11),
    ('Your words touch the heart.', 1, 10),
    ('Incredible imagery!', 4, 5),
    ('You have a gift for storytelling.', 5, 6),
    ('This verse speaks volumes.', 6, 7),
    ('I''m inspired by your words.', 7, 8),
    ('A masterpiece of emotions.', 2, 9),
    ('This is poetry in its purest form.', 6, 10),
    ('Your verses light up the page.', 1, 1),
    ('I can feel the passion in your words.', 6, 4),
    ('Your verse carries a sense of mystery.', 3, 5),
    ('This is a journey through ink and paper.', 3, 6),
    ('A beautiful tribute to nature''s stories.', 4, 7),
    ('Your words are a balm for the soul.', 5, 8),
    ('A symphony of joy indeed!', 6, 9),
    ('Your verse is a source of inspiration.', 7, 10);

-- Likes
INSERT INTO likes (user_id, verse_id)
VALUES
    (1, 2),
    (2, 3),
    (3, 1),
    (1, 3),
    (2, 1),
    (3, 2),
    (1, 3),
    (2, 1),
    (3, 2),
    (1, 3),
    (4, 2),
    (5, 3),
    (6, 1),
    (2, 4),
    (3, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (7, 9),
    (3, 10),
    (7, 1),
    (6, 2),
    (4, 3),
    (5, 4),
    (6, 5),
    (4, 6),
    (3, 7),
    (2, 8),
    (1, 9);

-- Sample data for followers table
INSERT INTO followers (followers_user_id, following_user_id)
VALUES
    (1, 2), -- User 1 is following User 2
    (2, 3), -- User 2 is following User 3
    (3, 1), -- User 3 is following User 1
    (4, 2), -- User 4 is following User 2
    (5, 1), -- User 5 is following User 1
    (6, 3), -- User 6 is following User 3
    (2, 4), -- User 2 is following User 4
    (3, 4), -- User 3 is following User 4
    (4, 5), -- User 4 is following User 5
    (5, 6), -- User 5 is following User 6
    (6, 5), -- User 6 is following User 5
    (1, 4), -- User 1 is following User 4
    (2, 5), -- User 2 is following User 5
    (3, 6), -- User 3 is following User 6
    (4, 6), -- User 4 is following User 6
    (5, 2), -- User 5 is following User 2
    (6, 1), -- User 6 is following User 1
    (1, 3), -- User 1 is following User 3
    (2, 6), -- User 2 is following User 6
    (3, 5), -- User 3 is following User 5
    (7, 1), -- User 7 is following User 1
    (7, 2), -- User 7 is following User 2
    (7, 3), -- User 7 is following User 3
    (7, 4), -- User 7 is following User 4
    (7, 5), -- User 7 is following User 5
    (7, 6), -- User 7 is following User 6
    (1, 7), -- User 1 is following User 7
    (2, 7), -- User 2 is following User 7
    (3, 7), -- User 3 is following User 7
    (4, 7), -- User 4 is following User 7
    (5, 7), -- User 5 is following User 7
    (6, 7); -- User 6 is following User 7
