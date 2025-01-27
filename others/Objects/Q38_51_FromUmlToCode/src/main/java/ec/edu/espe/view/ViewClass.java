package ec.edu.espe.view;
import ec.edu.espe.controller.ControllerClass;
import ec.edu.espe.model.*;
/**
 *
 * @author Andrea Raura,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class ViewClass {
    
    public static void main(String[] args) {
        
        
        A aInstance = new A();
        B bInstance = new B();
        C cInstance = new C();
        D dInstance = new D();
        E eInstance = new E();
        F fInstance = new F();
        G gInstance = new G();
        J jInstance = new J();


        eInstance.addRealationC(cInstance);
        eInstance.addRelationD(dInstance);
        fInstance.agregarRelacionD(dInstance);
        
        View view = new View();
        javax.swing.text.View View = null;
        ControllerClass controller = new ControllerClass(aInstance, bInstance, cInstance, dInstance, eInstance, fInstance, gInstance, jInstance, View);


  
        view.displayInformation("Instance of A: " + aInstance);
        view.displayInformation("Instance of B: " + bInstance);
        view.displayInformation("Instance of C: " + cInstance);
        view.displayInformation("Instance of D: " + dInstance);
        view.displayInformation("Instance of E: " + eInstance);
        view.displayInformation("Instance of F: " + fInstance);
        view.displayInformation("Instance of G: " + gInstance);
        view.displayInformation("Instance of J: " + jInstance);


        controller.executeLogic();
    }
    
}
