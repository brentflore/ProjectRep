package domein.domein;

import domein.tableModel.PromotorTableModel;
import domein.tableModel.SoortTableModel;
import domein.tableModel.StudentTableModel;
import domein.tableModel.TestTableModel;
import javax.swing.table.AbstractTableModel;

public class TableModelFactory 
{
    
    public static AbstractTableModel createTableModel(SoortTableModel soort, Controller controller)
	{
		switch (soort) 
		{
		case STUDENT:
			StudentTableModel studentTableModel = new StudentTableModel(controller.getCampus());
			studentTableModel.addObserver(controller);
			return studentTableModel;
		case PROMOTOR:
			PromotorTableModel promotorTableModel= new PromotorTableModel(controller.getCampus());
			//controller.addObserver(promotorTableModel);
                        promotorTableModel.addObserver(controller);
			return promotorTableModel;
                
		case TEST:
			TestTableModel testTableModel= new TestTableModel(controller.getCampus());
			//controller.addObserver(promotorTableModel);
                       // testTableModel.addObserver(controller);
			return testTableModel;

		default: return null;
		}
	}
}