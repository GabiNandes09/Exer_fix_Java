package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.println();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double salary = sc.nextDouble();
		
		
		
		System.out.print("How many contracts to this worker?");
		Integer n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Double hours = sc.nextDouble();
			sc.nextLine();
		}
		
		System.out.print("Enter the month and year to calculate income (MM/YY): ");
		String monthAndYear = sc.next();
	}
}
