public class TestExccevption
	{
		private int	result	= 0;

		
		public static void main(){
			
		}
		public int divideIntegers ( ) {
			int divisor = 56;
			int divident = 0;

			try {
				result = divisor / divident;

			}
			catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}

	}
