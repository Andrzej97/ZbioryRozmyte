
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyKosiarka {

    public static void main(String[] args) throws Exception {
        try {
            String fileName = args[0];
            int wysokosc_trawy = Integer.parseInt(args[1]);
            int nierownosc_terenu = Integer.parseInt(args[2]);
            int gestosc_trawy = Integer.parseInt(args[3]);
            FIS fis = FIS.load(fileName,false);

//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("wysokosc_trawy", wysokosc_trawy);
            fuzzyRuleSet.setVariable("nierownosc_terenu", nierownosc_terenu);
            fuzzyRuleSet.setVariable("gestosc_trawy", gestosc_trawy);
//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("wysokosc_zawieszenia").chartDefuzzifier(true);

//            System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyKosiarka driverKosiarka.fcl int<wysokosc_trawy> int<nierownosc_terenu> int<gestosc_trawy>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyKosiarka driverKosiarka.fcl int<wysokosc_trawy> int<nierownosc_terenu> int<gestosc_trawy>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}