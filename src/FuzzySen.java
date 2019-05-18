
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzySen {

    public static void main(String[] args) throws Exception {
        try {
            String fileName = args[0];
            float dlugosc_snu_poprzedniej_nocy = Float.parseFloat(args[1]);
            int poziom_zmeczenia = Integer.parseInt(args[2]);
            int ilosc_obowiazkow = Integer.parseInt(args[3]);
            FIS fis = FIS.load(fileName,false);

//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("dlugosc_snu_poprzedniej_nocy", dlugosc_snu_poprzedniej_nocy);
            fuzzyRuleSet.setVariable("poziom_zmeczenia", poziom_zmeczenia);
            fuzzyRuleSet.setVariable("ilosc_obowiazkow", ilosc_obowiazkow);
//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("dlugosc_drzemki").chartDefuzzifier(true);

//            System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzySen driverSen.fcl float<dlugosc_snu_poprzedniej_nocy> int<poziom_zmeczemia> int<ilosc_obowiazkow>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzySen driverSen.fcl float<dlugosc_snu_poprzedniej_nocy> int<poziom_zmeczemia> int<ilosc_obowiazkow>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}