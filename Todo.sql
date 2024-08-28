CREATE TABLE Todo (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      title VARCHAR(255) NOT NULL,
                      content TEXT,
                      created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Comment (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         todo_id BIGINT,
                         content TEXT NOT NULL,
                         created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         username VARCHAR(50) NOT NULL,
                         FOREIGN KEY (todo_id) REFERENCES Todo(id) ON DELETE CASCADE
);