

public class Manager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//DBConnection.connectDB();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		StockRTData test = new StockRTData("GOOG","1min");
	}

}
