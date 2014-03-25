package gui;

import domein.domein.CampusController;
import domein.domein.PlanningController;

public class GuiController // Moet volgorde van de schermen kennen
{    
    public GuiController()
    {
        maakScherm(SoortScherm.LOGIN);
    }
    
    public void maakScherm(SoortScherm soort)
    {
        switch (soort) 
        {
            case LOGIN:     new LoginFrame(this); break;
            case KOPPEL:    new BPCFrame(new CampusController()); break;
            case PLANNING:  new PlanningFrame(new PlanningController()); break;
            default:        System.out.println("Soort scherm onbekend");
	}
    }
}
