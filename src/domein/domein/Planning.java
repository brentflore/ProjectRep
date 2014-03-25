/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein.domein;

import java.util.ArrayList;
import java.util.List;
import persistance.Mapper;
import persistance.MapperFactory;
import persistance.SoortMapper;

/**
 *
 * @author Anneleen, verbeteren en javadocs door Jelle
 */
public class Planning {

    private long zichtbaarTotInMillis;
    private boolean zichtbaar;

    private Campus campus;

    private List<Presentatie> presentaties;

    public Planning() {
        
    }

    /**
     * deze methode maakt de planning ofwel zichtbaar ofwel niet, en stelt de
     * tijd in dat de planning zichtbaar blijft
     *
     * @param toggleOn
     * @param zichtbaarheidInUren
     */
    public void toggleZichtbaarheid(boolean toggleOn, int zichtbaarheidInUren) {

        if (toggleOn) {
            zichtbaar = true;
            setZichtbaarTotInMillis(System.currentTimeMillis() + ((zichtbaarheidInUren * 3600) * 1000));
        }
        if (!toggleOn) {
            zichtbaar = false;
        }

        /**
         * Anneleen, je zal waarschijnlijk best gewoon de tijd bijhouden waarop
         * dit is ingegeven + de tijd bijrekenen dat het zichtbaar moet zijn die
         * tijd steek je dan in een variabele, die gechecked wordt om te zien of
         * de planning nog steeds zichtbaar is.
         *
         * kijk in de buurt van timeInMillis(), 1 sec = 1000ms, dus 1 uur =
         * 3.600.000 ms dan zou het zijn, timeInMillis()+
         * 3600000*zichtbaarheidInUren
         *
         * -Jelle
         *
         */
    }

    public void setZichtbaarTotInMillis(long zichtbaarTotInMillis) {
        this.zichtbaarTotInMillis = zichtbaarTotInMillis;
    }

    public boolean isZichtbaar() {
        return zichtbaar;
    }

    public String geefZichtbaarheidsPeriodeString() {
        if (isZichtbaar()) {
            long tijd = System.currentTimeMillis() - zichtbaarTotInMillis;
            long seconden = tijd / 1000;
            long minuten = seconden / 60;
            long uren = minuten / 60;
            long dagen = uren / 24;

            return "De planning is nog zichtbaar voor " + dagen + " dagen "
                    + uren + " uren " + minuten + " minuten " + seconden + " seconden.";
        } else {
            return " De planning is niet meer zichtbaar.";
        }
    }

    public long geefZichtbaarheidsPeriodeInMillis() {
        if (isZichtbaar()) {
            return System.currentTimeMillis() - zichtbaarTotInMillis;
        }
        return 0;
    }

    public void addPresentatie(Presentatie presentatie) {
        presentaties.add(presentatie);
    }

    public void haalPresentatiesOp() {
        if (presentaties == null) {
            Mapper mapper = MapperFactory.geefMapper(SoortMapper.PRESENTATIE);
            presentaties = (List<Presentatie>) mapper.geefLijst();
        }
    }

    public int geefAantalPresentaties() {
        haalPresentatiesOp();
        return presentaties.size();
    }

    public Presentatie geefPresentatie(int rij) {
       return presentaties.get(rij);
    }

}
