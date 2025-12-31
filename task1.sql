select distinct c.customer_id, c.customer_name
from Customer c
JOIN Orders o on c.customer_id = o.customer_id;

SELECT order_id, order_date, customer_id, employee_id, total
FROM Orders
WHERE customer_id = 1;

SELECT *
FROM LineItem
WHERE order_id = 1;

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




