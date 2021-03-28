package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {

		Employee[] emp = new Employee[3];
		
		emp[0] = new Employee();
		emp[1] = new Employee(1, "È«±æµ¿", 19, 'M', "01011112222", "¼­¿ï Àá½Ç");
		emp[2] = new Employee(2, "°­¸»¼ø", "±³À°ºÎ", "°­»ç", 20, 'F', 1000000, 0.01, "01011112222", "¼­¿ï ¸¶°î");
		
		for(Employee e : emp) {
			System.out.println(e.information());
		}
		System.out.println("=====================================================================");
		
		emp[0].setEmpNo(0);
		emp[0].setEmpName("±è¸»¶Ë");
		emp[0].setDept("¿µ¾÷ºÎ");
		emp[0].setJob("ÆÀÀå");
		emp[0].setAge(30);
		emp[0].setGender('M');
		emp[0].setSalary(3000000);
		emp[0].setBonusPoint(0.2);
		emp[0].setPhone("01055559999");
		emp[0].setAddress("Àü¶óµµ ±¤ÁÖ");
		
		emp[1].setDept("±âÈ¹ºÎ");
		emp[1].setJob("ºÎÀå");
		emp[1].setSalary(4000000);
		emp[1].setBonusPoint(0.3);
		
		System.out.println(emp[0].information());
		System.out.println(emp[1].information());
		System.out.println("=====================================================================");
		
		int a = (int)((emp[0].getSalary() + (emp[0].getSalary() * emp[0].getBonusPoint()))*12);
		int b = (int)((emp[1].getSalary() + (emp[1].getSalary() * emp[1].getBonusPoint()))*12); 
		int c = (int)((emp[2].getSalary() + (emp[2].getSalary() * emp[2].getBonusPoint()))*12);
		
		System.out.println("±è¸»¶ËÀÇ ¿¬ºÀ : " + a + "¿ø");
		System.out.println("È«±æµ¿ÀÇ ¿¬ºÀ : " + b + "¿ø");
		System.out.println("°­¸»¼øÀÇ ¿¬ºÀ : " + c + "¿ø");
		
		System.out.println("=====================================================================");
		
		System.out.println("°­¸»¼øÀÇ ¿¬ºÀ : " + (int)((a+b+c)/3) + "¿ø");
	}

}
