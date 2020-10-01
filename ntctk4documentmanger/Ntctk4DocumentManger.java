/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4documentmanger;

/**
 *
 * @author Nathan
 */
public class Ntctk4DocumentManger {

   
    public static void main(String[] args)
    {
       Document document1 = new Document("Another Life", "Sally Smith");
       
       document1.setBody("The grass is always greener on the other side.");
       
       Document document2 = new Document("Final Word", "Kare Jones", "We should plan for the worst and hope for the best.");
       
       document2.setTitle("Final Words");
       
       System.out.printf("document1:\ntitle:%s\nauthor:%s\nbody:%s\nversion:%d\n\n", document1.getTitle(), document1.getAuthor(), document1.getBody(), document1.getVersion());
    
       System.out.printf("document2:\ntitle:%s\nauthor:%s\nbody:%s\nversion:%d\n\n", document2.getTitle(), document2.getAuthor(), document2.getBody(), document2.getVersion());
    }
    
}
