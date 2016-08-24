public class ClassA extends ClassB
	{
		ClassB	a	= new ClassB();

		public void callRunTime ( ) {
			a.methodThrowsRunTimeEx(); 
	}
		
		public void callCheckException1 ( ) throws Throwable {
			a.methodThrowsCheckedException();
	}
		public void callCheckException ( ) throws Throwable {
			a.methodThrowsCheckedException();
	}
		

	}
