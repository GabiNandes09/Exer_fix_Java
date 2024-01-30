package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.Enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	//Associações
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //Lista de contratos do tipo HourContract
	//lista instanciada desde o começo
	public Worker() {		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		//Não gerar construtores com variaveis que sejam listas
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	//o metodo setContract não pode existir, pois ele atribuiria uma nova lista sempre que usado
	// fazendo a lista anterior desaparecer

	
	public void addContract (HourContract contract) {
		contracts.add(contract);
		//adiciona contract na lista de contracts
	}
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
		//remode contract na lista de contracts
	}
	
	public Double income (int year, int month) {
		Double sum = baseSalary;
		//Começando com o salário base, vamos procurar na lista de contratos
		//contratos que sejam do mês e ano requeridos e adicionar na soma
		Calendar cal = Calendar.getInstance();
		//Utilizarei Calendar para manipular datas para filtrar os contratos
		for(HourContract c : contracts) {
			cal.setTime(c.getDate()); //para cada c, pegarei a data e definirei como a data do calendario
			int cYear = cal.get(Calendar.YEAR);
			int cMonth = 1 + cal.get(Calendar.MONTH);//mês do Calendar começa no zero, por isso +1
			if(year == cYear && month == cMonth) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
