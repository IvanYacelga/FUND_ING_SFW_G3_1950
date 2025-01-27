
package ec.edu.espe.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Andrea Raura,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class E {
    private List<C> relationC;
    private List<D> relationD;

    public E() {
        this.relationC = new ArrayList<>();
        this.relationD = new ArrayList<>();
    }
     public void addRealationC(C c) {
        relationC.add(c);
    }

    public void addRelationD(D d) {
        relationD.add(d);
    }
}
