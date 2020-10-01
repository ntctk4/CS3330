/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4languagebasics;

/**
 *
 * @author Nathan
 */
public class Ntctk4LanguageBasics 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        byte sample1 = 58;
        byte sample2 = 0x3A;
        int choice = 2;
        short heartRate = 72;
        long deposits = 135002795;
        float acceleration = 9.675f;
        float mass = 12.4f;
        double distance = 129.765001;
        boolean lost = true;
        boolean expensive = false;
        char integral = '\u222B';
        char letter1 = 'a';
        char letter2 = 97;
        String greeting = "Hello";
        String name = "Sally";
        
        if(sample1 == sample2)
        {
            System.out.println("The samples are equal.");
        }
        else
            System.out.println("The samples are not equal.");
        
        
        
        if(heartRate > 40 && heartRate < 80)
        {
            System.out.println("Heart rate is normal.");
        }
        else
            System.out.println("Heart rate is not normal");
        
        
        if(deposits > 100000000)
        {
            System.out.println("You are exceedingly wealthy.");
            
        }
        else
            System.out.println("Sorry you are so poor.");
        
        
        float force = mass * acceleration;
        
        
        System.out.printf("Force = %.3f\n", force);
        
        
        if(lost == true && expensive == true)
        {
            System.out.println("I am really sorry! I will get the manger.");
        }
        else if(lost == true && expensive == false)
        {
            System.out.println("Here is coupon for 10% off.");
        }
        
        
        switch(choice)
        {
            case 1: 
                System.out.println("You chose 1");
                break;
            
            case 2: 
                System.out.println("You chose 2");
                break;
                
            case 3: 
                System.out.println("You chose 3");
                break;
                
            case 4: 
                System.out.println("You made an unknown choice.");
         }
        
        
        System.out.printf("%c is an integral.\n", integral);
        
        
        if(letter1 == letter2)
        {
            System.out.printf("%c and %c are the same.\n", letter1, letter2);
        }
        else
            System.out.printf("%c and %c are not the same\n",letter1, letter2);
        
        
        int i;
        
        
        for(i = 5; i <= 10; i++)
        {
            System.out.printf("i = %d\n", i);
        }
        
        int age = 0;
        
        while( age < 6)
        {
            System.out.printf("age = %d\n", age);
            age++;
        }
      
        System.out.printf("%s %s\n",greeting, name);
    }
    
}
