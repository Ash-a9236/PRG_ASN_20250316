package asha9236.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Tree fileSystem = new Tree();

        //CONSOLE APP///////////////////////////////////////////////////////////////////////////////////////////////////
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
