import javax.management.RuntimeErrorException;


public class ClassB
	{
		
		public double methodThrowsRunTimeEx () {
			 throw new RuntimeErrorException(null); 
			
		}
		
		public double methodThrowsError () {
			throw new Error();
		}
		
		
		public double methodThrowableException() throws TypeException{
			throw new TypeException();		
		}
		 
		public double methodThrowsCheckedException() throws TypeException{
			try {
				throw new Exception();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

	}
