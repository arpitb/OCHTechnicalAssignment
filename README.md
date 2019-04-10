# OCHTechnicalAssignment

The project contains two controllers. 
	1.	ItemController.java -- For handling the Items APIs
	2.	OrderController.java -- For handling the Orders APIs


ItemController.java has 5 APIs

Item has three attributes: 
1. Item Id -- To uniquely identify the item.
2. Item Name - Name of the item.
3. Item Count -- Count of the item.

APIs: 

/item/createItem - POST -- It will create a item in the MYSQL database with the item object being provided by the caller of the API.

/item/updateItem -- PUT -- It will update an already existing item in the database. If the item is not present, it will throw an error of "The item does not exist.". In this API, the item object will be provided by the caller of the API.

/item/deleteItem -- DELETE -- It will delete the item in the database according to the id provided by the caller of the API. The id should be provided by the caller as /item/updateItem/id=?. It will throw an error if there is no item present for the particular id provided.

/item/readItem -- GET -- It will get the item object from the database according to the id provided by the caller of the API. The id should be provided as /item/readItem/id=?.

/item/readAllItems -- GET -- It will list all the items present in the database with their  item name and the item count.


OrderController.java has 2 APIs

Order has 5 attributes:
1. Order Id: Generated Value (Uniquely identify an object)
2. Item Id: Id of the item in the order
3. Item Count: Count of the item placed in the order.
4. Item Name: Name of the item in the order.
5. Email Id: Email Id of the customer.

/order/allOrders -- GET -- It will list all the orders placed in the system that are present in the database.

/order/placeOrder -- POST -- It will check in the item table whether there is sufficient number of items present in the system to place the order. If there isn't, it will throw an error for out of stock. If any item id is provided wrongly, the system will throw an error for non - existence of the particular product. If all the data is correct, the order will be placed successfully.
