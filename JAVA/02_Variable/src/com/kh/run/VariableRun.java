package com.kh.run;
/*
import com.kh.variable.A_Variable;
import com.kh.variable.B_KeyboardInput;
import com.kh.variable.C_Cast;
*/
import com.kh.variable.*;

public class VariableRun {
	
	// 메인메소드 작성
	public static void main(String[] args) {
		
		A_Variable a = new A_Variable();
		
		//a.printValue();
		//a.declareVariable();
		//a. initVariable();
		//a. constant();
		
		B_KeyboardInput b = new B_KeyboardInput();
		
		//b.inputTest1();
		//b.inputTest2();
		//b.inputScanner3();
		
		C_Cast c = new C_Cast();
		
		//c.autoCasting();
		//c.forceCasting();
		
		F_Printf f = new F_Printf();
		
		f.printfTest();
		
		
	}

}
