/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domein.domein;

/**
 *
 * @author Jelle (ruwe versie voor de testlogica)
 */
public class PlanningController {
    private Planning planning;

    public PlanningController() {
        planning = new Planning();
    }
    
    
    /**
     * Deze methode maakt een planning zichtbaar voor alle betrokkenen
     * @param duurInUren 
     */
    public void maakPlanningZichtbaar(int duurInUren){
        planning.toggleZichtbaarheid(true, duurInUren);
    }
    
    /**
     * Deze methode maakt een planning onzichtbaar voor alle betrokkenen
     *  
     */
    public void maakPlanningOnzichtbaar(){ 
        planning.toggleZichtbaarheid(false, 0);
    }

    /**
     * Deze methode stelt een planning in.
     * @param planning 
     */
    public void dienPlanningIn(Planning planning) {  
        setPlanning(planning);
    }

    
    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public void addPresentatie(Presentatie presentatie) {
        planning.addPresentatie(presentatie);
    }
    
    
}
