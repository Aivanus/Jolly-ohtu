/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JollyOhtu;


import org.junit.Test;

/**
 *
 * @author alsu
 */

public class MainTest {
   @Test
   public void mainRuns(){
       Main.main(new String[]{
           "--spring.main.web-environment=false"
       });
   }
}
