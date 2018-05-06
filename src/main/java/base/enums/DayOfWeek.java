package base.enums;

/**
 * test_PreciseQ
 * <p>
 * Created by Vadym on 05.05.18 in the package base.
 */
public enum DayOfWeek {

    SUNDAY("Воскресенье", 1),
   MONDAY("Понедельник", 2),
   TUESDAY("Вторник", 3),
   WEDNESDAY("Среда", 4),
   THURSDAY("Четверг", 5),
   FRIDAY("Пятница", 6),
   SATURDAY("Суббота", 7);

   private String name;
   private int id;

   DayOfWeek(String name, int id){
       this.name = name;
       this.id = id;
   }

    /**
    * Get the value of name
    * @return the name
    */
   public String getName(){
       return name;
   }

    /**
     * Get id
     * @return the name
     */
   public Integer getId(){
       return id;
   }
}
