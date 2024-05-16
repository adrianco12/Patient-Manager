// patient class
public class Patient
{
   // intialize fields
   private String name;
   private String injury;
   private int priority; // will be 1-10 (1 is highest priority)
   
   // constructor
   public Patient (String name, String injury, int priority)
   {
      this.name = name;
      this.injury = injury;
      this.priority = priority;
   }
   
   // getter methods
   public String getName ()
   {
      return name;
   }
   public String getInjury ()
   {
      return injury;
   }
   public int getPriority ()
   {
      return priority;
   }
}