import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class StockHData extends StockDataModel{
		
		public StockHData(String symbol, String interval)
		{
			String url = URL_PREFIX+"TIME_SERIES_MONTHLY&symbol="+symbol+"&interval="+interval+"&apikey="+API_KEY+"&datatype=csv";;
			try {
				URL rowdata = new URL(url);
				URLConnection data = rowdata.openConnection();
				Scanner input  = new Scanner(data.getInputStream());
	
				while(input.hasNextLine())
				{
					String line = input.nextLine();
					//Debug
					System.out.println(line);
				}
				input.close();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}
}
