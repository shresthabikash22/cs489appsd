package cs.miu.edu.cs489appsd.lab1b;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import cs.miu.edu.cs489appsd.lab1b.model.Employee;
import cs.miu.edu.cs489appsd.lab1b.model.PensionPlan;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeePensionSystem {

    public static  void printEmployeeList(List<Employee> employees){
        if(employees == null || employees.isEmpty()){
            System.out.println("No employee data found!!!!");
            return;
        }
        List<Employee> newList = employees.stream().sorted(Comparator.comparing(Employee::getYearlySalary).reversed().thenComparing(Employee::getLastName)).toList();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try{
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newList);
            System.out.println("Employee List");
            System.out.println(json);
        }catch(Exception e){
            System.out.println("Could not convert Employee data to JSON");
            System.out.println(e);
        }
    }

    public static void listPotentialPensionEnrolees(List<Employee> employees){
        if(employees == null || employees.isEmpty()){
            System.out.println("No employee data found!!!!");
            return;
        }
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month startMonth, endMonth;
        switch ((today.getMonthValue()-1)/3){
            case 0 :
                startMonth= Month.APRIL;
                endMonth = Month.JUNE;
                break;
            case 1 :
                startMonth= Month.JULY;
                endMonth = Month.SEPTEMBER;
                break;
            case 2 :
                startMonth= Month.OCTOBER;
                endMonth = Month.DECEMBER;
                break;
            default :
                startMonth= Month.JANUARY;
                endMonth = Month.MARCH;
                year ++;
        }

        LocalDate quarterStart = LocalDate.of(year,startMonth,1);
        LocalDate quarterEnd = LocalDate.of(year,endMonth,endMonth.length(Year.of(year).isLeap()));

//        List<Employee> enrolls = new ArrayList<>();
//        for(Employee e : employees){
//            if(e.getPensionPlan() == null){
//                LocalDate eligibilityDate = e.getEmploymentDate().plusYears(3);
//                System.out.print( e.getFirstName() + " "+ eligibilityDate);
//                if(eligibilityDate.isEqual(quarterStart)||
//                        ( eligibilityDate.isAfter(quarterStart) &&
//                        eligibilityDate.isBefore(quarterEnd) )||
//                        eligibilityDate.isEqual(quarterEnd)){
//                    System.out.println(" Eligible");
//                    enrolls.add(e);
//                }
//            }
//        }

        List<Employee> enrolls= employees.stream()
                .filter(emp -> emp.getPensionPlan()==null)
                .filter(emp -> {
                    LocalDate eligibilityDate = emp.getEmploymentDate().plusYears(3);
                    return
                        eligibilityDate.isEqual(quarterStart)||eligibilityDate.isEqual(quarterEnd) ||
                                (eligibilityDate.isAfter(quarterStart) &&
                                        eligibilityDate.isBefore(quarterEnd)) ;
                })
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .toList();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String jsonOutput = objectMapper.writeValueAsString(enrolls);
            System.out.println("Next Quarter Pension Enrolees ( In JSON Format):");
            System.out.println(jsonOutput);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1000L,"Daniel","Agar", LocalDate.of(2018,1,17),105945.50,new PensionPlan("EX1089",LocalDate.of(2018,01,17),100.00)),
                new Employee(1002L, "Bernard", "Shaw", LocalDate.of(2022, 9, 3), 197750.00,null ),
                new Employee(1001L,"Carly","Agar",LocalDate.of(2014,5,16),842000.75,new PensionPlan("SM2307",LocalDate.of(2019,11,04),1555.50)),
                new Employee(1003L, "Wesley", "Schneider", LocalDate.of(2022, 7, 21), 74500.00,null),
                new Employee(1004L,"Anna","Wiltord",LocalDate.of(2022,6,15),85750.00,null),
                new Employee(1005L,"Yosef","Tesfalem",LocalDate.of(2022,10,31),100000.00,null)
        );

//        printEmployeeList(employees);
        listPotentialPensionEnrolees(employees);
    }
}