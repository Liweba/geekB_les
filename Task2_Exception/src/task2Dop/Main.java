package task2Dop;

public class Main {
    enum DayOfWeek{MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};

    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.TUESDAY, 5, 8); /** Текущий день | рабочих дней в неделю начиная с понедельника | кол-во рабочих часов в день*/
    }

    private static void getWorkingHours(DayOfWeek tuesday, int workingDays, int workingHoursDay){
        if (workingHoursDay <= 0 || workingHoursDay > 24){
            System.out.println("Рабочие часы могут быть от 1 до 24, у вас же: " + workingHoursDay);
        }else if(workingDays <= 0 || workingDays > 7){
            System.out.println("Рабочие дни могут быть от 1 до 7, у вас же: " + workingDays);
        }else if (tuesday.ordinal() < workingDays){
            System.out.println("Рабочих часов до конца недели: " +  (workingDays - tuesday.ordinal())*workingHoursDay);
        }else{
            System.out.println("Выходной день");
        }
    }
}
