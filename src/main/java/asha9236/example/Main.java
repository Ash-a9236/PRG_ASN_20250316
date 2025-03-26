package asha9236.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
//BASE DATA/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Tree fileSystem = new Tree();

        fileSystem.insertData(new Log("John Doe",      "random message"));
        fileSystem.insertData(new Log("Jane Smith",    "Everything is running smoothly."));
        fileSystem.insertData(new Log("Alice Johnson", "Detected minor fluctuations in power supply."));
        fileSystem.insertData(new Log("Bob Brown",     "Performing routine maintenance on engine systems."));
        fileSystem.insertData(new Log("Charlie Davis", "Initiating communication with ground control."));
        fileSystem.insertData(new Log("Diana Evans",   "Completed system diagnostics, all systems nominal."));
        fileSystem.insertData(new Log("Ethan Harris",  "Preparing for scheduled spacewalk."));
        fileSystem.insertData(new Log("Fiona Clark",   "Monitoring external temperature changes."));
        fileSystem.insertData(new Log("George Lewis",  "Adjusting life support systems for optimal performance."));
        fileSystem.insertData(new Log("Hannah Walker", "Recording astronomical data from telescope."));
        fileSystem.insertData(new Log("Ian Hall",      "Reviewing navigation coordinates for next maneuver."));
        fileSystem.insertData(new Log("John Doe",      "random message"));

        fileSystem.insertData(new Sensor("25"));
        fileSystem.insertData(new Sensor("22"));
        fileSystem.insertData(new Sensor("24"));
        fileSystem.insertData(new Sensor("23"));
        fileSystem.insertData(new Sensor("26"));
        fileSystem.insertData(new Sensor("21"));
        fileSystem.insertData(new Sensor("27"));
        fileSystem.insertData(new Sensor("20"));
        fileSystem.insertData(new Sensor("28"));
        fileSystem.insertData(new Sensor("19"));
        fileSystem.insertData(new Sensor("29"));

        fileSystem.insertData(new Telemetry("95"));
        fileSystem.insertData(new Telemetry("96"));
        fileSystem.insertData(new Telemetry("94"));
        fileSystem.insertData(new Telemetry("97"));
        fileSystem.insertData(new Telemetry("93"));
        fileSystem.insertData(new Telemetry("98"));
        fileSystem.insertData(new Telemetry("92"));
        fileSystem.insertData(new Telemetry("99"));
        fileSystem.insertData(new Telemetry("91"));
        fileSystem.insertData(new Telemetry("100"));
        fileSystem.insertData(new Telemetry("90"));

        fileSystem.printTree();

//CONSOLE APP///////////////////////////////////////////////////////////////////////////////////////////////////////////
        int userAns;
        Scanner console = new Scanner(System.in);
        menu();

        userAns = console.nextInt();
        while (userAns != 6) {
            switch (userAns) {
                case 1:
                    System.out.println("INSERT LOG");
                    System.out.println("Please input the following : ");

                    System.out.print("CREW MEMBER : ");
                    String crewMember = console.next();
                    System.out.print("MESSAGE : ");
                    String message = console.next();

                    Log tempLog = new Log(crewMember, message);
                    fileSystem.insertData(tempLog);

                    menu();
                    String trash = console.next();
                    userAns = console.nextInt();
                    break;
                case 2:
                    System.out.println("INSERT SENSOR");
                    System.out.println("Please input the following : ");

                    System.out.print("CURRENT TEMPERATURE (in °C) : ");
                    String temperature = console.next();

                    Sensor tempSensor = new Sensor(temperature);
                    fileSystem.insertData(tempSensor);

                    menu();
                    trash = console.next();
                    userAns = console.nextInt();
                    break;
                case 3:
                    System.out.println("INSERT TELEMETRY");
                    System.out.println("Please input the following : ");

                    System.out.print("CURRENT TEMPERATURE (in %) : ");
                    String oxygenLvl = console.next();

                    Telemetry tempTelemetry = new Telemetry(oxygenLvl);
                    fileSystem.insertData(tempTelemetry);

                    menu();
                    trash = console.next();
                    userAns = console.nextInt();
                    break;
                case 4:
                    System.out.println("RETRIEVE DATA");
                    System.out.println("Please input the id of the data to be retrieved : ");
                    String id = console.next();

                    fileSystem.searchLeafNode(id).toString();

                    menu();
                    trash = console.next();
                    userAns = console.nextInt();
                    break;
                case 5:
                    System.out.println("DELETE DATA");
                    System.out.println("Please input the id of the data to be deleted : ");
                    id = console.next();

                    fileSystem.deleteLeafNode(id);

                    menu();
                    trash = console.next();
                    userAns = console.nextInt();
                    break;

                default:
                    System.out.println("[ERROR : OPTION NOT VALID]");
                    menu();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("│  1. insert log                  4. retrieve data   │");
        System.out.println("│  2. insert sensor               5. delete data     │");
        System.out.println("│  3. insert telemetry            6. EXIT            │");
        System.out.println("───────────────────────────────────────────────────────");

        System.out.print("\n\n Please input your next action : ");
    }
}
