INSERT INTO notifications (
    user_id, type, message, category, budget_amount, expense_amount, 
    expense_description, created_at, read
) VALUES 
(101, 'BUDGET_EXCEEDED', 'You have exceeded your grocery budget.', 'Groceries', 5000.00, 5200.00, 'Monthly grocery shopping', CURRENT_TIMESTAMP, false),

(102, 'BUDGET_EXCEEDED', 'Your entertainment spending has surpassed the limit.', 'Entertainment', 2000.00, 2500.00, 'Weekend movie and dinner', CURRENT_TIMESTAMP, false),

(103, 'BUDGET_EXCEEDED', 'Transport budget exceeded for this week.', 'Transport', 1200.00, 1400.00, 'Cab and fuel expenses', CURRENT_TIMESTAMP, true);
