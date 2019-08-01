import java.util.concurrent.Callable;

public class Numbers implements Callable<Integer> {
	
	private int start;
	private int end;
	
	
	public Numbers(int start, int end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i = start; i <= end; i++) {
			sum+=i;
		}
		return sum;
	}

}
