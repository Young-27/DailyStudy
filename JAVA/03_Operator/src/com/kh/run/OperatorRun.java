package com.kh.run;
import com.kh.operator.*;

public class OperatorRun { // com.kh.run.OperatorRun
	
	public static void main(String[] args) {
		
		A_Arithmetic a = new A_Arithmetic();		
		//a.method();
		
		B_InDecrease b = new B_InDecrease();
		//b.method1();
		b.method2();
		//b.method3();
		//b.method4();
		
		C_Compound c  = new C_Compound();
		//c.method();
		
		D_LogicalNegation d = new D_LogicalNegation();
		//d.method();
		
		E_Comparison e = new E_Comparison();
		//e.method1();
		//e.method2();
		
		F_Logical f = new F_Logical();
		//f.method1();
		//f.method2();
		//f.method3();
		//f.method4();
		
		G_Triple g = new G_Triple();
		//g.method1();
		//g.method2();
		//g.method3();
		//g.method4();
		//g.method5();
		
	}
	
	

}
