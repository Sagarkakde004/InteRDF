-- Catering Management System Seed Data
-- Insert sample data for development and testing

-- Insert default admin user (password: admin123)
INSERT INTO users (username, password, email, full_name, role) VALUES 
('admin', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2uheWG/igi.', 'admin@catering.com', 'System Administrator', 'ADMIN');

-- Insert sample customers
INSERT INTO customers (name, contact_person, phone, email, address, customer_type, payment_terms, notes) VALUES 
('Grand Hotel', 'Mr. Rajesh Kumar', '+91-9876543210', 'rajesh@grandhotel.com', '123 MG Road, Mumbai, Maharashtra 400001', 'PERMANENT', 'Net 30 days', 'Regular client for wedding events'),
('Sharma Wedding Planners', 'Mrs. Priya Sharma', '+91-9876543211', 'priya@sharmaweddings.com', '456 Park Street, Delhi, Delhi 110001', 'PERMANENT', 'Advance 50%, Balance on delivery', 'Premium wedding planner'),
('Corporate Events Ltd', 'Mr. Amit Patel', '+91-9876543212', 'amit@corporateevents.com', '789 Business District, Bangalore, Karnataka 560001', 'PERMANENT', 'Net 15 days', 'Corporate catering specialist'),
('Ravi Birthday Party', 'Mr. Ravi Singh', '+91-9876543213', 'ravi.singh@email.com', '321 Residential Area, Pune, Maharashtra 411001', 'ONE_TIME', 'Full payment in advance', 'One-time birthday celebration'),
('Meera Anniversary', 'Mrs. Meera Gupta', '+91-9876543214', 'meera.gupta@email.com', '654 Garden Colony, Chennai, Tamil Nadu 600001', 'ONE_TIME', 'Full payment in advance', 'Silver anniversary celebration');

-- Insert sample employees
INSERT INTO employees (employee_id, name, phone, email, address, employee_type, daily_rate, per_order_rate, hire_date, notes) VALUES 
('EMP001', 'Chef Ramesh Kumar', '+91-9876543220', 'ramesh@catering.com', '111 Chef Colony, Mumbai', 'COOK', 1500.00, 800.00, '2023-01-15', 'Head chef with 10 years experience'),
('EMP002', 'Sunita Devi', '+91-9876543221', 'sunita@catering.com', '222 Service Area, Mumbai', 'BAI', 800.00, 400.00, '2023-02-01', 'Experienced kitchen helper'),
('EMP003', 'Vikram Waiter', '+91-9876543222', 'vikram@catering.com', '333 Staff Quarters, Mumbai', 'WAITER', 1000.00, 500.00, '2023-01-20', 'Professional waiter with good communication'),
('EMP004', 'Suresh Driver', '+91-9876543223', 'suresh@catering.com', '444 Transport Hub, Mumbai', 'DRIVER', 1200.00, 600.00, '2023-03-01', 'Licensed driver with clean record'),
('EMP005', 'Raj Display Boy', '+91-9876543224', 'raj@catering.com', '555 Setup Area, Mumbai', 'DISPLAY_TABLE_BOY', 900.00, 450.00, '2023-02-15', 'Expert in table and display setup'),
('EMP006', 'Mohan Service Boy', '+91-9876543225', 'mohan@catering.com', '666 Service Lane, Mumbai', 'SERVICE_BOY', 800.00, 400.00, '2023-03-10', 'General service and cleanup'),
('EMP007', 'Chef Priya Patel', '+91-9876543226', 'priya.chef@catering.com', '777 Culinary Street, Mumbai', 'COOK', 1600.00, 850.00, '2023-01-10', 'Specialist in South Indian cuisine'),
('EMP008', 'Raman Waiter', '+91-9876543227', 'raman@catering.com', '888 Hospitality Road, Mumbai', 'WAITER', 1000.00, 500.00, '2023-02-20', 'Experienced in formal events');

-- Insert sample inventory items
INSERT INTO inventory_items (item_code, name, description, category, unit, current_stock, minimum_stock, unit_cost) VALUES 
-- Utensils
('UTN001', 'Stainless Steel Plates', 'Round dinner plates, 10 inch diameter', 'UTENSILS', 'pieces', 200, 50, 25.00),
('UTN002', 'Stainless Steel Bowls', 'Medium serving bowls', 'UTENSILS', 'pieces', 150, 30, 35.00),
('UTN003', 'Serving Spoons', 'Large serving spoons', 'UTENSILS', 'pieces', 100, 20, 15.00),
('UTN004', 'Water Glasses', 'Transparent water glasses', 'UTENSILS', 'pieces', 300, 50, 12.00),
('UTN005', 'Forks and Spoons Set', 'Stainless steel cutlery set', 'UTENSILS', 'sets', 80, 20, 45.00),

-- Display Tables
('TBL001', 'Round Display Table', '6 feet diameter round table', 'DISPLAY_TABLES', 'pieces', 20, 5, 1500.00),
('TBL002', 'Rectangular Display Table', '8x4 feet rectangular table', 'DISPLAY_TABLES', 'pieces', 15, 3, 1800.00),
('TBL003', 'Food Counter Table', 'Buffet serving counter', 'DISPLAY_TABLES', 'pieces', 10, 2, 2500.00),

-- Water Cans
('WTR001', '20 Liter Water Can', 'Drinking water container', 'WATER_CANS', 'pieces', 50, 10, 25.00),
('WTR002', 'Water Dispenser', 'Electric water dispenser', 'WATER_CANS', 'pieces', 8, 2, 3500.00),

-- Vegetables
('VEG001', 'Onions', 'Fresh red onions', 'VEGETABLES', 'kg', 100, 20, 30.00),
('VEG002', 'Tomatoes', 'Fresh tomatoes', 'VEGETABLES', 'kg', 80, 15, 40.00),
('VEG003', 'Potatoes', 'Fresh potatoes', 'VEGETABLES', 'kg', 120, 25, 25.00),
('VEG004', 'Green Vegetables Mix', 'Seasonal green vegetables', 'VEGETABLES', 'kg', 60, 10, 50.00),

-- Grocery
('GRC001', 'Basmati Rice', 'Premium basmati rice', 'GROCERY', 'kg', 200, 50, 80.00),
('GRC002', 'Cooking Oil', 'Refined cooking oil', 'GROCERY', 'liters', 100, 20, 120.00),
('GRC003', 'Spices Mix', 'Indian spices combination', 'GROCERY', 'kg', 50, 10, 200.00),
('GRC004', 'Dal (Lentils)', 'Mixed lentils', 'GROCERY', 'kg', 80, 15, 90.00),

-- Other Items
('OTH001', 'Gas Cylinder', 'LPG gas cylinder for cooking', 'OTHER', 'pieces', 10, 2, 800.00),
('OTH002', 'Tablecloth', 'White tablecloth for events', 'OTHER', 'pieces', 30, 5, 150.00),
('OTH003', 'Napkins', 'Paper napkins', 'OTHER', 'packets', 100, 20, 25.00);

-- Insert sample orders
INSERT INTO orders (order_number, customer_id, order_type, order_date, event_date, event_time, venue, guest_count, order_status, payment_status, total_amount, advance_amount, remaining_amount, special_instructions, created_by) VALUES 
('ORD001', 1, 'FULL_CATERING', '2024-01-15', '2024-01-25', '18:00:00', 'Grand Hotel Banquet Hall, Mumbai', 150, 'COMPLETED', 'FULLY_PAID', 75000.00, 37500.00, 0.00, 'Vegetarian menu only, no onion garlic', 1),
('ORD002', 2, 'FULL_CATERING', '2024-01-20', '2024-02-05', '19:00:00', 'Sharma Wedding Venue, Delhi', 300, 'IN_PROGRESS', 'ADVANCE_PAID', 150000.00, 75000.00, 75000.00, 'Mixed menu, special arrangements for 50 Jain guests', 1),
('ORD003', 3, 'HALF_CATERING', '2024-01-25', '2024-02-10', '12:00:00', 'Corporate Office, Bangalore', 100, 'PENDING', 'PENDING', 35000.00, 0.00, 35000.00, 'Lunch meeting, professional setup required', 1),
('ORD004', 4, 'HALF_CATERING', '2024-02-01', '2024-02-15', '20:00:00', 'Ravi Residence, Pune', 50, 'PENDING', 'ADVANCE_PAID', 25000.00, 12500.00, 12500.00, 'Birthday party, cake arrangement needed', 1),
('ORD005', 5, 'FULL_CATERING', '2024-02-05', '2024-02-20', '17:00:00', 'Community Hall, Chennai', 80, 'PENDING', 'PENDING', 40000.00, 0.00, 40000.00, 'Anniversary celebration, silver theme decoration', 1);

-- Insert sample order items (for Half Catering orders)
INSERT INTO order_items (order_id, item_name, description, quantity, unit, unit_price, total_price) VALUES 
-- Order 3 items
(3, 'Vegetable Biryani', 'Aromatic vegetable biryani with raita', 100, 'plates', 120.00, 12000.00),
(3, 'Dal Tadka', 'Yellow lentil curry', 100, 'portions', 60.00, 6000.00),
(3, 'Mixed Vegetable Curry', 'Seasonal vegetables in curry', 100, 'portions', 80.00, 8000.00),
(3, 'Roti/Chapati', 'Fresh wheat bread', 200, 'pieces', 8.00, 1600.00),
(3, 'Salad', 'Fresh green salad', 100, 'portions', 30.00, 3000.00),
(3, 'Dessert', 'Gulab jamun', 100, 'pieces', 25.00, 2500.00),

-- Order 4 items
(4, 'Chicken Biryani', 'Hyderabadi chicken biryani', 50, 'plates', 180.00, 9000.00),
(4, 'Paneer Butter Masala', 'Cottage cheese in rich gravy', 50, 'portions', 120.00, 6000.00),
(4, 'Naan', 'Butter naan bread', 100, 'pieces', 15.00, 1500.00),
(4, 'Raita', 'Yogurt with cucumber', 50, 'portions', 40.00, 2000.00),
(4, 'Ice Cream', 'Vanilla ice cream', 50, 'scoops', 35.00, 1750.00),
(4, 'Birthday Cake', '2kg chocolate cake', 1, 'piece', 1200.00, 1200.00);

-- Insert sample employee assignments to orders
INSERT INTO order_employees (order_id, employee_id, payment_amount, is_paid) VALUES 
-- Order 1 assignments
(1, 1, 800.00, true),  -- Chef Ramesh
(1, 3, 500.00, true),  -- Vikram Waiter
(1, 5, 450.00, true),  -- Raj Display Boy
(1, 6, 400.00, true),  -- Mohan Service Boy

-- Order 2 assignments
(2, 1, 850.00, false), -- Chef Ramesh
(2, 7, 850.00, false), -- Chef Priya
(2, 3, 500.00, false), -- Vikram Waiter
(2, 8, 500.00, false), -- Raman Waiter
(2, 4, 600.00, false), -- Suresh Driver
(2, 5, 450.00, false), -- Raj Display Boy

-- Order 3 assignments
(3, 1, 800.00, false), -- Chef Ramesh
(3, 2, 400.00, false), -- Sunita Devi
(3, 3, 500.00, false), -- Vikram Waiter

-- Order 4 assignments
(4, 7, 850.00, false), -- Chef Priya
(4, 8, 500.00, false), -- Raman Waiter
(4, 6, 400.00, false); -- Mohan Service Boy

-- Insert sample inventory assignments to orders
INSERT INTO order_inventory_items (order_id, inventory_item_id, quantity_assigned, quantity_returned) VALUES 
-- Order 1 inventory
(1, 1, 150, 150), -- Plates
(1, 2, 100, 100), -- Bowls
(1, 4, 150, 150), -- Water glasses
(1, 6, 3, 3),     -- Round tables
(1, 9, 8, 8),     -- Water cans

-- Order 2 inventory (in progress)
(2, 1, 300, 0),   -- Plates
(2, 2, 200, 0),   -- Bowls
(2, 4, 300, 0),   -- Water glasses
(2, 6, 5, 0),     -- Round tables
(2, 7, 3, 0),     -- Rectangular tables
(2, 9, 15, 0),    -- Water cans

-- Order 3 inventory
(3, 1, 100, 0),   -- Plates
(3, 4, 100, 0),   -- Water glasses
(3, 7, 2, 0);     -- Rectangular tables

-- Insert sample tasks
INSERT INTO tasks (order_id, title, description, task_status, priority, due_date, created_by) VALUES 
-- Order 2 tasks (in progress)
(2, 'Menu Planning', 'Finalize menu with client preferences', 'DONE', 3, '2024-01-22', 1),
(2, 'Ingredient Procurement', 'Purchase all required ingredients', 'IN_PROGRESS', 3, '2024-02-03', 1),
(2, 'Staff Coordination', 'Coordinate with assigned staff members', 'TODO', 2, '2024-02-04', 1),
(2, 'Equipment Setup', 'Setup tables, utensils and serving equipment', 'TODO', 2, '2024-02-05', 1),
(2, 'Final Quality Check', 'Quality check before event start', 'TODO', 3, '2024-02-05', 1),

-- Order 3 tasks
(3, 'Corporate Menu Approval', 'Get menu approved by corporate client', 'TODO', 3, '2024-02-08', 1),
(3, 'Professional Setup Planning', 'Plan professional setup for corporate event', 'TODO', 2, '2024-02-09', 1),

-- Order 4 tasks
(4, 'Birthday Cake Order', 'Order custom birthday cake', 'TODO', 3, '2024-02-12', 1),
(4, 'Party Decoration Setup', 'Setup birthday party decorations', 'TODO', 1, '2024-02-15', 1),

-- Order 5 tasks
(5, 'Silver Theme Planning', 'Plan silver theme decoration', 'TODO', 2, '2024-02-18', 1),
(5, 'Anniversary Special Menu', 'Create special anniversary menu', 'TODO', 3, '2024-02-17', 1);

-- Insert sample task assignments
INSERT INTO task_assignments (task_id, employee_id) VALUES 
(1, 1), -- Menu planning assigned to Chef Ramesh
(1, 7), -- Menu planning assigned to Chef Priya
(2, 1), -- Ingredient procurement assigned to Chef Ramesh
(3, 3), -- Staff coordination assigned to Vikram
(3, 8), -- Staff coordination assigned to Raman
(4, 5), -- Equipment setup assigned to Raj
(6, 1), -- Corporate menu approval assigned to Chef Ramesh
(8, 7), -- Birthday cake order assigned to Chef Priya
(10, 1), -- Anniversary menu assigned to Chef Ramesh
(10, 7); -- Anniversary menu assigned to Chef Priya

