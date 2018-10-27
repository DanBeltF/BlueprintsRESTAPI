/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author dbeltran
 */
public class Main {
    public static void main(String arg0[]) throws BlueprintNotFoundException{
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        
        Point[] pts = new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)};
        Blueprint bp = new Blueprint("Josh", "Architec", pts);
        Point[] pts2 = new Point[]{new Point(12, 12), new Point(20, 20)};
        Blueprint bp2 = new Blueprint("Josh", "Architec v2", pts2);
        Point[] pts3 = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)};
        Blueprint bp3 = new Blueprint("Clark", "MyFirstDraw", pts3);
        
        bs.addNewBlueprint(bp);
        bs.addNewBlueprint(bp2);
        bs.addNewBlueprint(bp3);
        
        
        System.out.println(bs.getBlueprint("Josh", "Architec"));
        System.out.println(bs.getBlueprint("Josh", "Architec v2"));
        System.out.println(bs.getBlueprint("Clark", "MyFirstDraw"));
        
        System.out.println(bs.getBlueprintsByAuthor("Josh"));
        System.out.println(bs.getBlueprintsByAuthor("Clark"));
        
        System.out.println(bs.getAllBlueprints());
        
        System.out.println(bs.getBlueprint("Josh", "Architec").getPoints().size());
        System.out.println(bs.getBlueprint("Clark", "MyFirstDraw").getPoints().size());

    }
}
