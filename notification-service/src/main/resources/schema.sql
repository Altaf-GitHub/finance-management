CREATE TABLE notifications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type VARCHAR(100) NOT NULL,
    message VARCHAR(500) NOT NULL,
    category VARCHAR(100) NOT NULL,
    budget_amount DECIMAL(19, 2) NOT NULL,
    expense_amount DECIMAL(19, 2) NOT NULL,
    expense_description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    read BOOLEAN NOT NULL
);
