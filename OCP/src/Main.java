
public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("ocp main test");
		ChartDisplayManager manager = new ChartDisplayManager();
		manager.display(new LineChart());
		manager.display(new BarChart());
		manager.display(new PieChart());
		manager.display(new newChart());
	}

}
