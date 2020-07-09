import java.util.List;

import com.thunderbulls.adapter.controller.StockController;
import com.thunderbulls.adapter.view.StockListView;
import com.thunderbulls.adapter.view.StockView;
import com.thunderbulls.adapter.view.StockViewModel;
import com.thunderbulls.stock.AddStock;
import com.thunderbulls.stock.FindStock;
import com.thunderbulls.stock.input.AddStockInput;
import com.thunderbulls.stock.input.FindStockInput;

public class ThunderbullsConsole {

	static StockController controller;

	static AddStockInput addStock;
	static FindStockInput findStock;

	public static void main(String[] args) {
		addStock = new AddStock();
		findStock = new FindStock();
		controller = new StockController(findStock, addStock);
		list();
		saving();
		finding();
	}

	private static void list() {
		try {
			StockListView view = controller.findAll();
			List<StockViewModel> list = view.getList();
			
			for (StockViewModel model : list) {
				System.out.println("Stock: " + model.getCode() + " - Company: " + model.getCompany() + ".");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void saving() {
		try {
			StockView view = controller.save("PETR4", "Petrobras SA");
			StockViewModel model = view.getViewModel();

			System.out.println("Stock: " + model.getCode() + " - Company: " + model.getCompany() + " was saved.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void finding() {
		try {
			StockView view = controller.findStock("VALE5");
			StockViewModel model = view.getViewModel();
			if (model == null) {
				System.out.println("Stock: \"VALE5\" - was not found");
			} else {
				System.out.println("Stock: " + model.getCode() + " - Company: " + model.getCompany() + ".");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
