package project2002;

import java.time.LocalDateTime;

import project2002.Restaurant.UIType;
import project2002.Restaurant.handlerType;

public class OrderManager extends Manager {
	OrderHandler orderHandler = new OrderHandler();
	MenuHandler menu = new MenuHandler();

	OrderUI orderUI;

	/**
	 * This function does blah blah
	 */
	public OrderManager() {
		handlerList.add(menu);
		handlerList.add(orderHandler);
		type = UIType.ORDER;
	}

	int addOrderItem(int orderID) {
		int itemID = 0;
		menu.printMenu();
		itemID = orderUI.getItemID();
		int quantity = orderUI.getQty();
		MenuItem MenuItem = menu.getItem(itemID); // Takes in the itemID and returns the menuitem
		if (MenuItem == null)
			return -1; // item does not exist
		if (orderHandler.AddItem(orderID, MenuItem, quantity))
			return 1; // successful
		return 0; // unsuccessful
	}

	boolean removeOrderItem(int orderID) {
		int itemID = 0;
		orderHandler.printOrder(orderID);
		itemID = orderUI.getItemID();
		int quantity = orderUI.getQty();
		MenuItem MenuItem = menu.getItem(itemID); // Takes in the itemID and returns the menuitem
		return orderHandler.RemoveItem(orderID, MenuItem, quantity); // Add menuitem to the particular orderID
	}

	void printOrderInvoice(int orderID) {
		Double discount = orderUI.getDiscount();
		Order order = orderHandler.printInvoice(orderID, discount);
		SalesReportManager.addOrder(order);
	}

	@Override
	public void assignHandler(Handler h) {
		if (h.getType() == handlerType.ORDER)
			orderHandler = (OrderHandler) h;
		else if (h.getType() == handlerType.MENU)
			menu = (MenuHandler) h;
		return;
	}

	@Override
	public void assignUI(UI ui) {
		orderUI = (OrderUI) ui;
	}

}
