package test;

import model.EmpBusinessLogic;
import model.Employee;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmployeeLogic {
	EmpBusinessLogic empBL = new EmpBusinessLogic();
	Employee employee = new Employee("Emily");

	public void setUp() throws Exception {

	}

	@Test
	public void testCalculateAppraisal() {
		employee.setMonthlySalary(8000);
		double appraisal = empBL.calculateAppraisal(employee);
		assertEquals(500, appraisal, 0.0);
	}

	@Test
	public void testEmployeeIsNotRetirementAge() {
		employee.setAge(25);
		assertFalse(empBL.isRetirementAge(employee));
	}

}