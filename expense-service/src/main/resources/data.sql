-- Insert dummy expenses for User 1
INSERT INTO expenses (user_id, category, description, amount, date) VALUES
(1, 'Groceries', 'Weekly supermarket shopping', 125.75, DATEADD('DAY', -2, CURRENT_DATE)),
(1, 'Transport', 'Monthly metro pass', 80.00, DATEADD('DAY', -5, CURRENT_DATE)),
(1, 'Dining', 'Dinner with friends', 45.50, DATEADD('DAY', -1, CURRENT_DATE)),
(1, 'Entertainment', 'Movie tickets', 30.00, DATEADD('DAY', -3, CURRENT_DATE));

-- Insert dummy expenses for User 2
INSERT INTO expenses (user_id, category, description, amount, date) VALUES
(2, 'Groceries', 'Organic food purchase', 95.20, DATEADD('DAY', -4, CURRENT_DATE)),
(2, 'Transport', 'Taxi ride', 25.00, DATEADD('DAY', -1, CURRENT_DATE)),
(2, 'Utilities', 'Electricity bill', 120.00, DATEADD('DAY', -10, CURRENT_DATE));

-- Previous month expenses
INSERT INTO expenses (user_id, category, description, amount, date) VALUES
(1, 'Groceries', 'Monthly bulk purchase', 200.00, DATEADD('MONTH', -1, CURRENT_DATE)),
(2, 'Entertainment', 'Concert tickets', 150.00, DATEADD('MONTH', -1, CURRENT_DATE));