
Customer
    email
    name
    address
    index on name or email
    phone number

Orders
# use order_products instead
 # product_id
 customer_id
 street_address
 city
 state
 zipcode
 phone_number


 Order_products
    order_id
    product_id


Product
    name
    description
    brand
    cost


Cart
    Customer_Id # allow blank
    Order_Id


GET /orders # return of orders
POST /orders # Creates order, add items into order_products
PUT /orders # Update order, with new info
DELETE /orders # Delete order
POST /order_products # add product to order




