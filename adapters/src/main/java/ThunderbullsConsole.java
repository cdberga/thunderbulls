import com.thunderbulls.adapter.controller.StockController;
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
		saving();
		finding();
	}

	private static void saving() {
		try {
			StockView view = controller.save("VALE5", "Vale SA");
			StockViewModel model = view.getViewModel();

			System.out.println("Stock: " + model.getCode() + " - Company: " + model.getCompany() + " was saved.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void finding() {
		try {
			StockView view = controller.findStock("PETR4");
			StockViewModel model = view.getViewModel();
			if (model == null) {
				System.out.println("Stock: \"PETR4\" - was not found");
			} else {
				System.out.println("Stock: " + model.getCode() + " - Company: " + model.getCompany() + ".");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
