-- 사용자 테이블 생성
CREATE TABLE users (
                       user_id CHAR(36) NOT NULL DEFAULT (REPLACE(UUID(), '-', '')) PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash CHAR(60) NOT NULL,
                       created_at DATETIME NOT NULL,
                       updated_at DATETIME
);

-- 게시판 테이블 생성
CREATE TABLE board (
                       board_id CHAR(36) NOT NULL DEFAULT (REPLACE(UUID(), '-', '')) PRIMARY KEY,
                       board_name VARCHAR(255) NOT NULL,
                       created_at DATETIME NOT NULL,
                       updated_at DATETIME
);

-- 게시글 테이블 생성
CREATE TABLE post (
                      post_id INT AUTO_INCREMENT PRIMARY KEY,
                      board_id CHAR(36),
                      user_id CHAR(36),
                      title VARCHAR(255) NOT NULL,
                      content TEXT NOT NULL,
                      created_at DATETIME NOT NULL,
                      updated_at DATETIME,
                      FOREIGN KEY (board_id) REFERENCES board(board_id),
                      FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- 댓글 테이블 생성
CREATE TABLE comment (
                         comment_id INT AUTO_INCREMENT PRIMARY KEY,
                         post_id INT,
                         user_id CHAR(36),
                         content TEXT NOT NULL,
                         created_at DATETIME NOT NULL,
                         updated_at DATETIME,
                         FOREIGN KEY (post_id) REFERENCES post(post_id),
                         FOREIGN KEY (user_id) REFERENCES users(user_id)
);
