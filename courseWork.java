import java.util.Scanner;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

class courseWork{

    //--------Home page Method---------//
    public static void homePage(){
        Scanner scan=new Scanner(System.in);
        System.out.println("			/$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
        System.out.println("			|__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
        System.out.println(" 			/$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
        System.out.println("			| $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
        System.out.println("			| $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
        System.out.println("			| $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
        System.out.println("			| $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
        System.out.println("			|__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/");
        System.out.println("\n\n\n");
        System.out.println("");
        System.out.println("	  ____            _             _           ___                   _");
        System.out.println("	 / ___|          | |           | |         / __ \\                (_)");
        System.out.println("	| |    ___  _ __ | |_ __ _  ___| |_ ___   | |  | |_ __ __ _ _ __  _ _______ _ __");
        System.out
                .println("	| |   / _ \\| '_ \\| __/ _` |/ __| __/ __|  | |  | | '__/ _` | '_ \\| |_  / _ \\ '__|");
        System.out.println("	| |__| (_) | | | | || |_| | |__| |_\\__ \\  | |__| | | | |_| | | | | |/ /  __/ |");
        System.out.println(
                "	 \\____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/   \\____/|_|  \\__, |_| |_|_/___\\___|_|");
        System.out.println("                                                           __/ |");
        System.out.println("                                                          |___/");
        System.out.println();
        System.out.println(
                "===================================================================================================");
        System.out.println("\n");
        System.out.println("[01]ADD Contacts");
        System.out.println("\n");
        System.out.println("[02]UPDATE Contacts");
        System.out.println("\n");
        System.out.println("[03]DELETE Contacts");
        System.out.println("\n");
        System.out.println("[04]SEARCH Contacts");
        System.out.println("\n");
        System.out.println("[05]LIST Contacts");
        System.out.println("\n");
        System.out.println("[06]Exit\n\n");
        System.out.print("Enter an Option to continue ->");
        int option=scan.nextInt();

        switch (option) {
            case 1:
                addContacts();
                break;
        
            case 2:
                // updateContacts();
                // break;
            case 3:
                // deleteContacts();
                // break;
            case 4:
                // searchContact();
                // break;
            case 5:
                listContacts();
                break;
               case 6:
                System.exit(0);
                break;
            default:
                System.out.print("\nThis is not Valid Input. Do you Input Again ->(Y/N) ");
                char ch=scan.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    homePage();
                    break;
                }else if(ch=='N' && ch=='n'){
                    clearConsole();
                    System.exit(0);
                }
        }
        
    }
    //----------Clear Console Method----------//
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
                    if (os.contains("Windows")) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                    }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    //---------List Contact Method----------//
    public static void  listContacts(){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","Contact Id","Name","Phone Number","Company Name","Salary","Birthday");
        for(int i=0;i<idArray.length;i++){
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",idArray[i],phoneArray[i],comNameArray[i],salArray[i],birthdayArray[i]);
        }
    }
    //---------Add Contact Method------------//
    public static void addContacts(){
        Scanner scan=new Scanner(System.in);
       do{
            System.out.println("+----------------------------------------------------------------------------------------------+");
            System.out.println("|                      Add Contacts To The List                                                |");
            System.out.println("+----------------------------------------------------------------------------------------------+");
            System.out.println("\n");
            String id=generateId();
            System.out.println(id);
            System.out.println("==============");
            System.out.print("\nName: ");
            String name=scan.nextLine();
            
            String phoneNum;
             do{
            System.out.print("\nPhone Number: ");
             phoneNum=scan.nextLine();

            if(!isValidPhoneNumber(phoneNum)){
                System.out.println("\nInvalid Phone Number !");
                System.out.print("\nDo you Want to Add Another Phone Number :(Y / N) ");
                char ch=scan.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    System.out.print("\033[4A");
                    System.out.print("\033[0J");
                    continue ;
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    homePage();
                    break;
                }else{
                    System.out.println("Invalid Character !!");
                    clearConsole();
                    homePage();
                }
            }
           }while(!isValidPhoneNumber(phoneNum)); 
           

            System.out.print("\nCompany Name: ");
            String comName=scan.nextLine();
            double sal;
               do{
                System.out.print("\nSalary : ");
                 sal=scan.nextDouble();
    
                if(!isValidSalary(sal)){
                    System.out.println("Invalid Salary Amount!");
                    System.out.print("\nDo you Want to Salary Again :(Y / N) ");
                    char ch=scan.next().charAt(0);
    
                    if(ch=='Y' || ch=='y'){
                        System.out.print("\033[4A");
                        System.out.print("\033[0J");
                        continue;
                    }else if(ch=='N' || ch=='n'){
                        clearConsole();
                        homePage();
                        break;
                    }
                }
            }while(!isValidSalary(sal));
            String birthday;
                do{
                System.out.print("\nB'day (YYYY-MM-DD) : ");
                birthday=scan.next();
    
                if(!isValidBirthDay(birthday)){
                    System.out.println("Invalid Birthday!");
                        System.out.print("\nDo you Want to add Birthday Again :(Y / N) ");
                        char ch=scan.next().charAt(0);
                        
                        if(ch=='Y' || ch=='y'){
                            System.out.print("\033[4A");
                            System.out.print("\033[0J");
                            continue ;
                        }else if(ch=='N' || ch=='n'){
                            clearConsole();
                            homePage();
                            break;
                        }
                }
            }while(!isValidBirthDay(birthday));
           

            extendArray();

            idArray[idArray.length-1]=id;
            nameArray[nameArray.length-1]=name;
            phoneArray[phoneArray.length-1]=phoneNum;
            comNameArray[comNameArray.length-1]=comName;
            salArray[salArray.length-1]=sal;
            birthdayArray[birthdayArray.length-1]=birthday;

            System.out.print("\nDo You Want To Add New Contact :----> (Y / N) ");
            char ch=scan.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                clearConsole();
                addContacts();
                continue ;
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                homePage();
                break;
            }
       }while(true); 
    }
    //----------Generate Id Method-----------//
    public static String generateId(){
        if(idArray.length==0){
            return "C0001";
        }else{
            String lastId=idArray[idArray.length-1];
            int lastNum=Integer.parseInt(lastId.substring(1));
            return String.format("C%03d",lastNum+1);
        }
        
    }
    //---------Create Arrays-------------------//
    public static String idArray[]=new String[0];
    public static String nameArray[]=new String[0];
    public static String phoneArray[]=new String[0];
    public static String comNameArray[]=new String[0];
    public static double salArray[]=new double[0];
    public static String birthdayArray[]=new String[0];
    //----------Exatend Array----------------//
    public final static void extendArray(){
         String tempIdArray[]=new String[idArray.length+1];
         String tempNameArray[]=new String[idArray.length+1];
         String tempPhoneArray[]=new String[phoneArray.length+1];
         String tempComNameArray[]=new String[comNameArray.length+1];
         double tempSalArray[]=new double[salArray.length+1];
         String tempBirthdayArray[]=new String[birthdayArray.length+1];

         for(int i=0;i<idArray.length;i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneArray[i]=phoneArray[i];
            tempComNameArray[i]=comNameArray[i];
            tempSalArray[i]=salArray[i];
            tempBirthdayArray[i]=birthdayArray[i];
         }

         idArray=tempIdArray;
         nameArray=tempNameArray;
         phoneArray=tempPhoneArray;
         comNameArray=tempComNameArray;
         salArray=tempSalArray;
         birthdayArray=tempBirthdayArray;

         System.out.println("\n***Contact has added Succesfully***");
    }
    //----------Valid Phone Number Method-----//
    public static boolean isValidPhoneNumber(String phone){
            if(phone.charAt(0)=='0' && phone.length()==10){
                for(int i=1;i<phone.length();i++){
                    if(!Character.isDigit(phone.charAt(i))){
                        return false;
                    }
                    
                }
                return true;
            }
            return false;
    }
    //-----------Valid Birthday Method---------------//
    public static boolean isValidBirthDay(String birthday){
        String y=birthday.substring(0,4);
        int year=Integer.parseInt(y);
        String m=birthday.substring(5,7);
        int month=Integer.parseInt(m);
        String d=birthday.substring(8, 10);
        int day=Integer.parseInt(d);

        LocalDate currentDate=LocalDate.now();
        int currentYear=currentDate.getYear();
        int currentMonth=currentDate.getMonthValue();
        int currentDay=currentDate.getDayOfMonth();

        if(year%4!=0 && month==2){
            if(day>28){
                return false;
            }
            return true;
        }
        if(year%4==0 && year%100!=0 && month==2){
            if(day>29){
                return false;
            }
            return true;
        }

        if(month==4 || month==6 || month==9 || month==11){
            if(day>30){
                return false;
            }
            if(month>12){
                return false;
            }
            if(year<currentYear){
                return true;
            }else if(year==currentYear){
                if(month<currentMonth){
                    return true;
                }else if(month==currentMonth){
                    if(day<=currentDay){
                        return true;
                    }
                }
            }
         }
         if(month==1 || month==3|| month==5 || month==7 || month==10 || month==12){
            if(day>31){
                return false;
            }
            if(month>12){
                return false;
            }
            if(year<currentYear){
                return true;
            }else if(year==currentYear){
                if(month<currentMonth){
                    return true;
                }else if(month==currentMonth){
                    if(day<=currentDay){
                        return true;
                    }
                }
            }
         }
        return false;
    }
    //------------Valid Salary Method--------------//
    public static boolean isValidSalary(double salary){
        
        if(salary<0){
            return false;
        }
        return true;
    }
    //----------Main Method------------------//
    public static void main(String []args){
        homePage();
    }
}
