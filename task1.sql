-- câu 1 --
select distinct c.customer_id, c.customer_name
from Customer c
JOIN Orders o on c.customer_id = o.customer_id;

-- câu 2 --
SELECT order_id, order_date, customer_id, employee_id, total
FROM Orders
WHERE customer_id = 1;

-- câu 3 --
SELECT *
FROM LineItem
WHERE order_id = 1;


-- câu 4 --
DELIMITER//

	CREATE PROCEDURE COMPUTE_ORDER_TOTAL(p_order_id int)
    RETURNS DECIMAL(10,2)
    DETERMINISTIC
    BEGIN
		DECLARE total DECIMAL(10,2);
        
        SELECT SUM(quantity*price)
        INTO total
        FROM LineItem
        where order_id = p_order_id;
        RETURN IFNULL(total, 0);
	END//
    
DELIMITER;

-- câu 5 --
DELIMITER //

CREATE PROCEDURE add_customer(IN p_customer_name VARCHAR(255))
BEGIN
    INSERT INTO Customer(customer_name)
    VALUES (p_customer_name);
END//

DELIMITER ;

-- câu 6 --
DELIMITER //

CREATE PROCEDURE delete_customer(IN p_customer_id INT)
BEGIN
    DELETE FROM LineItem
    WHERE order_id IN (
        SELECT order_id FROM Orders WHERE customer_id = p_customer_id
    );

    DELETE FROM Orders
    WHERE customer_id = p_customer_id;

    DELETE FROM Customer
    WHERE customer_id = p_customer_id;
END//

DELIMITER ;

-- câu 7 --
DELIMITER //

CREATE PROCEDURE update_customer(
    IN p_customer_id INT,
    IN p_customer_name VARCHAR(255)
)
BEGIN
    UPDATE Customer
    SET customer_name = p_customer_name
    WHERE customer_id = p_customer_id;
END//

DELIMITER ;


-- câu 8 --
DELIMITER //

create procedure create_order(
	in p_order_date datetime,
    in p_customer_id int, 
	in p_employee_id int
)
BEGIN
	insert into Orders(order_date, customer_id, employee_id)
    values(p_order_date, p_customer_id, p_employee_id);
END//

DELIMITER ;

