import FactoryPrototype.factories.AppleFactory;
import FactoryPrototype.factories.HPFactory;
import FactoryPrototype.factories.LenovoFactory;
import FactoryPrototype.factories.PositivoFactory;
import FactoryPrototype.interfaces.IComputerFactory;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, IComputerFactory> factories = new HashMap();

        factories.put("Apple", new AppleFactory());
        factories.put("HP", new HPFactory());
        factories.put("Lenovo", new LenovoFactory());
        factories.put("Positivo", new PositivoFactory());

        int iteratorValue = 0;

        while (iteratorValue == 0) {

            System.out.println("\nOlá, eu sou uma montadora de computadores.\n");

            System.out.println("Digite a letra correspondente para a marca que você deseja: "
                    + "\nDigite a letra A para fazer um computador da Apple"
                    + "\nDigite a letra H para fazer um computador da HP"
                    + "\nDigite a letra L para fazer um computador da Lenovo"
                    + "\nDigite a letra P para fazer um computador da Positivo\n");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();

            switch (input) {
                case "a":
                    printComputer(factories.get("Apple"));
                    break;
                case "h":
                    printComputer(factories.get("HP"));
                    break;
                case "l":
                    printComputer(factories.get("Lenovo"));
                    break;
                case "p":
                    printComputer(factories.get("Positivo"));
                    break;
                default:
                    iteratorValue = 1;
                    break;
            }

        }
    }

    public static void printComputer(IComputerFactory selectedFactory) {
        System.out.println("\n" + selectedFactory.create("Disk").toString());
        System.out.println(selectedFactory.create("Memory").toString());
        System.out.println(selectedFactory.create("Processor").toString());
    }

}
