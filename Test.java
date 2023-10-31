import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String args[])
    {
        List<EmployeeObject> employeeObjectList = new ArrayList<EmployeeObject>();

        employeeObjectList.add(new EmployeeObject(111, "Jeya", 30, "Female", "HR", 2011, 25000.0));
        employeeObjectList.add(new EmployeeObject(122, "Polish", 29, "Male", "Sales", 2015, 18500.0));
        employeeObjectList.add(new EmployeeObject(133, "Thomas", 26, "Male", "Administartion", 2012, 18700.0));
        employeeObjectList.add(new EmployeeObject(144, "Gowthami", 29, "Female", "Development", 2014, 33500.0));
        employeeObjectList.add(new EmployeeObject(155, "Nisha", 25, "Female", "HR", 2013, 22000.0));
        employeeObjectList.add(new EmployeeObject(166, "Issac", 40, "Male", "Maintenance", 2016, 12000.0));
        employeeObjectList.add(new EmployeeObject(177, "Sharmila", 30, "Female", "Finance", 2010, 29000.0));
        employeeObjectList.add(new EmployeeObject(188, "Linga", 33, "Male", "Development", 2015, 35000.0));
        employeeObjectList.add(new EmployeeObject(199, "John", 34, "Male", "Sales", 2016, 14500.0));
        employeeObjectList.add(new EmployeeObject(200, "Jeyam", 36, "Male", "Maintenance", 2015, 17000.0));
        employeeObjectList.add(new EmployeeObject(211, "kumar", 37, "Male", "Administartion", 2014, 18700.0));
        employeeObjectList.add(new EmployeeObject(222, "Joshi", 25, "Male", "Development", 2016, 29000.0));
        employeeObjectList.add(new EmployeeObject(233, "Reddy", 29, "Male", "Finance", 2013, 27000.0));
        employeeObjectList.add(new EmployeeObject(244, "Denwer", 28, "Male", "Sales", 2017, 18000.));
        employeeObjectList.add(new EmployeeObject(255, "Alia", 26, "Female", "Administartion", 2018, 13000.0));
        employeeObjectList.add(new EmployeeObject(266, "Sangavi", 36, "Female", "Development", 2015, 29000.0));
        employeeObjectList.add(new EmployeeObject(277, "Anuja", 32, "Female", "Development", 2012, 38000.0));

        //how many employee objects in company are male and female

        Map<String, List<EmployeeObject>> map = employeeObjectList.stream().collect(Collectors.groupingBy(EmployeeObject::getEmp_gender));

        int men = map.get("Male").size();
        int women = map.get("Female").size();

        System.out.println("men count"+men);
        System.out.println("women count"+women);

        //printing names of every dept in the company
       Map<String,List<String>> map1 =  employeeObjectList.stream().
               collect(Collectors.groupingBy(EmployeeObject::getEmp_dep, Collectors.mapping(e->e.getEmp_name(), Collectors.toList())));

       System.out.println(map1);

       //Highest paid employee in the company
        String eName = employeeObjectList.stream().max(Comparator.comparingDouble(EmployeeObject::getEmp_salary)).get().getEmp_name();
        System.out.println(eName);

        //list the names of employess who have joined after 2014.

        List<String> emp_joined_after_2014= employeeObjectList.stream().filter(e->e.getYear_of_joining()>2014).collect(Collectors.mapping(e->e.getEmp_name(), Collectors.toList()));
        System.out.println(emp_joined_after_2014);

        //calculate how many ppl work in each dept.

        Map<String, Long> map3 = employeeObjectList.stream().collect(Collectors.groupingBy(e->e.getEmp_dep(), Collectors.counting()));
        System.out.println(map3);
        map3.entrySet().forEach(entry->System.out.println(entry.getKey()+"---"+entry.getValue()));

        //Each depts avg pay
        Map<String, Double> map4 = employeeObjectList.stream().collect(Collectors.groupingBy(EmployeeObject::getEmp_dep, Collectors.averagingDouble(EmployeeObject::getEmp_salary)));
        System.out.println(map4);

        //Find out youngest male position in dev dept

        String emp_name_dev_young = employeeObjectList.stream()
                .filter(e->(e.getEmp_dep().equals("Development") && e.getEmp_gender().equals("Male")))
                .min(Comparator.comparingInt(EmployeeObject::getEmp_age)).get().getEmp_name();

        System.out.println(emp_name_dev_young);


        //Who has most wrk exp within company

        String emp_with_more_wrk_exp = employeeObjectList.stream().min(Comparator.comparingInt(EmployeeObject::getYear_of_joining)).get().getEmp_name();

        System.out.println(emp_with_more_wrk_exp);

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        //employee with max sal in each dept

        Map<String, String> mapp = employeeObjectList.stream().
                collect(Collectors.groupingBy(EmployeeObject::getEmp_dep, Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparing(EmployeeObject::getEmp_salary)), emp->emp.get().getEmp_name()
        )));

        Map<String, Double> mapp2 = employeeObjectList.stream()
                .collect(Collectors.groupingBy(EmployeeObject::getEmp_dep,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(EmployeeObject::getEmp_salary)),
                                emp -> emp.map(EmployeeObject::getEmp_salary).orElse(0.0)
                        )
                ));














    }
}
